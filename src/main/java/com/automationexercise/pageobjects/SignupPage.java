package com.automationexercise.pageobjects;

import com.automationexercise.pageobjects.enums.Title;
import com.automationexercise.pageobjects.infopages.CreateAccConfirmationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class SignupPage extends BasePage {
    protected SignupPage(WebDriver driver) {
        super(driver);
    }

    //Title
    By mrRadioBtn = By.id("id_gender1");
    By mrsRadioBtn = By.id("id_gender2");

    //Account credentials
    By nameInput = By.id("name");
    By emailInput = By.id("email");
    By passwordInput = By.id("password");

    //Date of birth
    By daySelect = By.id("days");
    By monthSelect = By.id("months");
    By yearSelect = By.id("years");

    //Not required options
    By newsletterCheckbox = By.id("newsletter");
    By specialOffersCheckbox = By.id("optin");

    //Address information
    By firstNameInput = By.id("first_name");
    By lastNameInput = By.id("last_name");
    By addressInput = By.id("address1");
    By countrySelect = By.id("country");
    By stateInput = By.id("state");
    By cityInput = By.id("city");
    By zipcodeInput = By.id("zipcode");
    By mobileNumberInput = By.id("mobile_number");

    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    @Step("Setting up the title:{0}")
    public SignupPage setTitle(Title title){
        if(title.equals(Title.MR)){
            selectRadioBtn(mrRadioBtn);
        }
        if(title.equals(Title.MRS)){
            selectRadioBtn(mrsRadioBtn);
        }
        return this;
    }

    @Step("Setting up password:{0}")
    public SignupPage setPassword(String password){
        enterTextIntoTextField(passwordInput, password);
        return this;
    }

    @Step("Setting up birth date:{0}")
    public SignupPage setBirthDate(LocalDate date){
        selectByValue(daySelect, String.valueOf(date.getDayOfMonth()));
        selectByValue(monthSelect, String.valueOf(date.getMonthValue()));
        selectByValue(yearSelect, String.valueOf(date.getYear()));
        return this;
    }

    @Step("Setting up address - first name:{0}, last name{1}, address{2}, country{3}, state{4}, city{5}, zipcode{6}, phone{7}")
    public SignupPage setAddress(String firstName, String lastName, String address,
                                 String country, String state, String city, String zipcode,
                                 String mobileNumber){

        enterTextIntoTextField(firstNameInput, firstName);
        enterTextIntoTextField(lastNameInput, lastName);
        enterTextIntoTextField(addressInput, address);
        selectByValue(countrySelect, country);
        enterTextIntoTextField(stateInput, state);
        enterTextIntoTextField(cityInput, city);
        enterTextIntoTextField(zipcodeInput, zipcode);
        enterTextIntoTextField(mobileNumberInput, mobileNumber);
        return this;
    }

    @Step("Submitting registration form")
    public CreateAccConfirmationPage submitForm(){
        clickElement(createAccountBtn);
        return new CreateAccConfirmationPage(driver);
    }



}
