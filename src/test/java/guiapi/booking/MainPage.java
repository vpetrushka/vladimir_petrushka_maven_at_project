package guiapi.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {

    WebDriver driver = new ChromeDriver();

    public void navigateToMainPage(){
        driver.navigate().to("https://booking.com");
    }

    public void setCity(String city){
        driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys(city);
    }

    public void setCheckInOut(String dateIn, String dateOut){
        driver.findElement(By.xpath("//div[@class = 'xp__dates xp__group']")).click();
        driver.findElement(By.xpath(String.format("//td[@data-date = '%s']", dateIn))).click();
        driver.findElement(By.xpath(String.format("//td[@data-date = '%s']", dateOut))).click();
    }

    public void setNumberOfAdults(int number){
        if (number == 1){
            driver.findElement(By.xpath("//span[@class = 'xp__guests__count']")).click();
            driver.findElement(By.xpath("//button[@aria-label = 'Decrease number of Adults']")).click();
            driver.findElement(By.xpath("//span[contains(.,'and much more')]")).click();

        }
        else if (number == 2 ){

        }
        else if (number > 2 && number < 31){
            driver.findElement(By.xpath("//span[@class = 'xp__guests__count']")).click();
            for (int i = 0; i < number - 2; i++) {
                driver.findElement(By.xpath("//button[@aria-label = 'Increase number of Adults']")).click();
            }
            driver.findElement(By.xpath("//span[contains(.,'and much more')]")).click();
        } else
        System.out.println("Max number of adults is 30");
        driver.close();
    }

    public void setNumberOfRooms(int number){
         if (number > 1 && number < 31){
            driver.findElement(By.xpath("//span[@class = 'xp__guests__count']")).click();
            for (int i = 0; i < number - 1; i++) {
                driver.findElement(By.xpath("//button[@aria-label = 'Increase number of Rooms']")).click();
            }
            driver.findElement(By.xpath("//span[contains(.,'and much more')]")).click();
        } else
            System.out.println("Max number of rooms is 30");
        driver.close();
    }

    public void submitSearch(){
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();
    }
}