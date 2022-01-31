package com.selenide.example.steps;

import io.qameta.allure.Step;

public class UserFormSteps extends BaseSteps {

    @Step("Verify that user is successfully navigate to 'User Form'.")
    public void verifyUserSuccessfullyNavigateToUserForm() {
        userFormPage.userFormTitleIsDisplayed("User Form");
    }

    @Step("Verify that 'User Form' page is displayed correctly.")
    public void verifyUserFormPageIsDisplayedCorrectly() {
        userFormPage
                .userFormTitleIsDisplayed("User Form")
                .hasLabelsForInputsAndDropdown()
                .hasGenderLabel()
                .hasLanguagesKnownLabel();
    }

    @Step("Verify JavaScript alert.")
    public void verifyJavaScriptAlertWorksCorrectly() {
        userFormPage.clickGenerateButton();
        userFormPage.submitJavaScriptAlert();
        userFormPage.userFormTitleIsDisplayed("User Form");
    }

    @Step("Sign out from site.")
    public void signOut() {
        userFormPage.clickSignOutButton();
    }
}
