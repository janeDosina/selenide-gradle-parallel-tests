package com.selenide.example.extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Browsers.CHROME;

public class SelenoidExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.remote = "http://192.168.0.101:4444/wd/hub";
//        Configuration.baseUrl = "http://192.168.0.101:8080";
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder = "target/downloads";
        Configuration.browser = CHROME;

//        Map<String, Boolean> options = new HashMap<>();
//        options.put("enableVNC", true);
//        options.put("enableVideo", true);
//        options.put("enableLog", true);

        Configuration.browserCapabilities = new ChromeOptions();
//        Configuration.browserCapabilities.setCapability("selenoid:options", options);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
