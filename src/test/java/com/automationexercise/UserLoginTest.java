package com.automationexercise;

import com.automationexercise.pageobjects.HomePage;
import com.automationexercise.pageobjects.LoginPage;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("User login ")
public class UserLoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void loginUser_validCredentialsGiven_shouldLoginSuccessfully(){
        String username = "abc123";
        String password = "abc123";
        String email = "abc123@nonexistent.com";
        String expectedUserInfo = "Logged in as";

        String actualLoggedInUserInfoText = ((HomePage) mainPage.openMainPage()
                .openLoginPage()
                .doLogin(email, password))
                .getLoggedInUserInfoText();

        Assert.assertEquals(actualLoggedInUserInfoText, String.format("%s %s", expectedUserInfo, username));
    }

    @Test(groups = {"smoke"})
    public void loginUser_invalidPasswordGiven_shouldShowErrorMessage(){
        String username = "abc123";
        String password = "invalidPassword";
        String email = "abc123@nonexistent.com";
        String expectedLoginErrorMessage = "Your email or password is incorrect!";

       String actualLoginErrorMessage =  ((LoginPage) mainPage.openMainPage()
                .openLoginPage()
                .doLogin(email, password))
                .getLoginErrorMessage();

       Assert.assertEquals(actualLoginErrorMessage, expectedLoginErrorMessage);
    }

    @Test(groups = {"smoke"})
    public void loginUser_invalidEmailGiven_shouldShowErrorMessage(){
        String username = "abc123";
        String password = "abc123";
        String email = "invalid@email.com";
        String expectedLoginErrorMessage = "Your email or password is incorrect!";

        String actualLoginErrorMessage =  ((LoginPage) mainPage.openMainPage()
                .openLoginPage()
                .doLogin(email, password))
                .getLoginErrorMessage();

        Assert.assertEquals(actualLoginErrorMessage, expectedLoginErrorMessage);
    }
}
