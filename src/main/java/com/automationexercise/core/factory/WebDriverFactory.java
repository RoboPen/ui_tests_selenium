package com.automationexercise.core.factory;

import com.automationexercise.core.converters.SupportedBrowserConverter;
import com.automationexercise.utils.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> threadLocalDriver
            = ThreadLocal.withInitial(() -> SupportedBrowserConverter.valueOfWebBrowser(new PropertyHolder().readProperty("browser"))
            .getWebDriver());

    public static WebDriver getWebDriver() {
        return threadLocalDriver.get();
    }
}
