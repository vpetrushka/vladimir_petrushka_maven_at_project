package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public void navigateToMainPage() {
        driver.navigate().to("https://booking.com");
    }

    public void setCity(String city) {
        driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys(city);
    }

    public void setCheckInOut(String dateIn, String dateOut) {
        driver.findElement(By.xpath("//div[@class = 'xp__dates xp__group']")).click();
        driver.findElement(By.xpath(String.format("//td[@data-date = '%s']", dateIn))).click();
        driver.findElement(By.xpath(String.format("//td[@data-date = '%s']", dateOut))).click();
    }

    public void setNumberOfAdults(int number) {

        if (number == 1) {
            performPlusMinusInput("Decrease", number);

        } else if (number > 2 && number < 31) {
            performPlusMinusInput("Increase",number-2);
        }
        driver.close();
    }

    private void performPlusMinusInput(String direction, int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(By.xpath("//span[@class = 'xp__guests__count']")).click();
            driver.findElement(By.xpath(String.format("//button[@aria-label = '%s number of Adults']", direction))).click();
            driver.findElement(By.xpath("//span[contains(.,'and much more')]")).click();
        }
    }

    public void setNumberOfRooms(int number) {
        if (number > 1 && number < 31) {
            driver.findElement(By.xpath("//span[@class = 'xp__guests__count']")).click();
            for (int i = 0; i < number - 1; i++) {
                driver.findElement(By.xpath("//button[@aria-label = 'Increase number of Rooms']")).click();
            }
            driver.findElement(By.xpath("//span[contains(.,'and much more')]")).click();
        } else
            System.out.println("Max number of rooms is 30");
        driver.close();
    }

    public void submitSearch() {
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();
    }

    public WebElement getCurrencyField() {
        WebElement currencyField = driver.findElement(By.xpath("//button[@data-modal-aria-label  = 'Select your currency']"));
        return currencyField;
    }

    public String getCurrencyPopUpText() {
        String currencyPopUpText = driver.findElement(By.xpath("//div[@class= 'bui-tooltip__content']")).getText();
        return currencyPopUpText;
    }

    public WebElement getLanguageField() {
        WebElement languageField = driver.findElement(By.xpath("//button[@data-modal-aria-label  = 'Select your language']"));
        return languageField;
    }

    public String getLanguagePopUpText() {
        String languagePopUpText = driver.findElement(By.xpath("//div[@class= 'bui-tooltip__content']")).getText();
        return languagePopUpText;
    }
}