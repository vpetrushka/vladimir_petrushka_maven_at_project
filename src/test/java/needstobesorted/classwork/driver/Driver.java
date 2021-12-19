package needstobesorted.classwork.driver;

import org.openqa.selenium.WebDriver;

public class Driver extends AbstractDriver {

    public static WebDriver driver;

    private Driver(){
    }

    public static WebDriver getWebDriver(){
        if (null == driver){
            driver = DriverManager.getDriver(config);
        }
        return driver;
    }

   public static void destroy(){
        driver.quit();
        driver = null;
    }
}
