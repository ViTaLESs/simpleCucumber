package ua.cucumberTest.ua.selenium.pages;


import ua.cucumberTest.ua.selenium.utils.PropertyLoader;
import ua.cucumberTest.ua.selenium.utils.WebDriverWrapper;

import java.io.IOException;


public class MainPage extends Page{

    private static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url");


    public MainPage(WebDriverWrapper driver) {
        super(driver, MAIN_PAGE);
    }

    public void clickLogo() throws IOException {
        web.clckLink("Logo");
    }

    public void switchToLoginPage() throws IOException {
        web.clckLink("LoginPageLink");

        if (web.isElementPresent("EmailField")) {
            log.info("SwitchTo Login Page was correct");
        } else {
            log.error("SwitchTo Login Page was Incorrect");
        }
    }


}
