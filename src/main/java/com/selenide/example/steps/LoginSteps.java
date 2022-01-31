package com.selenide.example.steps;

import io.qameta.allure.Step;

public class LoginSteps extends BaseSteps {

    @Step("Login to site.")
    public void loginToSite(final String userName, final String password) {
        loginPage.enterUserNameValue(userName);
        loginPage.enterPasswordValue(password);
        loginPage.clickLoginButton();
    }

    @Step("Enter user name.")
    public void enterUserNameValue(final String userName) {
        loginPage.enterUserNameValue(userName);
    }

    @Step("Enter user password.")
    public void enterPasswordValue(final String password) {
        loginPage.enterPasswordValue(password);
    }

    @Step("Enter user password.")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("Verify that all necessary fields with text are displayed correctly.")
    public void verifyLoginPageDisplayedCorrectly() {
        loginPage
                .hasLoginTitleTxt()
                .hasUserNameLbl()
                .hasPasswordLbl()
                .loginButtonIsDisplayed();
    }
}
