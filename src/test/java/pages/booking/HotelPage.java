package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String SCORE_RATING = "//div[@id = 'reviewFloater']//div[contains(@aria-label,' ')]";
    public static final String REVIEW_FLOATER = "//div[@id = 'reviewFloater']";

    public double getHotelRating() {
        return Double.parseDouble((driver.findElement(By.xpath(SCORE_RATING)).getText()));
    }

    public WebElement getReviewFloater() {
        return driver.findElement(By.xpath(REVIEW_FLOATER));
    }
}
