package com.selenide.example.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserFormTest extends BaseTest {

    @BeforeEach
    public void logInToSite() {
        loginSteps.loginToSite("user", "password");
    }

    @Test
    @Feature("User Form")
    @Owner("Jane")
    @DisplayName("Verify 'User Form' page is displayed correctly")
    public void verifyUserFormPageIsDisplayedCorrectly() {
        userFormSteps.verifyUserFormPageIsDisplayedCorrectly();
    }

    @Test
    @Feature("User Form")
    @Owner("Jane")
    @DisplayName("Verify JavaScript alert works correctly")
    public void verifyAlertWorksCorrectly() {
        userFormSteps.verifyJavaScriptAlertWorksCorrectly();
    }

    @AfterEach
    public void signOut() {
        userFormSteps.signOut();
        Selenide.closeWebDriver();
    }
}
