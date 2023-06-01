package com.automationexercise.pageobjects.infopages;

import com.automationexercise.pageobjects.BasePage;
import com.automationexercise.pageobjects.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountConfirmationPage extends BasePage {

    public CreateAccountConfirmationPage(WebDriver driver) {
        super(driver);
    }

    By accCreatedHeadline = By.xpath("//h2[@data-qa='account-created']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    @Step("Getting registration info header")
    public String getHeadline(){
        return findElement(accCreatedHeadline).getText();
    }

    @Step("Navigating to home page")
    public HomePage clickContinueBtn(){
        clickElement(continueBtn);
        return new HomePage(driver);
    }


}
