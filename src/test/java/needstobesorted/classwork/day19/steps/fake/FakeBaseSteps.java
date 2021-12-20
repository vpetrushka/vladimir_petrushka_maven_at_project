package needstobesorted.classwork.day19.steps.fake;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import needstobesorted.classwork.driver.Config;
import needstobesorted.classwork.driver.ThreadSafeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FakeBaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Before
    public void beforeTest(){
        LOGGER.info("Initializin Webdriver..");
        ThreadSafeDriver.setConfig(Config.REMOTE);
    }

    @After
    public void afterTest(){
        LOGGER.info("Killing Webdriver..");
        ThreadSafeDriver.destroy();
    }
}
