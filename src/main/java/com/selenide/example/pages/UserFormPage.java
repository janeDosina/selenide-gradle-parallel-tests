package com.selenide.example.pages;

import com.codeborne.selenide.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class UserFormPage extends BasePage implements HasMenuPanel {

    public static final String URL_PAGE_NAME = "User Form";

    private static final SelenideElement
            USER_FORM_TITLE = $x("//form[@id='details']/h2"),
            TITLE_DROPDOWN = $("#TitleId"),
            INITIAL_INPUT = $("#Initial"),
            FIRST_NAME_INPUT = $("#FirstName"),
            MIDDLE_NAME_INPUT = $("#MiddleName"),
            GENDER_LABEL = $x("//input[@type='radio']/parent::node()/preceding-sibling::td/span"),
            GENERATE_BUTTON = $x("//input[@name='generate']"),
            LANGUAGES_KNOWN_LABEL = $x("//input[@type='checkbox']/parent::node()/preceding-sibling::td/span");
    private static final ElementsCollection LABELS_INPUT = $$x("//div[@class='detail_box']/label");

    @Override
    protected Object getPage() {
        return this;
    }

    @Override
    protected String getPageName() {
        return URL_PAGE_NAME;
    }

    public void enterInitialValue(String value) {
        setValueToElement(INITIAL_INPUT, value);
    }

    public void enterFirstNameValue(String value) {
        setValueToElement(FIRST_NAME_INPUT, value);
    }

    public void enterMiddleNameValue(String value) {
        setValueToElement(MIDDLE_NAME_INPUT, value);
    }

    public void selectTitle(String value) {
        selectDropDownValue(TITLE_DROPDOWN, value);
    }

    public UserFormPage userFormTitleIsDisplayed(String value) {
        USER_FORM_TITLE.shouldBe(Condition.visible);
        USER_FORM_TITLE.shouldBe(Condition.text(value));
        return this;
    }

    public UserFormPage hasLabelsForInputsAndDropdown() {
        List<String> expectedValues = List.of("Initial", "First Name *", "Middle Name");
        LABELS_INPUT.shouldHave(CollectionCondition.exactTextsCaseSensitiveInAnyOrder(expectedValues));
        return this;
    }

    public UserFormPage hasGenderLabel() {
        GENDER_LABEL.shouldHave(Condition.text("Gender"));
        return this;
    }

    public UserFormPage hasLanguagesKnownLabel() {
        LANGUAGES_KNOWN_LABEL.shouldHave(Condition.text("Languages Known "));
        return this;
    }

    public void clickGenerateButton() {
        clickByElement(GENERATE_BUTTON);
    }

    public void submitJavaScriptAlert() {
        Selenide.switchTo().alert().accept();
        Selenide.switchTo().alert().accept();
    }

    public void clickSignOutButton() {
        clickByElement(LOGOUT_BUTTON);
    }
}
