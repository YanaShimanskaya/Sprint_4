package ru.praktikum.selenium.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static ru.praktikum.selenium.config.AppConfig.APP_URL;

public class MainPage {
    private WebDriver webDriver;
    private final int questionNumber;

    //раздел "Вопросы о важном"
    //раскрывающиеся ответы на вопросы
    public static final By BUTTON_SHOW_ANSWER = By.className("accordion__button");

    //текст ответов на вопросы о важном
    public final static String TEXT_ANSWER_HOW = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public final static String TEXT_ANSWER_SOME = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public final static String TEXT_ANSWER_TIME = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public final static String TEXT_ANSWER_TODAY = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public final static String TEXT_ANSWER_EARLY = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public final static String TEXT_ANSWER_CHARGE = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public final static String TEXT_ANSWER_CANCEL = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public final static String TEXT_ANSWER_MKAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //верхняя кнопка "заказать"
    public final static By UPPER_ORDER_BUTTON = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']");
    //нижняя кнопка "заказать"
    public final static By LOWER_ORDER_BUTTON = By.xpath(".//div[starts-with(@class, 'Home_FinishButton')]/button[text()='Заказать']");
    //кнопка "Закрыть куки"
    public final static  By COOKIE_BUTTON = By.xpath(".//button[text()='да все привыкли']");


    public MainPage(WebDriver webDriver, int questionNumber) {
        this.webDriver = webDriver;
        this.questionNumber = questionNumber;
        webDriver.get(APP_URL);
    }

    public MainPage clickOnDropDownElement(){
        List<WebElement> list_elements = webDriver.findElements(BUTTON_SHOW_ANSWER);
        WebElement element = list_elements.get(questionNumber);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();",element);
        element.click();
        return this;
    }

    public String actualText(){
        String answerId = ("accordion__panel-" + questionNumber);
        new WebDriverWait(webDriver, 5_000).until(ExpectedConditions.visibilityOfElementLocated(By.id(answerId)));
        return webDriver.findElement(By.id(answerId)).getText();
    }


}