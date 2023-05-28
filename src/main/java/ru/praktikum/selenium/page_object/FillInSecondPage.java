package ru.praktikum.selenium.page_object;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static ru.praktikum.selenium.page_object.MainPage.*;

public class FillInSecondPage {
    public WebDriver driver;
    //про аренду
    public static final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //поле выбора срока аренды
    public static final By durationField =  By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    //чек боксы выбора цвета
    //черный
    public static final By BLACK_COLOUR = By.id("black");
    //серый
    public static final By GREY_COLOUR = By.id("grey");
    //поле ввода комментария
    public static final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать"
    public static final By finalOrderButton = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text()='Заказать']");
    //кнопка подтверждения заказа - "ДА"
    public static final By confirmationButton =  By.xpath(".//div[starts-with(@class,'Order_Buttons')]/button[text()='Да']");
    //окно информации о заказе
    public static final By confirmationWindow = By.xpath(".//div[starts-with(@class,'Order_ModalHeader')]");

    //выпадающий список продолжительности аренды
    //один день
    public static final  By ONE_DAY_RENT = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    //двое суток
    public static final  By TWO_DAYS_RENT = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");

    //заполнить вторую страницу заказа
    public FillInSecondPage(WebDriver driver) {
        this.driver = driver;
    }
    private final static String successfulOrder = "Заказ оформлен";

    public void fillInSecondPageTabs(String date,By numberOfDays,By ScooterColour, String comment){
        driver.findElement(dateField).sendKeys(date, Keys.ENTER);
        driver.findElement(durationField).click();
        driver.findElement(numberOfDays).click();
        driver.findElement(ScooterColour).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(finalOrderButton).click();
        driver.findElement(confirmationButton).click();
        }

    public void checkIsDisplayedConfirmationWindow(){
        var isDisplayedConfirm = driver.findElement(confirmationWindow).getText();
        MatcherAssert.assertThat(isDisplayedConfirm, containsString(successfulOrder));

    }

}
