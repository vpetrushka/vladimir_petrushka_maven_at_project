package utils.performactions;

import driver.BasicDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PerformActions {

    Actions actions = new Actions(BasicDriver.getWebDriver());
    Actions make = new Actions(BasicDriver.getWebDriver());

    public void moveToElement(WebElement element) {
        actions.moveToElement(element);
        actions.perform();
    }

    public void copyText(WebElement element){
        make.doubleClick(element).keyDown(Keys.LEFT_CONTROL).sendKeys("c").keyUp(Keys.LEFT_CONTROL).build().perform();
    }

    public void pasteText(){
        make.keyDown(Keys.LEFT_CONTROL).sendKeys("v").keyUp(Keys.LEFT_CONTROL).build().perform();
        make.sendKeys(Keys.ENTER).build().perform();
    }
}
