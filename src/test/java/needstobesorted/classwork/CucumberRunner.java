package needstobesorted.classwork;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {},
        features = {"src/test/resources/features/my.feature"},
        strict = true,
        tags = {"@QA"}
)

public class CucumberRunner {
}
