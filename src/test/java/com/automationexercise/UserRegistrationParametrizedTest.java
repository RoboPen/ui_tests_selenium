package com.automationexercise;

import com.automationexercise.dataproviders.UserRegistrationProvider;
import com.automationexercise.dataproviders.dtos.UserRegistrationFormDto;
import com.automationexercise.pageobjects.enums.Title;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

@Feature("User registration")
public class UserRegistrationParametrizedTest extends BaseTest {

    @Test(groups = {"smoke"}, dataProvider = "registrationData",  dataProviderClass = UserRegistrationProvider.class)
    public void registerUser_validCredentialsGiven_shouldRegisterSuccessfully(UserRegistrationFormDto registrationForm) {
        Title title = registrationForm.getTitle();
        String name = registrationForm.getName();
        String email = registrationForm.getEmail();
        String password = registrationForm.getPassword();
        LocalDate birthDate = registrationForm.getBirthDate();
        String firstName = registrationForm.getFirstName();
        String lastName = registrationForm.getLastName();
        String address = registrationForm.getAddress();
        String country = registrationForm.getCountry();
        String state = registrationForm.getState();
        String city = registrationForm.getCity();
        String zipcode = registrationForm.getZipcode();
        String mobileNumber = registrationForm.getMobileNumber();

        String actualCreateAccountConfirmationText = mainPage.openMainPage()
                .openLoginPage()
                .doSignup(name, email)
                .setTitle(title)
                .setPassword(password)
                .setBirthDate(birthDate)
                .setAddress(firstName, lastName, address, country, state, city, zipcode, mobileNumber)
                .submitForm()
                .getHeadline();

        Assert.assertEquals(actualCreateAccountConfirmationText, "ACCOUNT CREATED!");
    }
}
