package com.weightwatchersproject.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollDown() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1500)");
    }

    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)");
    }

    public void verifyDisplayTitle(String expectedTitle) {
        String title = driver.getTitle();
        Assert.assertEquals(expectedTitle, title);
    }

    //Delay for certain time.

    public void delayFor(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //JS Click Ex
    public void jsClickEx(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("var el = arguments[0];setTimeout(function(){el.click();},100;", element);
    }

    protected boolean isElementDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
