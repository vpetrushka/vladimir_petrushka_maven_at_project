package pages.google;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String PAGE_LINK = "https://google.com";
    public static final String SEARCH_FIELD = "//input[@name = 'q']";

    public void navigateToPage(){
        driver.navigate().to(PAGE_LINK);
    }

    public void getSearchField(){
        driver.findElement(By.xpath(SEARCH_FIELD));
    }
}
