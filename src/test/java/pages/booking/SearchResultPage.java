package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    public static final String MAX_VALUE_SORTER = "//div[@id = 'searchboxInc']//div[@data-filters-item = 'pri:pri=5']";
    public static final String MAX_VALUE_LABEL_VALUE = "//div[@id = 'searchboxInc']//div[@data-filters-item = 'pri:pri=5']//div[@data-testid = 'filters-group-label-content']";
    public static final String PRICE_LOWEST_FIRST_BUTTON = "//li[@data-id = 'price']";
    public static final String PROPERTY_CARD_SEARCH_RESULT_PRICE = "//div[@id='search_results_table']//div[@data-testid = 'property-card'][%d]//div[@data-testid = 'price-and-discounted-price']/span";
    public static final String SPINNER = "//div[@data-testid = 'overlay-spinner']";
    public static final String PROPERTY_CARD = "//div[@data-testid = 'property-card'][%d]";
    public static final String SEARCH_ALL_HOTEL_RESULT = "//div[@data-component ='arp-header']//h1";
    public static final String MAXIMUM_RATING = "//div[@id = 'searchboxInc']//div[@data-filters-group = 'review_score']/div[contains(@data-filters-item,'90')]";

    WebDriver driver = BasicDriver.getWebDriver();

    public void setMaxValueBudgetSort() {
        driver.findElement(By.xpath(MAX_VALUE_SORTER)).click();
    }

    public int getMaxValueBudget() {
        return Integer.parseInt(driver.findElement(By.xpath(MAX_VALUE_LABEL_VALUE))
                .getText()
                .replaceAll("\\D", ""));
    }

    public void sortByLowestPrice() {
        driver.findElement(By.xpath(PRICE_LOWEST_FIRST_BUTTON)).click();
    }

    public int getCostOfHotel(int propertyNumber) {
        return Integer.parseInt(driver.findElements(By.xpath(String.format(PROPERTY_CARD_SEARCH_RESULT_PRICE, propertyNumber)))
                .stream()
                .reduce((x, y) -> y)
                .get()
                .getText()
                .replaceAll("\\D", ""));
    }

    public WebElement getSpinner() {
        return driver.findElement(By.xpath(SPINNER));
    }

    public WebElement getPropertyCard(int cardNumber) {
        return driver.findElement(By.xpath(String.format(PROPERTY_CARD, cardNumber)));
    }

    public int getNumbersOfHotels() {
        return Integer.parseInt(driver.findElement(By.xpath(SEARCH_ALL_HOTEL_RESULT)).getText().replaceAll("\\D", ""));
    }

    public void getMaximumRatedHotels() {
        driver.findElement(By.xpath(MAXIMUM_RATING)).click();
    }

    public String getCardHotelLink(int cardNumber) {
        return driver.findElement(By.xpath(String.format(PROPERTY_CARD, cardNumber))).getAttribute("href");
    }

    public void javascriptNavigateIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void javascriptChangeBackgroundColor(String color, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].style.backgroundColor = '%s'", color), element);
    }

    public void javascriptChangeTextColor(String color, WebElement element){
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].style.color = '%s'", color), element);
    }
}
