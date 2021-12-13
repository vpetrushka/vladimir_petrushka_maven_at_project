package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage {

    WebDriver driver = new ChromeDriver();

    public void navigateToPage(){
        driver.navigate().to("https://demoqa.com/select-menu");
    }

    public void getSelectValueMenu(){
        driver.findElement(By.xpath("//div[@id = 'withOptGroup']"));
    }

    public void setValueMenu(String name){
        driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]"));
    }

    public void getSelectOneMenu(){
        driver.findElement(By.xpath("//div[@id = 'selectOne']"));
    }

    public void setOneMenu(String name){
        driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]"));
    }

    public void setOldStyleSelectMenu(int value){
        Select select = new Select(driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']")));
        select.selectByValue(String.format("%d",value));
    }

    public void getMultiselectDropDown(){
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]"));
    }

    public void setMultiselectDropDown(String color){
        driver.findElement(By.xpath("//div[contains(text(),'"+color+"')]")).click();
    }

    public void setStandardMultiSelect(String carManufacture){
        Select select = new Select(driver.findElement(By.xpath("//select[@id = 'cars']")));
        select.selectByValue(String.format("%s",carManufacture));
    }
}
