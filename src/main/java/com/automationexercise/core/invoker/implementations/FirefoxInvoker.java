package com.automationexercise.core.invoker.implementations;

import com.automationexercise.core.invoker.FirefoxSetup;
import com.automationexercise.core.invoker.WebDriverInvoker;
import com.automationexercise.properties.PropertyHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxInvoker implements FirefoxSetup, WebDriverInvoker {

    @Override
    public void setIncognitoOption(Object options) {
        if (options instanceof FirefoxOptions firefoxOptions) {
            firefoxOptions.addArguments("--incognito");
        }

    }

    @Override
    public void setHeadlessOption(Object options) {
        if (options instanceof FirefoxOptions firefoxOptions) {
            firefoxOptions.addArguments("--headless");
        }
    }

    @Override
    public WebDriver getWebDriver() {
        PropertyHolder propertyHolder = new PropertyHolder();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();

        if (propertyHolder.readProperty("incognito").equalsIgnoreCase("true")) {
            setIncognitoOption(firefoxOptions);
        }

        if (propertyHolder.readProperty("headless").equalsIgnoreCase("true")) {
            setHeadlessOption(firefoxOptions);
        }

        return new FirefoxDriver(firefoxOptions);
    }
}
