package com.automationexercise;

import com.automationexercise.dataproviders.UserLoginProvider;
import com.automationexercise.pageobjects.HomePage;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("User login")
public class UserLoginParametrizedTest extends BaseTest {

    @Test(groups = {"login"}, dataProvider = "loginData", dataProviderClass = UserLoginProvider.class)
    public void loginUser_validCredentialsGiven_shouldLoginSuccessfully(String username, String password, String email, String expectedUserInfo){
        String actualLoggedInUserInfoText = ((HomePage)mainPage.openMainPage()
                .openLoginPage()
                .doLogin(email, password))
                .getLoggedInUserInfoText();

        Assert.assertEquals(actualLoggedInUserInfoText, String.format("%s %s", expectedUserInfo, username));
    }
}
