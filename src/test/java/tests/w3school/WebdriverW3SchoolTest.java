package tests.w3school;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.google.MainPage;
import pages.google.SearchResultPage;
import pages.w3School.JavaPage;
import utils.performactions.PerformActions;

public class WebdriverW3SchoolTest {

    WebDriver driver = new ChromeDriver();
    JavaPage javaPage = new JavaPage();
    MainPage googleMainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    PerformActions performActions = new PerformActions();

    @Test
    public void w3SchoolTest(){

        javaPage.navigateToPage();
        performActions.copyText(javaPage.getTutorial());
        googleMainPage.navigateToPage();
        googleMainPage.getSearchField();
        performActions.pasteText();
        Assert.assertEquals("Number of findings are incorrect",searchResultPage.getTotalNumberOfSearches(),searchResultPage.getSpecificNumberOfSearches("tutorial"));
        driver.close();
        driver.quit();
    }
}