package ru.praktikum.selenium.page_object;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class FillInSecondPage {
    public WebDriver driver;
    //про аренду
    public static final By DATE_FIELD = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //поле выбора срока аренды
    public static final By DURATION_FIELD =  By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    //чек боксы выбора цвета
    //черный
    public static final By BLACK_COLOUR = By.id("black");
    //серый
    public static final By GREY_COLOUR = By.id("grey");
    //поле ввода комментария
    public static final By COMMENT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать"
    public static final By FINAL_ORDER_BUTTON = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text()='Заказать']");
    //кнопка подтверждения заказа - "ДА"
    public static final By CONFIRMATION_BUTTON =  By.xpath(".//div[starts-with(@class,'Order_Buttons')]/button[text()='Да']");
    //окно информации о заказе
    public static final By CONFIRMATION_WINDOW = By.xpath(".//div[starts-with(@class,'Order_ModalHeader')]");

    //выпадающий список продолжительности аренды
    //один день
    public static final  By ONE_DAY_RENT = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    //двое суток
    public static final  By TWO_DAYS_RENT = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");

    //заполнить вторую страницу заказа
    public FillInSecondPage(WebDriver driver) {
        this.driver = driver;
    }
    private final static String SUCCESSFUL_ORDER = "Заказ оформлен";

    public void fillInSecondPageTabs(String date,By numberOfDays,By ScooterColour, String comment){
        driver.findElement(DATE_FIELD).sendKeys(date, Keys.ENTER);
        driver.findElement(DURATION_FIELD).click();
        driver.findElement(numberOfDays).click();
        driver.findElement(ScooterColour).click();
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
        driver.findElement(FINAL_ORDER_BUTTON).click();
        driver.findElement(CONFIRMATION_BUTTON).click();
        }

    public void checkIsDisplayedConfirmationWindow(){
        var isDisplayedConfirm = driver.findElement(CONFIRMATION_WINDOW).getText();
        MatcherAssert.assertThat(isDisplayedConfirm, containsString(SUCCESSFUL_ORDER));

    }

}
