package com.selenide.example.steps;

import com.selenide.example.pages.LoginPage;
import com.selenide.example.pages.UserFormPage;

public class BaseSteps {

    protected LoginPage loginPage = new LoginPage();
    protected UserFormPage userFormPage = new UserFormPage();
}
