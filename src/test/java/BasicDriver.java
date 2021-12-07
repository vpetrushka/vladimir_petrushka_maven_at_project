import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicDriver {

    private static WebDriver webDriver;

    public WebDriver getWebDriver(){
        if(webDriver == null){
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }
}
