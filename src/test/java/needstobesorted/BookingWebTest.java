package needstobesorted;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingWebTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void fontChangerTest() {

        driver.navigate().to("https://booking.com");
        driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("Москва");
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();

        WebElement element = driver.findElement(By.xpath("//div[@data-testid = 'property-card'][10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", element);

        Assert.assertEquals("", "rgba(255, 0, 0, 1)", driver.findElement(By.xpath("//div[@data-testid = 'property-card'][10]")).getCssValue("color"));

        driver.close();
        driver.quit();
    }
}
