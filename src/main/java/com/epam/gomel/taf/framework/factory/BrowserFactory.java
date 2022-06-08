package com.epam.gomel.taf.framework.factory;

import com.epam.gomel.taf.framework.exception.WrongBrowserException;
import com.epam.gomel.taf.framework.runner.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    private BrowserFactory() {
    }

    public static WebDriver getBrowser() {
        WebDriver webDriver;
        switch (Parameters.instance().getBrowserType()) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(configureChrome(Parameters.instance().isHeadless()));
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver(configureFirefox(Parameters.instance().isHeadless()));
                webDriver.manage().window().maximize();
            }
            default -> {
                throw new WrongBrowserException("Browser is not supported or wasn't set");
            }
        }
        return webDriver;
    }

    private static ChromeOptions configureChrome(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--ignore-certificate-errors");
        if (isHeadless) {
            options.setHeadless(true);
            options.addArguments("--verbose", "--disable-dev-shm-usage", "--disable-gpu", "--no-sandbox");
            options.addArguments("--window-size=1600, 700");
        }
        return options;
    }

    private static FirefoxOptions configureFirefox(boolean isHeadless) {
        FirefoxOptions options = new FirefoxOptions();
        options.setLogLevel(FirefoxDriverLogLevel.WARN);
        options.setAcceptInsecureCerts(true);
        if (isHeadless) {
            options.setHeadless(true);
        }
        return options;
    }
}
