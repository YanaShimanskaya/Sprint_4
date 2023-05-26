package ru.praktikum.selenium.pageObject;

import org.openqa.selenium.*;

import static ru.praktikum.selenium.pageObject.Locators.*;

public class FillInFirstPage {
    private WebDriver driver;
    public FillInFirstPage (WebDriver driver) {
        this.driver = driver;
    }
    //заполнить все поля первой страницы
    public void fillInFirstPageTabs(By button, String firstName, String secondName, String address, String metroStation, String phoneNumber) {
        driver.findElement(cookieButton).click();
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();
        driver.findElement(nameField).sendKeys(firstName);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(phoneField).sendKeys(phoneNumber);
        driver.findElement(nextButton).click();
    }
}
