package com.selenide.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    public static final String URL_PAGE_NAME = "Login.html";

    private static final SelenideElement
            LOGIN_TITLE = $x("//h2"),
            USER_NAME_INPUT = $x("//input[@name='UserName']"),
            PASSWORD_INPUT = $x("//input[@name='Password']"),
            LOGIN_BUTTON = $x("//input[@name='Login']");

    @Override
    protected LoginPage getPage() {
        return this;
    }

    @Override
    protected String getPageName() {
        return URL_PAGE_NAME;
    }

    public void enterUserNameValue(String userName) {
        setValueToElement(USER_NAME_INPUT, userName);
    }

    public void enterPasswordValue(String password) {
        setValueToElement(PASSWORD_INPUT, password);
    }

    public void clickLoginButton() {
        clickByElement(LOGIN_BUTTON);
    }

    public LoginPage hasLoginTitleTxt() {
        LOGIN_TITLE.shouldBe(Condition.visible);
        LOGIN_TITLE.shouldHave(Condition.text("Login"));
        return this;
    }

    public LoginPage hasUserNameLbl() {
        USER_NAME_INPUT.shouldHave(Condition.attribute("name", "UserName"));
        return this;
    }

    public LoginPage hasPasswordLbl() {
        PASSWORD_INPUT.shouldHave(Condition.attribute("name", "Password"));
        return this;
    }

    public LoginPage loginButtonIsDisplayed() {
        LOGIN_BUTTON.shouldBe(Condition.visible);
        LOGIN_BUTTON.shouldHave(Condition.value("Login"));
        return this;
    }

}
