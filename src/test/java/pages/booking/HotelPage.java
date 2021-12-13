package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public double getHotelRating(){
        double hotelRating = Double.parseDouble((driver.findElement(By.xpath("//div[@data-testid = 'review-score-right-component']/div[contains(@aria-label,' ')]")).getText()));
        return hotelRating;
    }
}
