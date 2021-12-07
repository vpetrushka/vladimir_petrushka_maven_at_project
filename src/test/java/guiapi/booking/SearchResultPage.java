package guiapi.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchResultPage {

    WebDriver driver = new ChromeDriver();

    public void maxValueBudgetSort(){
        driver.findElement(By.xpath("//div[@id = 'searchboxInc']//div[@data-filters-item = 'pri:pri=5']")).click();
    }

    public int getMaxValueBudget(){
        int value = Integer.parseInt(driver.findElement(By.xpath("//div[@id = 'searchboxInc']//div[@data-filters-item = 'pri:pri=5']//div[@data-testid = 'filters-group-label-content']"))
                .getText()
                .replaceAll("\\D",""));
        return value;
    }

    public void sortByLowestPrice(){
        driver.findElement(By.xpath("//li[@data-id = 'price']")).click();
    }

    public int getValueOfFirstProperty(){
        int value =
                Integer.parseInt(driver.findElements(By.xpath("//div[@id='search_results_table']//div[@data-testid = 'property-card'][1]//div[@data-testid = 'price-and-discounted-price']/span"))
                        .stream()
                        .reduce((x, y) -> y)
                        .get()
                        .getText()
                        .replaceAll("\\D",""));
        return value;
    }
}
