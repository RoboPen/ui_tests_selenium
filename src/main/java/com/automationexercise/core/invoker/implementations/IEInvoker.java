package com.automationexercise.core.invoker.implementations;

import com.automationexercise.core.invoker.IESetup;
import com.automationexercise.core.invoker.WebDriverInvoker;
import com.automationexercise.utils.PropertyHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEInvoker implements IESetup, WebDriverInvoker {

    @Override
    public void setIncognitoOption(Object options) {
        if (options instanceof InternetExplorerOptions internetExplorerOptions) {
            internetExplorerOptions.addCommandSwitches("-private");
        }

    }

    @Override
    public WebDriver getWebDriver() {
        PropertyHolder propertyHolder = new PropertyHolder();
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        WebDriverManager.iedriver().setup();

        if (propertyHolder.readProperty("incognito").equalsIgnoreCase("true")) {
            setIncognitoOption(internetExplorerOptions);
        }

        return new InternetExplorerDriver(internetExplorerOptions);
    }
}

