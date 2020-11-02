package com.weightwatchersFunctionalTest;

import com.weightwatchersproject.pages.FirstSearchResultPage;
import com.weightwatchersproject.utils.ScriptBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class QuestionTwoAnsTest extends ScriptBase {

    String s;
    List<String> output;
    List<Integer> count;

    @Test
    public void automatedTestScenarios() {

        System.out.println("********** Solution 2 *************");
        //1. Navigate to https://www.weightwatchers.com/us/
        //2. Assert loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help | WW USA”
        Assert.assertEquals("WW (Weight Watchers): Weight Loss & Wellness Help | WW USA", driver.getTitle());

        //3. On the right corner of the page, click on “Find a Workshop”
        homePage.clickFindAWorkshop();

        //4. Assert loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
        findAWorkshopPage.assertLoadedPage();

        //5. In the search field, search for meetings for zip code: 10011
        findAWorkshopPage.getSearchForMeetingZipCode();

        //6. Print the title of the first result and the distance (located on the right of location title/name)
        findAWorkshopPage.printFirstSearchResult();

        //7. Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
        findAWorkshopPage.getSearchResultTitleText();
        System.out.println("***** Display Location Matches With First search result that was clicked ******");
        String matchTitle = firstSearchResultPage.displayLocationMatchesWithFirstResult();

        //8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
        FirstSearchResultPage firstSearchResultPage = findAWorkshopPage.clickOnSearchResult();
        Assert.assertTrue(firstSearchResultPage.verifyLocationTitleMatches(matchTitle),
                String.format("Not match location title", matchTitle));
        firstSearchResultPage.getDayHoursOfOperation("TUE");

        /*9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week
        e.g. printMeetings("Sun")
        Output should be:
        Person A  3
        Person B  1*/
       firstSearchResultPage.printMeetings();
    }
    }
