package needstobesorted.classwork.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver getDriver(Config config) {
        return switch (config != null ? config : Config.CHROME) {
            case FF -> getFFDriver();
            case REMOTE -> getRemoteDriver();
            default -> getChromeDriver();
        };
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions max = new ChromeOptions();
        max.addArguments("start-maximized");
        return new ChromeDriver(max);
    }

    private static WebDriver getFFDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getRemoteDriver() {
        ChromeOptions max = new ChromeOptions();
        max.addArguments("start-maximized");

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), max);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }
}