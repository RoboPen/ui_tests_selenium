package com.automationexercise;


import com.automationexercise.core.factory.WebDriverFactory;
import com.automationexercise.pageobjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeTest
    public void setup() {
        driver = WebDriverFactory.getWebDriver();
        mainPage = new MainPage(driver);
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
