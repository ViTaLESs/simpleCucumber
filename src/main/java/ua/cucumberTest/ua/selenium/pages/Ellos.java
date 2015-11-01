package ua.cucumberTest.ua.selenium.pages;


import ua.cucumberTest.ua.selenium.utils.WebDriverWrapper;
import ua.cucumberTest.ua.selenium.utils.WebElementsActions;

public class Ellos {

    public WebElementsActions web;
    public MainPage mainPage;
    public LoginPage loginPage;

    public Ellos(WebDriverWrapper driver) throws Exception {
        web = new WebElementsActions(driver);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }


}