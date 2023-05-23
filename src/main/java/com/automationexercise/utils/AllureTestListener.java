package com.automationexercise.utils;

import com.automationexercise.core.factory.WebDriverFactory;
import com.automationexercise.properties.PropertyHolder;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AllureTestListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        boolean shouldScreenshotOnFail = Boolean.parseBoolean(new PropertyHolder().readProperty("screenshot_on_fail"));
        if (shouldScreenshotOnFail && (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN)) {
            if (WebDriverFactory.getWebDriver() != null)
                Allure.addAttachment(String.format("%s - %s",result.getName(), getCurrentTimeAsString()),
                        new ByteArrayInputStream(((TakesScreenshot) WebDriverFactory.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES)));
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }

}
