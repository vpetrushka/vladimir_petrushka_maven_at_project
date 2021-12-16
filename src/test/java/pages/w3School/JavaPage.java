package pages.w3School;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String PAGE_LINK = "https://www.w3schools.com/java/";
    public static final String TUTORIAL_FIELD = "//span[contains(text(),'Tutorial')]";

    public void navigateToPage(){
        driver.navigate().to(PAGE_LINK);
    }

    public WebElement getTutorial(){
        return driver.findElement(By.xpath(TUTORIAL_FIELD));
    }

}