package ru.praktikum.selenium.pageObject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static ru.praktikum.selenium.pageObject.Locators.*;

public class FillInSecondPage {
    private WebDriver driver;

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
