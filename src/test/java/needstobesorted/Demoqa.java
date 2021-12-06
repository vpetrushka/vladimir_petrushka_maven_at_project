package needstobesorted;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demoqa {

    WebDriver driver = new ChromeDriver();

    @Test
    public void selectDemoQa(){

        driver.navigate().to("https://demoqa.com/select-menu");

        driver.findElement(By.xpath("//div[@id = 'withOptGroup']")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Group 1, option 2')]")).click();

        driver.findElement(By.xpath("//div[@id = 'selectOne']")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Mr.')]")).click();

        WebElement element = driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']"));

        Select select = new Select(element);

        select.selectByValue("9");

        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Black')]")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();

        element = driver.findElement(By.xpath("//select[@id = 'cars']"));

        select = new Select(element);

        select.selectByValue("opel");

    }
}
