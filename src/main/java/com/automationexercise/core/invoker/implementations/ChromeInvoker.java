package com.automationexercise.core.invoker.implementations;

import com.automationexercise.core.invoker.ChromeSetup;
import com.automationexercise.core.invoker.WebDriverInvoker;
import com.automationexercise.utils.PropertyHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeInvoker implements ChromeSetup, WebDriverInvoker {

    @Override
    public void setIncognitoOption(Object options) {
        if (options instanceof ChromeOptions chromeOptions) {
            chromeOptions.addArguments("--incognito");
        }

    }

    @Override
    public void setHeadlessOption(Object options) {
        if (options instanceof ChromeOptions chromeOptions) {
            chromeOptions.addArguments("--headless=new");
        }
    }

    @Override
    public WebDriver getWebDriver() {
        PropertyHolder propertyHolder = new PropertyHolder();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();

        if (propertyHolder.readProperty("incognito").equalsIgnoreCase("true")) {
            setIncognitoOption(chromeOptions);
        }

        if (propertyHolder.readProperty("headless").equalsIgnoreCase("true")) {
            setHeadlessOption(chromeOptions);
        }

        return new ChromeDriver(chromeOptions);
    }
}
