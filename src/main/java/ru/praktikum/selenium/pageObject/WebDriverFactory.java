package ru.praktikum.selenium.pageObject;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private final WebDriver webDriver;
    public WebDriverFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}