package tests.booking;

import driver.BasicDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import pages.booking.MainPage;

public class BookingTooltipTest {

    MainPage mainPage = new MainPage();

    @Test
    public void bookingCurrencyTooltipTest() {
        mainPage.navigateToMainPage();
        Actions actions = new Actions(BasicDriver.getWebDriver());
        actions.moveToElement(mainPage.getCurrencyField());
        actions.perform();
        Assert.assertEquals("Incorrect tooltip name", "Choose your currency", mainPage.getCurrencyPopUpText());
    }

    @Test
    public void bookingLanguageTooltipTest() {
        mainPage.navigateToMainPage();
        Actions actions = new Actions(BasicDriver.getWebDriver());
        actions.moveToElement(mainPage.getLanguageField());
        actions.perform();
        Assert.assertEquals("Incorrect tooltip name", "Choose your language", mainPage.getLanguagePopUpText());

    }
}