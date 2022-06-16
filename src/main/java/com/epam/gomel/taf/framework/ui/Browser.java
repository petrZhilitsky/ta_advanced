package com.epam.gomel.taf.framework.ui;

import com.epam.gomel.taf.framework.logger.Log;
import com.epam.gomel.taf.framework.factory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser implements WrapsDriver {
    private static final int WAIT_TIMEOUT_SECONDS = 10;
    private static final ThreadLocal<Browser> instance = new ThreadLocal<>();

    private WebDriver wrappedWebDriver;

    private Browser() {
        wrappedWebDriver = BrowserFactory.getBrowser();
    }

    public static synchronized Browser getInstance() {
        if (instance.get() == null) {
            instance.set(new Browser());
        }
        return instance.get();
    }

    public WebDriver getWrappedDriver() {
        return wrappedWebDriver;
    }

    public void stopBrowser() {
        try {
            if (getWrappedDriver() != null) {
                getWrappedDriver().quit();
            }
        } catch (WebDriverException e) {
            Log.error(e.getMessage());
        } finally {
            instance.remove();
        }
    }

    public void get(String url) {
        Log.debug("Open url: " + url);
        wrappedWebDriver.get(url);
    }

    public String getCurrentUrl() {
        Log.debug("Get current url");
        return wrappedWebDriver.getCurrentUrl();
    }

    public void click(By by) {
        Log.debug("Click " + by);
        WebElement element = waitForVisibilityOfElement(by);
        element.click();
    }

    public void doubleClick(By by) {
        Log.debug("Double click " + by);
        Actions actions = new Actions(wrappedWebDriver);
        WebElement element = waitForVisibilityOfElement(by);
        actions.doubleClick(element).perform();
    }

    public void type(By by, String keys) {
        Log.debug("Type " + keys + " in field" + by);
        WebElement element = waitForVisibilityOfElement(by);
        element.sendKeys(keys);
    }

    public void clear(By by) {
        Log.debug("Clear field " + by);
        wrappedWebDriver.findElement(by).sendKeys(Keys.chord(Keys.LEFT_CONTROL + "a"));
    }

    public boolean isVisible(By by) {
        try {
            waitForVisibilityOfElement(by);
        } catch (WebDriverException e) {
            return false;
        }
        return true;
    }

    public boolean isVisibleNoWait(By by) {
        try {
            waitForVisibilityOfElement(by, 0);
        } catch (WebDriverException e) {
            return false;
        }
        return true;
    }

    public WebElement waitForVisibilityOfElement(By by) {
        Log.debug("Wait for visibility of element " + by);
        return new WebDriverWait(wrappedWebDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibilityOfElement(By by, long timeout) {
        Log.debug("Wait for visibility of element " + by);
        return new WebDriverWait(wrappedWebDriver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement scrollToElementByJs(By by) {
        Log.debug("Scrolling to element " + by);
        WebElement element = waitForVisibilityOfElement(by);
        ((JavascriptExecutor) wrappedWebDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

}
