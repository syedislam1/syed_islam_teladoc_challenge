package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Features/addUser.feature",
glue={"stepDefinitions"},
monochrome = true)
public class TestRunner {

	
}
