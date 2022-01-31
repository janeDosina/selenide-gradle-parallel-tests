package com.selenide.example.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    @Feature("Sign In")
    @Owner("Jane")
    @DisplayName("Login to site with successful result")
    public void loginToSiteSuccessfully() {
        loginSteps.enterUserNameValue("user");
        loginSteps.enterPasswordValue("password");
        loginSteps.clickLoginButton();
        userFormSteps.verifyUserSuccessfullyNavigateToUserForm();
        userFormSteps.signOut();
    }

    @Test
    @Feature("Sign In")
    @Owner("Jane")
    @DisplayName("Verify 'Login' page is displayed correctly")
    public void verifyLoginPageIsDisplayedCorrectly() {
        loginSteps.verifyLoginPageDisplayedCorrectly();
    }
}
