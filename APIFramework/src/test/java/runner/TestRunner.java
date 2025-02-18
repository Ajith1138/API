package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/ValidatePlaceApi.feature",
glue = "stepdefinition",
plugin = "json:target/jsonReports/cucumber-report.json"
//,tags="@addApi"
)
public class TestRunner {

}
