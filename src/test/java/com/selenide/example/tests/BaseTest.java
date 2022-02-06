package com.selenide.example.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.selenide.example.extensions.SelenoidExtension;
import com.selenide.example.steps.LoginSteps;
import com.selenide.example.steps.UserFormSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ScreenShooterExtension.class, SelenoidExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected LoginSteps loginSteps = new LoginSteps();
    protected UserFormSteps userFormSteps = new UserFormSteps();

    @BeforeEach
    public void openBrowser() {
        Selenide.open("https://demosite.executeautomation.com/Login.html");
    }

    @AfterEach
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}
