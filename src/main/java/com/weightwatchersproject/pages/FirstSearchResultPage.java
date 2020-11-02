package com.weightwatchersproject.pages;

import com.weightwatchersproject.utils.Helper;
import com.weightwatchersproject.utils.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstSearchResultPage extends PageBase {


    @FindBy(xpath = "//h1[contains(text(),'WW Studio Flatiron')]")
    protected WebElement firstResultLctTitle;

    @FindBy(xpath = "//a[contains(text(),'WW Studio Flatiron')]")
    protected WebElement firstSearchResultTitle;

    //@FindBy(xpath = "//div[@id='main']/div[1]/div[5]//div[3]/div/span[2]")
    //protected List<WebElement> appointment;



    public FirstSearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
       // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }


    public String displayLocationMatchesWithFirstResult() {

        String matchTitle = firstSearchResultTitle.getText();
        Helper.printTextBold("Verify Search Result title: " + matchTitle);
        return matchTitle;
    }

    public boolean verifyLocationTitleMatches(String titleText) {
        String.format("Verify Location title matches with the name of the first searched result", titleText);
        String title = firstResultLctTitle.getText();
        if (title.equals(titleText)) {
            return true;
        } else {
            return false;
        }
    }

    public void getDayHoursOfOperation(String value) {
        scrollDown();
        List<WebElement> days = driver.findElements(By.className("dayName-1UpF5"));
        List<WebElement> hours = driver.findElements(By.className("day-NhBOb"));
        for (int i = 7; i < days.size(); i++) {
            if (value.equalsIgnoreCase(days.get(i).getText())) {
                Helper.printTextBold("Today's day of week and hours : "+hours.get(i).getText());
            }
        }
    }

    public void printMeetings(){
        List<WebElement> appointment = driver.findElements(By.xpath("//div[@id='main']/div[1]/div[5]//div[3]/div/span[2]"));
        List<String> all_elements_text= new ArrayList<>();

        for (int i = 0; i < appointment.size(); i++) {
            //loading text of each element in to array all_elements_text
            all_elements_text.add(appointment.get(i).getText());
        }
        String [] s = new String[all_elements_text.size()];
        s = all_elements_text.toArray(s);
        List<String> output = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        findMeetings(s, output, count);
    }

    private static void findMeetings(String [] s, List<String> output, List<Integer> count){
        Map<String, Long> map = Arrays.stream(s).collect(Collectors
                .groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("*************");
        System.out.println("Person " + map);
    }
}
