package needstobesorted.classwork.day19.steps.fake;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import needstobesorted.classwork.driver.Driver;
import org.junit.Assert;

public class FakeGuiSteps {

    @Given(value = "I go to onliner.by")
    public void checkHeaderTest(){
        Driver.getWebDriver().get("https://onliner.by");
    }

    @When("I start waiting")
    public void checkFooterTest(){
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I just Passed")
    public void verity(){
        Assert.assertTrue(true);
    }
}
