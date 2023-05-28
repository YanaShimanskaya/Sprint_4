package ru.praktikum.selenium.page_object;

import org.openqa.selenium.*;
import static ru.praktikum.selenium.page_object.MainPage.*;

public class FillInFirstPage {
    public WebDriver driver;

    //поле ввода имени
    public static final  By nameField = By.xpath (".//input[@type='text'][@placeholder='* Имя']");
    //поле ввода фамилии
    public static final  By secondNameField = By.xpath(".//input[@type='text'][@placeholder='* Фамилия']");
    //поле ввода адреса
    public static final  By addressField = By.xpath(".//input[@type='text'][@placeholder='* Адрес: куда привезти заказ']");
    //выбор станции метро
    public static final  By metroField = By.cssSelector(".select-search__input");
    //поле ввода номера телефона
    public static final By phoneField = By.xpath(".//input[@type='text'][@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка "далее"
    public static final By nextButton = By.xpath (".//button[text()='Далее']");

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
