package com.automationexercise.pageobjects;

import com.automationexercise.properties.PropertyHolder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    By loginPage = By.xpath("//a[@href='/login']");

    @Step("Navigating to main page")
    public MainPage openMainPage(){
        driver.get(new PropertyHolder().readProperty("base_url"));
        return this;
    }

    @Step("Navigating to login page")
    public LoginPage openLoginPage(){
        clickElement(loginPage);
        return new LoginPage(driver);
    }


}
