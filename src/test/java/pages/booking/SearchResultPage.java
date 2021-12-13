package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchResultPage {

    WebDriver driver = new ChromeDriver();

    public void setMaxValueBudgetSort() {
        driver.findElement(By.xpath("//div[@id = 'searchboxInc']//div[@data-filters-item = 'pri:pri=5']")).click();
    }

    public int getMaxValueBudget() {
        int value = Integer.parseInt(driver.findElement(By.xpath("//div[@id = 'searchboxInc']//div[@data-filters-item = 'pri:pri=5']//div[@data-testid = 'filters-group-label-content']"))
                .getText()
                .replaceAll("\\D", ""));
        return value;
    }

    public void sortByLowestPrice() {
        driver.findElement(By.xpath("//li[@data-id = 'price']")).click();
    }

    public int getCostOfHotel(int propertyNumber) {
        int costOfHotel =
                Integer.parseInt(driver.findElements(By.xpath("//div[@id='search_results_table']//div[@data-testid = 'property-card'][" + propertyNumber + "]//div[@data-testid = 'price-and-discounted-price']/span"))
                        .stream()
                        .reduce((x, y) -> y)
                        .get()
                        .getText()
                        .replaceAll("\\D", ""));
        return costOfHotel;
    }

    public WebElement getSpinner() {
        WebElement spinner = driver.findElement(By.xpath("//div[@data-testid = 'overlay-spinner']"));
        return spinner;
    }

    public WebElement getPropertyCard(int cardNumber) {
        WebElement propertyCard = driver.findElement(By.xpath("//div[@data-testid = 'property-card'][" + cardNumber + "]"));
        return propertyCard;
    }

    public int getNumbersOfHotels() {
        int numberOfHotels = Integer.parseInt(driver.findElement(By.xpath("//h1[contains(text(),'Moscow')]")).getText().replaceAll("\\D", ""));
        return numberOfHotels;
    }

    public void getMaximumRatedHotels() {
        driver.findElement(By.xpath("//div[@id = 'searchboxInc']//div[@data-filters-group = 'review_score']/div[contains(@data-filters-item,'90')]")).click();
    }

    public String getCardHotelLink(int cardNumber){
        String linkToHotel = driver.findElement(By.xpath("//div[@data-testid = 'property-card'][" + cardNumber + "]//a")).getAttribute("href");
        return linkToHotel;
    }
}
