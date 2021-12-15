package tests.booking;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.MainPage;
import utils.performactions.PerformActions;

public class BookingTooltipTest {

    MainPage mainPage = new MainPage();
    PerformActions actions = new PerformActions();

    @Test
    public void bookingCurrencyTooltipTest() {
        mainPage.navigateToMainPage();
        actions.moveToElement(mainPage.getCurrencyField());
        Assert.assertEquals("Incorrect tooltip name", "Choose your currency", mainPage.getCurrencyPopUpText());
    }

    @Test
    public void bookingLanguageTooltipTest() {
        mainPage.navigateToMainPage();
        actions.moveToElement(mainPage.getLanguageField());
        Assert.assertEquals("Incorrect tooltip name", "Choose your language", mainPage.getLanguagePopUpText());

    }
}