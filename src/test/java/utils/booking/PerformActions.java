package utils.booking;

import driver.BasicDriver;
import org.openqa.selenium.WebElement;

public class PerformActions {

    public void moveToElement(WebElement element) {
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(BasicDriver.getWebDriver());
        actions.moveToElement(element);
        actions.perform();
    }
}
