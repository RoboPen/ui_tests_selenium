package com.automationexercise.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailLoginInput = By.xpath("//input[@data-qa='login-email']");
    By passwordLoginInput = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");

    By nameSignupInput = By.xpath("//input[@data-qa='signup-name']");
    By emailSignupInput = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    By loginErrorMessage = By.xpath("//p[contains(text(), 'email or password')]");

    @Step("Logging in with email:{0}, password:{1}")
    public BasePage doLogin(String email, String password){
        enterTextIntoTextField(emailLoginInput, email);
        enterTextIntoTextField(passwordLoginInput, password);
        clickElement(loginBtn);
        if(driver.getCurrentUrl().equals("https://automationexercise.com/")){
            return new HomePage(driver);
        }
        return this;
    }



    @Step("Navigating to signup page with name:{0}, email:{1}")
    public SignupPage doSignup(String name, String email){
        enterTextIntoTextField(nameSignupInput, name);
        enterTextIntoTextField(emailSignupInput, email);
        clickElement(signupBtn);
        return new SignupPage(driver);
    }

    @Step("Getting login error message")
    public String getLoginErrorMessage(){
        return findElement(loginErrorMessage).getText();
    }

}
