package com.epam.gomel.taf.framework.ui;

import com.codeborne.selenide.*;
import com.epam.gomel.taf.framework.factory.BrowserFactory;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.epam.gomel.taf.framework.logger.Log.debug;
import static com.epam.gomel.taf.framework.logger.Log.error;

public class SelenideUI /*implements WrapsElement*/ {
    private static final int WAIT_TIMEOUT_MILLIS = 10000;
//    private static final ThreadLocal<SelenideUI> instance = new ThreadLocal<>();
//    private WebElement wrappedWebElement;

    public SelenideUI() {
        setWebDriver(BrowserFactory.getBrowser());
    }

//    public static synchronized SelenideUI getInstance() {
//        if (instance.get() == null) {
//            instance.set(new SelenideUI());
//        }
//        return instance.get();
//    }

//    public WebElement getWrappedElement() {
//        return wrappedWebElement;
//    }

    public void stopBrowser() {
        debug("Close browser");
        try {
            getWebDriver().quit();
        } catch (WebDriverException e) {
            error(e.getMessage());
        } /*finally {
            instance.remove();
        }*/
    }

    public void get(String url) {
        debug("WebDriver opening url: " + url);
        open(url);
    }

    public String getCurrentUrl() {
        String url = getWebDriver().getCurrentUrl();
        debug("Getting current page URL " + url);
        return url;
    }

    public void click(By by) {
        debug("Clicking on " + by);
        $(waitForVisibilityOfElement(by)).click();
    }

    public void doubleClick(By by) {
        debug("Double click " + by);
        actions().doubleClick(waitForVisibilityOfElement(by)).perform();
    }

    public void type(By by, String text) {
        debug("Typing " + text + " into " + by);
        $(waitForVisibilityOfElement(by)).setValue(text);
    }

    public void clear(By by) {
        debug("Clearing field " + by);
        $(by).setValue("");
    }

    public void clearAndType(By by, String value) {
        clear(by);
        type(by, value);
    }

    public boolean isVisible(By by) {
        debug("Checking visibility of element " + by);
        return $(by).isDisplayed();
    }

    public SelenideElement waitForVisibilityOfElement(By by) {
        return $(by).waitUntil(visible, WAIT_TIMEOUT_MILLIS);
    }

    public SelenideElement waitForVisibilityOfElement(By by, long timeout) {
        return $(by).waitUntil(visible, timeout);
    }

    public void clickByJs(By by) {
        debug("Clicking on " + by);
        waitForVisibilityOfElement(by);
        click(by);
//        executeJavaScript("arguments[0].click();", by);
    }

    public SelenideElement scrollToElement(By by) {
        debug("Scrolling to element " + by);
        waitForVisibilityOfElement(by);
//        executeJavaScript("arguments[0].scrollIntoView(true);", by);
        return $(by).scrollTo();
    }

//    @Override
//    public WebDriver getWrappedDriver() {
//        return null;
//    }
}
