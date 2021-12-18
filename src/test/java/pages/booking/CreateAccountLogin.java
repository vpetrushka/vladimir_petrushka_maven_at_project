package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountLogin {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String INPUT_EMAIL_FIELD = "//input[@type = 'email']";
    public static final String SUBMIT = "//button[@type = 'submit']";
    public static final String INPUT_PASSWORD = "//input[@name = 'new_password']";
    public static final String CONFIRMED_PASSWORD = "//input[@name = 'confirmed_password']";

    public void inputEmail(String email){
        driver.findElement(By.xpath(INPUT_EMAIL_FIELD)).sendKeys(email);
    }

    public void submitForm(){
        driver.findElement(By.xpath(SUBMIT)).click();
    }

    public void inputPassword(String password){
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(password);
    }

    public void inputPasswordConfirmation(String password){
        driver.findElement(By.xpath(CONFIRMED_PASSWORD)).sendKeys(password);
    }

}