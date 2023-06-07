package com.automationexercise;


import com.automationexercise.core.factory.WebDriverFactory;
import com.automationexercise.pageobjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = WebDriverFactory.getWebDriver();
        mainPage = new MainPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeEach(){
        WebDriverFactory.getWebDriver().manage().deleteAllCookies();
    }
}
