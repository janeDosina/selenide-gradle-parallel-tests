package com.selenide.example.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.selenide.example.steps.LoginSteps;
import com.selenide.example.steps.UserFormSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ScreenShooterExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected LoginSteps loginSteps = new LoginSteps();
    protected UserFormSteps userFormSteps = new UserFormSteps();

    @BeforeAll
    public void setUpTests() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeEach
    public void openBrowser() {
        Selenide.open("https://demosite.executeautomation.com/Login.html");
    }

    @AfterEach
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}
