package com.automationexercise;

import com.automationexercise.pageobjects.enums.Title;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;


@Feature("User registration")
public class UserRegistrationTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void registerUser_validCredentialsGiven_shouldRegisterSuccessfully() {
        Faker faker = new Faker();
        Title title = Title.MR;
        String name = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        LocalDate birthDate = LocalDate.of(1960, 4, 12);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().streetAddress();
        String country = "Canada";
        String state = faker.address().state();
        String city = faker.address().city();
        String zipcode = faker.address().zipCode();
        String mobileNumber = faker.phoneNumber().cellPhone();

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
