package ru.praktikum.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.praktikum.selenium.config.AppConfig.APP_URL;
import static ru.praktikum.selenium.pageObject.Locators.*;

@RunWith(Parameterized.class)

public class DropboxQuestions{
    private static WebDriver webDriver;
    private final String description;
    private final int questionNumber;

    @BeforeClass
public static void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage","--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.get(APP_URL);
        }

    public DropboxQuestions(int questionNumber, String description) {
        this.questionNumber = questionNumber;
        this.description = description;
    }

      @Parameterized.Parameters
    public static Object[][] getAnswers() {
        return new Object[][]{
                {0, TEXT_ANSWER_HOW},
                {1, TEXT_ANSWER_SOME},
                {2, TEXT_ANSWER_TIME},
                {3, TEXT_ANSWER_TODAY},
                {4, TEXT_ANSWER_EARLY},
                {5, TEXT_ANSWER_CHARGE},
                {6, TEXT_ANSWER_CANCEL},
                {7, TEXT_ANSWER_MKAD},
        };
    }

    @Test
    public void checkAnswersToImportantQuestions() {
        List <WebElement> list_elements = webDriver.findElements(buttonShowAnswer);
        WebElement element = list_elements.get(questionNumber);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        String answerId = ("accordion__panel-" + questionNumber);
        new WebDriverWait(webDriver, 5_000).until(ExpectedConditions.visibilityOfElementLocated(By.id(answerId)));
        String tagText = webDriver.findElement(By.id(answerId)).getText();
        assertEquals(description, tagText);
    }

    @AfterClass
    public static void clean() {
        webDriver.quit();
    }
}

