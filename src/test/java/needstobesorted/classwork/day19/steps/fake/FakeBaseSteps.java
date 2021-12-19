package needstobesorted.classwork.day19.steps.fake;

import needstobesorted.classwork.driver.Config;
import needstobesorted.classwork.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;

public class FakeBaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Before
    public void beforeTest(){
        LOGGER.info("Initializin Webdriver..");
        Driver.setConfig(Config.CHROME);
    }

    @After
    public void afterTest(){
        LOGGER.info("Killing Webdriver..");
        Driver.destroy();
    }
}
