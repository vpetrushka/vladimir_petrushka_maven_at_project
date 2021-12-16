package pages.trashmail;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressManagerPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String NAME = "//td[@data-columnid = 'fe-col-disposable-name']/div";
    public static final String DOMAIN = "//td[@data-columnid = 'fe-col-disposable-domain']/div";
    public static final String ADD = "//span[text()  = 'Add']";

    private String getName() {
        return driver.findElement(By.xpath(NAME)).getText();
    }

    private String getDomain() {
        return driver.findElement(By.xpath(DOMAIN)).getText();
    }

    public String getEmailAddress() {
        return getName() + getDomain();
    }

    public void addNewAddress(){
        driver.findElement(By.xpath(ADD)).click();
    }
}
