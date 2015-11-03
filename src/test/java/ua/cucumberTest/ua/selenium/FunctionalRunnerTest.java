package ua.cucumberTest.ua.selenium;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runners.Suite;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty", "html:target/report/", "json:target/cucumber-report.json"},
		features = {"src/test/resources/features/"},
		tags = {"@Login, @Registration"}
		)
public class FunctionalRunnerTest extends TestBase {
	
}
