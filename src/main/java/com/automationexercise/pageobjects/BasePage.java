package com.automationexercise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    protected void enterTextIntoTextField(By by, String text){
        findElement(by).sendKeys(text);
    }

    protected void selectRadioBtn(By by){
        findElement(by).click();
    }

    protected void selectByValue(By by, String value){
        new Select(findElement(by)).selectByValue(value);
    }

    protected void clickElement(By by){
        findElement(by).click();
    }

    protected WebElement findElement(By by){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForElementVisibility(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    protected void waitForElementPresence(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void sleepThread(long miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
