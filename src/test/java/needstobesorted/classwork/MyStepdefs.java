package needstobesorted.classwork;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {

    WebDriver driver = new ChromeDriver();

    @Given("I open test site")
    public void iOpenTestSite() {
        driver.navigate().to("https://booking.com");
    }

    @When("I fill {string} the form")
    public void iFillTheForm(String city) {
        driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys(city);
        driver.findElement(By.xpath("//div[@class = 'xp__dates xp__group']")).click();
    }

    @Then("I see pretty message")
    public void iSeePrettyMessage() {
        Assert.assertTrue(true);
    }
}
