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

    @Given("^I navigate to the ellos website$")
    public void i_navigate_to_the_ellos_website() throws Throwable {
        log.info("Start Test Suite execution");

        ellos.mainPage.openPage();
        ellos.mainPage.isOpenPage("Logo");
        ellos.mainPage.clickLogo();

    }

    @Given("^I click Logon link$")
    public void i_click_Logon_link() throws Throwable {
        ellos.mainPage.switchToLoginPage();
    }

    @When("^I fill in Email field \"([^\"]*)\"$")
    public void i_fill_in_Email_field_test_test_com(String email) throws IOException {
        ellos.loginPage.fillEmailField(email);
    }

    @When("^I fill in Pass field \"([^\"]*)\"$")
    public void i_fill_in_Pass_field_test(String pass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        ellos.loginPage.fillPasswordField(pass);
    }

    @When("^Click on \"([^\"]*)\"$")
    public void click_on(String buttonLocator) throws IOException {
        ellos.loginPage.clickloginButton(buttonLocator);
    }

    @Then("^I check that Email was filling incorrect$")
    public void i_check_that_Email_was_filling_incorrect() {
        //TODO
    }


}
