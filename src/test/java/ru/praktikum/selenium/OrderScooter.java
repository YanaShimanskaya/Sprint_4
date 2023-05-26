package ru.praktikum.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.praktikum.selenium.pageObject.FillInFirstPage;
import ru.praktikum.selenium.pageObject.FillInSecondPage;
import ru.praktikum.selenium.pageObject.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.selenium.config.AppConfig.APP_URL;
import static ru.praktikum.selenium.pageObject.Locators.*;

@RunWith(Parameterized.class)
public class OrderScooter  {
    private static WebDriver webDriver;
    private final By button;
    private String firstName;
    private String secondName;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String date;
    private By ScooterColour;
    private By numberOfDays;
    private String comment;


    public OrderScooter(By button, String firstName, String secondName, String address, String metroStation, String phoneNumber, String date, By numberOfDays, By ScooterColour, String comment) {
        this.button = button;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.numberOfDays = numberOfDays;
        this.ScooterColour = ScooterColour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                { UPPER_ORDER_BUTTON,"Иван", "Иванов", "ул.Маршала Жукова 58, кв. 5", "Динамо", "89251234567", "24.05.23", ONE_DAY_RENT, BLACK_COLOUR,"Позвонить у шлагбаума"},
                { LOWER_ORDER_BUTTON,"Мария", "Марьянова", "ул.Рублева 25, кв 37", "Кунцевская", "89260987654", "25.05.23", TWO_DAYS_RENT, GREY_COLOUR, "буду дома с 10 до 21.00"},
        };
    }

    @Before
    public void init() {
//        WebDriverManager.chromedriver().setup();
// //       Cookie newCookie = new Cookie.Builder("Kuka", "true").domain(APP_URL).build();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--disable-dev-shm-usage","--remote-allow-origins=*");
//        webDriver = new ChromeDriver(options);
//        webDriver.get(APP_URL);

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-fullscreen")
                .addPreference("browser.startup.page", 3)
                .addPreference("browser.startup.homepage", APP_URL);
        webDriver = new FirefoxDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           webDriver.get(APP_URL);

    }

    @Test
    public void testOrderHeaderButton() {

        WebDriverFactory webDriverFactory = new WebDriverFactory(webDriver);
        FillInFirstPage fillInFirstPage = new FillInFirstPage(webDriver);
        FillInSecondPage fillInSecondPage = new FillInSecondPage(webDriver);
        fillInFirstPage.fillInFirstPageTabs(button, firstName, secondName, address, metroStation, phoneNumber);
        fillInSecondPage.fillInSecondPageTabs(date, numberOfDays, ScooterColour, comment);
        fillInSecondPage.checkIsDisplayedConfirmationWindow();

    }

    @After
    public void clean() {
        webDriver.quit();
    }
}
