package ru.praktikum.selenium.page_object;

import org.openqa.selenium.*;
import static ru.praktikum.selenium.page_object.MainPage.*;

public class FillInFirstPage {
    public WebDriver driver;

    //поле ввода имени
    public static final  By NAME_FIELD = By.xpath (".//input[@type='text'][@placeholder='* Имя']");
    //поле ввода фамилии
    public static final  By SECOND_NAME_FIELD = By.xpath(".//input[@type='text'][@placeholder='* Фамилия']");
    //поле ввода адреса
    public static final  By ADDRESS_FIELD = By.xpath(".//input[@type='text'][@placeholder='* Адрес: куда привезти заказ']");
    //выбор станции метро
    public static final  By METRO_FIELD = By.cssSelector(".select-search__input");
    //поле ввода номера телефона
    public static final By PHONE_FIELD = By.xpath(".//input[@type='text'][@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка "далее"
    public static final By NEXT_BUTTON = By.xpath (".//button[text()='Далее']");

    public FillInFirstPage (WebDriver driver) {
        this.driver = driver;
    }
    //заполнить все поля первой страницы
    public void fillInFirstPageTabs(By button, String firstName, String secondName, String address, String metroStation, String phoneNumber) {
        driver.findElement(COOKIE_BUTTON).click();
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();
        driver.findElement(NAME_FIELD).sendKeys(firstName);
        driver.findElement(SECOND_NAME_FIELD).sendKeys(secondName);
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
        driver.findElement(METRO_FIELD).click();
        driver.findElement(METRO_FIELD).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(PHONE_FIELD).sendKeys(phoneNumber);
        driver.findElement(NEXT_BUTTON).click();
    }
}
