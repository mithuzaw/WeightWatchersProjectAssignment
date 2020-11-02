package com.weightwatchersproject.pages;

import com.weightwatchersproject.utils.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase {

    @FindBy(linkText = "Find a Workshop")
    protected WebElement findaWorkshop;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
      //  PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }


    public void clickFindAWorkshop(){
        findaWorkshop.click();
    }

}
