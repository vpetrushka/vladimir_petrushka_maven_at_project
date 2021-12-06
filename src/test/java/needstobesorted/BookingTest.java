package needstobesorted;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BookingTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void checkForDateTest() {

        String dateIn = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dateOut = LocalDate.now().plusDays(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        driver.navigate().to("https://booking.com");
        driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("Paris");
        driver.findElement(By.xpath("//div[@class = 'xp__dates xp__group']")).click();
        driver.findElement(By.xpath(String.format("//td[@data-date = '%s']", dateIn))).click();
        driver.findElement(By.xpath(String.format("//td[@data-date = '%s']", dateOut))).click();
        driver.findElement(By.xpath("//span[@class = 'xp__guests__count']")).click();
        driver.findElement(By.xpath("//button[@aria-label = 'Increase number of Adults']")).click();
        driver.findElement(By.xpath("//button[@aria-label = 'Increase number of Adults']")).click();
        driver.findElement(By.xpath("//button[@aria-label = 'Increase number of Rooms']")).click();
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();
        driver.findElement(By.xpath("//div[@id = 'searchboxInc']//div[@data-filters-item = 'pri:pri=5']")).click();

        String assertValue = Arrays.stream(driver.findElement(By.xpath("//div[@id = 'searchboxInc']//div[@data-filters-item = 'pri:pri=5']//div[@data-testid = 'filters-group-label-content']")).getText().split(" ")).skip(1).findFirst().get();
        int perNight = Integer.parseInt(assertValue.replace(",", ""));

        new WebDriverWait(driver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid = 'overlay-card']"))
        );

        driver.findElement(By.xpath("//li[@data-id = 'price']")).click();

        new WebDriverWait(driver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid = 'overlay-spinner']"))
        );

        String value = Arrays.stream(driver.findElements(By.xpath("//div[@id='search_results_table']//div[@data-testid = 'property-card'][1]//div[@data-testid = 'price-and-discounted-price']/span")).stream().reduce((x, y) -> y).get().getText().split(" ")).skip(1).findFirst().get();
        Assert.assertTrue("Incorrect value", Integer.parseInt(value.replace(",", "")) / 7 >= perNight);

        driver.close();
        driver.quit();

    }
}
