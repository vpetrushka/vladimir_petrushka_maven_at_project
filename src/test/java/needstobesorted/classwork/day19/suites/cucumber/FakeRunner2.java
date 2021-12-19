package needstobesorted.classwork.day19.suites.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"needstobesorted.classwork.day19"},
        features = {"src/test/resources/features/fake/FakeTwo.feature"},
        strict = true,
        tags = {""}
)
public class FakeRunner2 {


}
