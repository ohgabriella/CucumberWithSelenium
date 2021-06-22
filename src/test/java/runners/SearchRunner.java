package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@AllCenarios",
        features = "src/test/resources/features/search.feature",
        glue = {"steps.search"},
        plugin = {"pretty",
                "html:target/cucumber-pretty.html",
                "json:target/cucumber.json",
                "junit:target/JunitCucumber.json"},
        snippets = CAMELCASE,
        monochrome = true
)
public class SearchRunner {
}
