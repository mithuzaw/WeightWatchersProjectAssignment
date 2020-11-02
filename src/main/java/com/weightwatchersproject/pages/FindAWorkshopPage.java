package com.weightwatchersproject.pages;

import com.weightwatchersproject.utils.Helper;
import com.weightwatchersproject.utils.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class FindAWorkshopPage extends PageBase {

    @FindBy(xpath = "//input[@id='location-search']")
    protected WebElement searchField;

    @FindBy(id = "location-search-cta")
    protected WebElement searchButtonClick;

    @FindBy(xpath = "//a[contains(text(),'WW Studio Flatiron')]")
    protected WebElement firstSearchResultTitle;

    @FindBy(xpath = "//span[contains(text(),'0.49 mi')]")
    protected WebElement firstSearchResultDistance;

    public FindAWorkshopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
       // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void getSearchForMeetingZipCode(){
        searchField.sendKeys("10011");
        searchButtonClick.click();
    }

    public void printFirstSearchResult(){
        delayFor(500);
        String title = firstSearchResultTitle.getText();
        String distance = firstSearchResultDistance.getText();
        Helper.printTextBold("First Search Result Title: " +title);
        Helper.printTextBold("First Search Result Distance: " + distance);
    }

    public String getSearchResultTitleText() {
        return this.firstSearchResultTitle.getText();
    }

    public FirstSearchResultPage clickOnSearchResult() {
        firstSearchResultTitle.click();
        return new FirstSearchResultPage(driver);
    }

    public void assertLoadedPage(){
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = ("Find WW Studios & Meetings Near You | WW USA");
        //Assert.assertNotEquals(ActualTitle, ExpectedTitle);

    }

}
