package pages.trashmail;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String LOGIN_BUTTON = "//input[@type = 'submit']";

    public void clickLogin(){
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
}
