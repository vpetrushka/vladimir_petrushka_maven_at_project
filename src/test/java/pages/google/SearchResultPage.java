package pages.google;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String SEARCH_RESULT_FIELD = "//div[@class = 'g']";
    public static final String SEARCH_RESULT_CONTAINING_STRING = "//div[@class = 'g' and contains(.,'%s')]";

    public int getTotalNumberOfSearches(){
        return driver.findElements(By.xpath(SEARCH_RESULT_FIELD)).size();
    }

    public int getSpecificNumberOfSearches(String searchedText){
        return driver.findElements(By.xpath(String.format(SEARCH_RESULT_CONTAINING_STRING,searchedText))).size();
    }
}
