package pages.demoqa;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String SELECT_MENU_PAGE = "https://demoqa.com/select-menu";
    public static final String WITH_OPT_MENU = "//div[@id = 'withOptGroup']";
    public static final String MENU_OPTION_NAME = "//div[contains(text(),'%s')]";
    public static final String SELECT_ONE_MENU = "//div[@id = 'selectOne']";
    public static final String MULTI_SELECT_DROPDOWN = "//div[contains(text(),'Select...')]";
    public static final String OLD_STYLE_MENU = "//select[@id = 'oldSelectMenu']";
    public static final String STANDARD_MULTI_MENU = "//select[@id = 'cars']";

    public void navigateToPage() {
        driver.navigate().to(SELECT_MENU_PAGE);
    }

    public void getMenu(String menu) {
        driver.findElement(By.xpath(menu)).click();
    }

    public void setMenu(String name) {
        driver.findElement(By.xpath(String.format(MENU_OPTION_NAME, name))).click();
    }

    public void setAlternativeMenu(String menu, String value) {
        Select select = new Select(driver.findElement(By.xpath(menu)));
        select.selectByValue(String.format("%s", value));
    }
}
