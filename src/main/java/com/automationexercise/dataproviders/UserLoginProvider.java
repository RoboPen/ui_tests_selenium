package com.automationexercise.dataproviders;

import com.automationexercise.utils.ExcelReader;
import org.testng.annotations.DataProvider;

public class UserLoginProvider {
    @DataProvider(name = "loginData")
    static Object[][] getLoginData() {
        return ExcelReader.getData("src/test/resources/data/login-test.xlsx",
                "login_data");
    }
}
