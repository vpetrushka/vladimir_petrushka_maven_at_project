package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelPage {

    WebDriver driver = new ChromeDriver();

    public double getHotelRating(){
        double hotelRating = Double.parseDouble((driver.findElement(By.xpath("//div[@data-testid = 'review-score-right-component']/div[contains(@aria-label,' ')]")).getText()));
        return hotelRating;
    }
}
