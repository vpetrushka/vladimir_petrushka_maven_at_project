package needstobesorted;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class DateCheckerTest {

    String date;

    public DateCheckerTest(String date) {
        this.date = date;
    }

    @Parameterized.Parameters
    public static List<Object[]> inputData() {

        return
                Arrays.asList(new Object[][]{
                        {LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))},
                        {LocalDate.now().plusDays(17).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))},
                        {LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))},
                        {LocalDate.now().plusDays(45).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}
                });
    }

    @Test
    public void checkForDateTest() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://booking.com");
        driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("Москва");
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();
        driver.findElement(By.xpath(String.format("//td[@data-date = '%s']", date))).click();
        String value = Arrays.stream(driver.findElement(By.xpath("//h1[contains(text(),'Moscow')]")).getText().split(" ")).skip(1).findFirst().get();
        Assert.assertTrue("There is no hotels within that date", Integer.parseInt(value.replaceAll(",", "")) > 0);
        driver.close();
        driver.quit();
    }

    @Test
    public void checkForDateWithRating() {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://booking.com");
        driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("Москва");
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();
        driver.findElement(By.xpath(String.format("//td[@data-date = '%s']", date))).click();
        driver.findElement(By.xpath("//div[@id = 'searchboxInc']//div[@data-filters-group = 'review_score']/div[contains(@data-filters-item,'90')]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String firstSelected = driver.findElement(By.xpath("//div[@data-testid = 'property-card'][1]/div/div/div/a")).getAttribute("href");
        driver.navigate().to(firstSelected);
        double value = Double.parseDouble((driver.findElement(By.xpath("//div[@data-testid = 'review-score-right-component']/div[contains(@aria-label,' ')]")).getText()));
        Assert.assertTrue("Incorrect hotel rating ", value >= 9);
        driver.close();
        driver.quit();
    }
}