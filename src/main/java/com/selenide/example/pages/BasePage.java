package com.selenide.example.pages;

import com.codeborne.selenide.*;
import com.google.common.io.BaseEncoding;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.nio.file.Files;

@Log4j2
public abstract class BasePage<T> {

    protected abstract T getPage();

    protected abstract String getPageName();

    protected T setValueToElement(SelenideElement element, String value) {
        try {
            element.shouldBe(Condition.visible);
        } catch (Exception exception) {
            log.error("Was not found element in page {}", getPageName());
            takeScreenShot(getPageName());
            savePageSource(getPageName());
            throw exception;
        }
        log.info("Set value to field '{}'", element);
        element.sendKeys(value);
        return getPage();
    }

    protected T clickByElement(SelenideElement element) {
        log.info("Click by button '{}'", element);
        element.click();
        return getPage();
    }

    protected T selectDropDownValue(SelenideElement element, String value) {
        log.info("Select drop down value '{}'", value);
        element.selectOption(value);
        return getPage();
    }

    @SneakyThrows
    @Attachment(value = "Screenshot", type = "image/png")
    public static void takeScreenShot(String pageName) {
        File file = Screenshots.takeScreenShotAsFile();
        if (file == null) {
            log.warn("Selenide can't create a screenshot");
        } else {
            log.info("MESSAGE#BASE64#{}#{}",
                    BaseEncoding.base64().encode(Files.readAllBytes(file.toPath())), pageName);
        }
    }

    public static void savePageSource(String pageName) {
        String pageSource = WebDriverRunner.getWebDriver().getPageSource();
        if (pageSource == null) {
            log.warn("Selenide can't save the current page source");
        } else {
            log.info("MESSAGE#FILE#{}#{}", pageSource, String.format("Page source. EU page: %s", pageName));
        }
    }
}
