package com.epam.gomel.taf.framework.ui;

import com.epam.gomel.taf.framework.factory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.gomel.taf.framework.logger.Log.debug;
import static com.epam.gomel.taf.framework.logger.Log.error;

public class SeleniumUI implements WrapsDriver {
    private static final int WAIT_TIMEOUT_SECONDS = 10;
    private static final ThreadLocal<SeleniumUI> instance = new ThreadLocal<>();

    private WebDriver wrappedWebDriver;

    public SeleniumUI() {
        wrappedWebDriver = BrowserFactory.getBrowser();
    }

    public static synchronized SeleniumUI getInstance() {
        if (instance.get() == null) {
            instance.set(new SeleniumUI());
        }
        return instance.get();
    }

    public WebDriver getWrappedDriver() {
        return wrappedWebDriver;
    }

    public void stopBrowser() {
        debug("Close browser");
        try {
            if (getWrappedDriver() != null) {
                getWrappedDriver().quit();
            }
        } catch (WebDriverException e) {
            error(e.getMessage());
        } finally {
            instance.remove();
        }
    }

    public void get(String url) {
        debug("Open url: " + url);
        wrappedWebDriver.get(url);
    }

    public String getCurrentUrl() {
        debug("Get current url");
        return wrappedWebDriver.getCurrentUrl();
    }

    public void click(By by) {
        debug("Click " + by);
        WebElement element = waitForVisibilityOfElement(by);
        element.click();
    }

    public void doubleClick(By by) {
        debug("Double click " + by);
        Actions actions = new Actions(wrappedWebDriver);
        WebElement element = waitForVisibilityOfElement(by);
        actions.doubleClick(element).perform();
    }

    public void type(By by, String keys) {
        debug("Type " + keys + " in field" + by);
        WebElement element = waitForVisibilityOfElement(by);
        element.sendKeys(keys);
    }

    public void clear(By by) {
        debug("Clear field " + by);
        wrappedWebDriver.findElement(by).sendKeys(Keys.chord(Keys.LEFT_CONTROL + "a"));
    }

    public void clearAndType(By by, String value) {
        clear(by);
        type(by, value);
    }

    public boolean isVisible(By by) {
        try {
            waitForVisibilityOfElement(by);
        } catch (WebDriverException e) {
            return false;
        }
        return true;
    }

    public WebElement waitForVisibilityOfElement(By by) {
        debug("Wait for visibility of element " + by);
        return new WebDriverWait(wrappedWebDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForVisibilityOfElement(By by, long timeout) {
        debug("Wait for visibility of element " + by);
        new WebDriverWait(wrappedWebDriver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
