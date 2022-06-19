package com.epam.gomel.taf.framework.ui;

import com.codeborne.selenide.*;
import com.epam.gomel.taf.framework.factory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.ClickOptions.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.epam.gomel.taf.framework.logger.Log.debug;
import static com.epam.gomel.taf.framework.logger.Log.error;

public class SelenideUI {
    private static final ThreadLocal<SelenideUI> instance = new ThreadLocal<>();
    private WebDriver wrappedWebDriver;

    public SelenideUI() {
        wrappedWebDriver = BrowserFactory.getBrowser();
        setWebDriver(wrappedWebDriver);
    }

    public static synchronized SelenideUI getInstance() {
        if (instance.get() == null) {
            instance.set(new SelenideUI());
        }
        return instance.get();
    }

    public void stopBrowser() {
        debug("Close browser");
        try {
            Selenide.closeWebDriver();
        } catch (WebDriverException e) {
            error(e.getMessage());
        } finally {
            instance.remove();
        }
    }

    public void get(String url) {
        debug("WebDriver opening url: " + url);
        open(url);
    }

    public void click(By by) {
        debug("Clicking on " + by);
        $(by).click();
    }

    public void type(By by, String text) {
        debug("Typing " + text + " into " + by);
        $(by).sendKeys(text);
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


    public void clickByJs(By by) {
        debug("Clicking on " + by);
        $(by).click(usingJavaScript());
    }

    public SelenideElement scrollToElement(By by) {
        debug("Scrolling to element " + by);
        return $(by).scrollTo();
    }

    public void dragAndDrop(By by, int xOffset, int yOffset) {
        debug("Dragging " + by + " to (" + xOffset + ";" + yOffset + ")");
        Actions actions = new Actions(wrappedWebDriver);
        actions.dragAndDropBy(wrappedWebDriver.findElement(by), xOffset, yOffset).perform();
    }

    public String getElementAttribute(By by, String attribute) {
        return $(by).attr(attribute);

    }
}
