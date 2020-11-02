package com.weightwatchersproject.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    private static WebDriver driver;

    public static void waitUtilVisible(WebElement element, Integer timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void printTextBold(String text){
        System.out.println("\033[1m" + text + "\033[0m");
    }
}
