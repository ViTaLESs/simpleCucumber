package ua.cucumberTest.ua.selenium;

import cucumber.api.java.en.*;
import org.junit.*;
import ua.cucumberTest.ua.selenium.pages.LoginPage;
import ua.cucumberTest.ua.selenium.pages.MainPage;
import ua.cucumberTest.ua.selenium.logger.Log4Test;
import ua.cucumberTest.ua.selenium.utils.PropertyLoader;
import ua.cucumberTest.ua.selenium.utils.WebDriverFactory;
import ua.cucumberTest.ua.selenium.utils.WebDriverWrapper;

import java.io.IOException;


public class LoginStepsDefinitions extends TestBase{

    public static WebDriverWrapper driver = webDriverWrapper;

    @Given("^I navigate to the ellos website$")
    public void i_navigate_to_the_ellos_website() throws Throwable {
        log.info("Start Test Suite execution");

        ellos.mainPage.openPage();
        ellos.mainPage.isOpenPage("Logo");
    }

    @Given("^I click Logon link$")
    public void i_click_Logon_link() throws Throwable {

    }

    @When("^I fill in Email field \"([^\"]*)\"$")
    public void i_fill_in_Email_field_test_test_com(String email) {

    }

    @When("^I fill in Pass field \"([^\"]*)\"$")
    public void i_fill_in_Pass_field_test(String pass) {

    }

    @When("^Click on \"([^\"]*)\"$")
    public void click_on(String buttonLocator) {

    }

    @Then("^I check that Email was filling incorrect$")
    public void i_check_that_Email_was_filling_incorrect() {

    }





}