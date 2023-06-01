package com.automationexercise.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By loggedInInfo = By.xpath("//a[contains(text(),'Logged in')]");

    @Step("Getting logged in user's info text")
    public String getLoggedInUserInfoText(){
        return findElement(loggedInInfo).getText();
    }
}
