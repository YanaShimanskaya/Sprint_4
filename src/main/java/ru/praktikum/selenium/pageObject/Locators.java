package ru.praktikum.selenium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {
    private WebDriver webDriver;

    //раздел "Вопросы о важном"
    //раскрывающиеся ответы на вопросы
    public static final By buttonShowAnswer = By.className("accordion__button");

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
    //чек боксы выбора цвета
    //черный
    public final static By BLACK_COLOUR = By.id("black");
    //серый
    public final static By GREY_COLOUR = By.id("grey");
    //выпадающий список продолжительности аренды
    //один день
    public final static By ONE_DAY_RENT = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    //двое суток
    public final static By TWO_DAYS_RENT = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]");

    //кнопка "Закрыть куки"
    public final static  By cookieButton = By.className("App_CookieButton__3cvqF");

    //поле ввода имени
    public static final  By nameField = By.cssSelector(".Input_InputContainer__3NykH:nth-child(1) > .Input_Responsible__1jDKN");
    //поле ввода фамилии
    public static final  By secondNameField = By.cssSelector(".Input_InputContainer__3NykH:nth-child(2) > .Input_Input__1iN_Z");
    //поле ввода адреса
    public static final  By addressField = By.cssSelector(".Input_InputContainer__3NykH:nth-child(3) > .Input_Input__1iN_Z");
    //выбор станции метро
    public static final  By metroField = By.cssSelector(".select-search__input");
    //поле ввода номера телефона
    public static final By phoneField = By.cssSelector(".Input_InputContainer__3NykH:nth-child(5) > .Input_Input__1iN_Z");

    //про аренду
    public static final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //поле выбора срока аренды
    public static final By durationField = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    //поле ввода комментария
    public static final By commentField = By.cssSelector(".Input_InputContainer__3NykH > .Input_Responsible__1jDKN");
    //кнопка "Заказать"
    public static final By finalOrderButton = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text()='Заказать']");
    //кнопка подтверждения заказа - "ДА"
    public static final By confirmationButton =  By.xpath(".//div[starts-with(@class,'Order_Buttons')]/button[text()='Да']");
    //окно информации о заказе
    public static final By confirmationWindow = By.xpath(".//div[starts-with(@class,'Order_ModalHeader')]");
    //кнопка "далее"
    public static final By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");
}