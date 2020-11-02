package com.weightwatchersproject.utils;

import com.weightwatchersproject.pages.FindAWorkshopPage;
import com.weightwatchersproject.pages.FirstSearchResultPage;
import com.weightwatchersproject.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScriptBase {

    protected WebDriver driver;
    protected PageBase pageBase;
    protected HomePage homePage;
    protected FindAWorkshopPage findAWorkshopPage;
    protected FirstSearchResultPage firstSearchResultPage;

    //chrome,chromeHeadless,firefox,ie,grid_chrome_16,grid_firefox_16,grid_ie_16
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName", "env"})
    public void beforeMethod(@Optional(value = ("chrome")) String browserName, @Optional(value = ("qa")) String env) throws InterruptedException, IOException {

        driver = DriverFactory.getInstance(browserName).getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        findAWorkshopPage = new FindAWorkshopPage(driver);
        firstSearchResultPage = new FirstSearchResultPage(driver);
        homePage = new HomePage(driver);
        driver.get("https://www.weightwatchers.com/us/");
    }



    @AfterMethod
    public void afterClass() {
        driver = null;
        homePage = null;
        pageBase = null;
        findAWorkshopPage = null;
        firstSearchResultPage = null;

        //     DriverFactory.getInstance().removeDriver();
    }
}
