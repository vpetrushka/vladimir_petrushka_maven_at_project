package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    public static final String BOOKING_WEBSITE = "https://booking.com";
    public static final String CITY_INPUT_FIELD = "//input[@type = 'search']";
    public static final String DATE_SELECTOR_FIELD = "//div[@class = 'xp__dates xp__group']";
    public static final String DATE_IN_CALENDAR = "//td[@data-date = '%s']";
    public static final String GUEST_ROOMS_SELECTOR = "//span[@class = 'xp__guests__count']";
    public static final String PLUS_MINUS = "//button[@aria-label = '%s number of %s']";
    public static final String CLOSE_ALL_POPUPS = "//span[contains(.,'and much more')]";
    public static final String SUBMIT_BUTTON = "//button[@data-sb-id='main']";
    public static final String CURRENCY_BUTTON = "//button[@data-modal-aria-label  = 'Select your currency']";
    public static final String LANGUAGE_BUTTON = "//button[@data-modal-aria-label  = 'Select your language']";
    public static final String TOOLTIP_INFO = "//div[@class= 'bui-tooltip__content']";

    WebDriver driver = BasicDriver.getWebDriver();

    public void navigateToMainPage() {
        driver.navigate().to(BOOKING_WEBSITE);
    }

    public void setCity(String city) {
        driver.findElement(By.xpath(CITY_INPUT_FIELD)).sendKeys(city);
    }

    public void setCheckInOut(String dateIn, String dateOut) {
        driver.findElement(By.xpath(DATE_SELECTOR_FIELD)).click();
        driver.findElement(By.xpath(String.format(DATE_IN_CALENDAR, dateIn))).click();
        driver.findElement(By.xpath(String.format(DATE_IN_CALENDAR, dateOut))).click();
    }

    public void setNumberOfAdults(int number) {

        if (number == 1) {
            performPlusMinusInput("Decrease", "Adults", number);

        } else if (number > 2 && number < 31) {
            performPlusMinusInput("Increase", "Adults", number - 2);
        }
    }

    private void performPlusMinusInput(String direction, String type, int times) {
        driver.findElement(By.xpath(GUEST_ROOMS_SELECTOR)).click();
        for (int i = 0; i < times; i++) {
            driver.findElement(By.xpath(String.format(PLUS_MINUS, direction, type))).click();
        }
        driver.findElement(By.xpath(CLOSE_ALL_POPUPS)).click();
    }

    public void setNumberOfRooms(int number) {
        if (number > 1 && number < 31) {
            performPlusMinusInput("Increase", "Rooms", number - 1);
        }
    }

    public void submitSearch() {
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public WebElement getCurrencyField() {
        return driver.findElement(By.xpath(CURRENCY_BUTTON));
    }

    public String getCurrencyPopUpText() {
        return driver.findElement(By.xpath(TOOLTIP_INFO)).getText();
    }

    public WebElement getLanguageField() {
        return driver.findElement(By.xpath(LANGUAGE_BUTTON));
    }

    public String getLanguagePopUpText() {
        return driver.findElement(By.xpath(TOOLTIP_INFO)).getText();
    }
}