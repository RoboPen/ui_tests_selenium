package com.automationexercise.core.converters;


import com.automationexercise.core.enumeration.SupportedBrowsers;

public class SupportedBrowserConverter {
    public static SupportedBrowsers valueOfWebBrowser(String webBrowserName){
        return switch (webBrowserName) {
            case "chrome" -> SupportedBrowsers.CHROME;
            case "firefox" -> SupportedBrowsers.FIREFOX;
            case "ie" -> SupportedBrowsers.IE;
            default -> throw new IllegalArgumentException("Incorrect browser name");
        };
    }
}
