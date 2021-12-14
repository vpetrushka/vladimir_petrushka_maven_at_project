package tests.booking;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.HotelPage;
import pages.booking.MainPage;
import pages.booking.SearchResultPage;
import utils.booking.DateCreator;
import utils.booking.ExplicitWait;

public class DateCheckerTest {

    MainPage mainPage = new MainPage();
    DateCreator date = new DateCreator();
    SearchResultPage searchResultPage = new SearchResultPage();
    ExplicitWait wait = new ExplicitWait();
    HotelPage hotelPage = new HotelPage();

    @Test
    public void checkForDateTest() {

        mainPage.navigateToMainPage();
        mainPage.setCity("Москва");
        mainPage.setCheckInOut(date.getOffsetDate(3), date.getOffsetDate(10));
        mainPage.submitSearch();
        Assert.assertTrue("There is no hotels within that date", searchResultPage.getNumbersOfHotels() > 0);
    }

    @Test
    public void checkForDateWithRating() {

        mainPage.navigateToMainPage();
        mainPage.setCity("Москва");
        mainPage.setCheckInOut(date.getOffsetDate(3), date.getOffsetDate(10));
        mainPage.submitSearch();
        searchResultPage.getMaximumRatedHotels();
        wait.waitForElement(SearchResultPage.SPINNER);
        searchResultPage.navigateToLink(1);
        Assert.assertTrue("Incorrect hotel rating ", hotelPage.getHotelRating() >= 9);

    }
}