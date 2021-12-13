package tests;

import guiapi.booking.DateCreator;
import guiapi.booking.MainPage;
import guiapi.booking.SearchResultPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static guiapi.BasicDriver.webDriver;

public class PricePerNightFilterTest {

    DateCreator date = new DateCreator();
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();


    @Test
    public void checkForDateTest() {

        String dateIn = date.getOffsetDate(3);
        String dateOut = date.getOffsetDate(10);

        mainPage.navigateToMainPage();
        mainPage.setCity("Paris");
        mainPage.setCheckInOut(dateIn,dateOut);
        mainPage.setNumberOfAdults(4);
        mainPage.setNumberOfRooms(2);
        mainPage.submitSearch();
        searchResultPage.setMaxValueBudgetSort();
        int value = searchResultPage.getMaxValueBudget();

        new WebDriverWait(webDriver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid = 'overlay-card']"))
        );

        searchResultPage.sortByLowestPrice();

        new WebDriverWait(webDriver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid = 'overlay-card']"))
        );

        int cost = searchResultPage.getCostOfHotel(1);
        Assert.assertTrue("Incorrect value", cost / 7 >= value);

        webDriver.close();
        webDriver.quit();

    }
}
