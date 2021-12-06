package needstobesorted;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BookingTooltip {

    WebDriver driver = new ChromeDriver();

    @Test
    public void bookingTooltipTest(){
        driver.navigate().to("https://booking.com");
        WebElement element = driver.findElement(By.xpath("//button[@data-modal-aria-label  = 'Select your currency']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);

        
    }
}
