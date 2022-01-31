package com.selenide.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public interface HasMenuPanel {

    SelenideElement LOGOUT_BUTTON = $x("//a[@href='Login.html']");
}
