package tests.booking;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.MainPage;
import pages.booking.SearchResultPage;

public class BookingWebTest {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @Test
    public void fontChangerTest() {

        mainPage.navigateToMainPage();
        mainPage.setCity("Москва");
        mainPage.submitSearch();
        searchResultPage.javascriptNavigateIntoView(searchResultPage.getPropertyCard(10));
        searchResultPage.javascriptChangeBackgroundColor("green", searchResultPage.getPropertyCard(10));
        searchResultPage.javascriptChangeTextColor("red", searchResultPage.getPropertyCard(10));
        Assert.assertEquals("", "rgba(255, 0, 0, 1)", searchResultPage.getPropertyCard(10).getCssValue("color"));

    }
}