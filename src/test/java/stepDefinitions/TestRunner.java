package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Features/addUser.feature",
glue={"stepDefinitions"},
	plugin = {"pretty",
	"junit:target/MyReport/report.xml"},
	publish = true
	)

public class TestRunner {


}
