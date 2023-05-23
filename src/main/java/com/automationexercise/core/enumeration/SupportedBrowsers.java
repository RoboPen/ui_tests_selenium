package com.automationexercise.core.enumeration;


import com.automationexercise.core.invoker.WebDriverInvoker;
import com.automationexercise.core.invoker.implementations.ChromeInvoker;
import com.automationexercise.core.invoker.implementations.FirefoxInvoker;
import com.automationexercise.core.invoker.implementations.IEInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    FIREFOX(new FirefoxInvoker()),
    CHROME(new ChromeInvoker()),
    IE(new IEInvoker());

    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver(){
        return webDriverInvoker.getWebDriver();
    }
}
