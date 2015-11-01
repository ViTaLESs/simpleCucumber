package ua.cucumberTest.ua.selenium.pages;


import org.junit.Assert;
import ua.cucumberTest.ua.selenium.utils.WebDriverWrapper;

import java.io.IOException;

/**
 * Created by ViTaLES on 01.07.2015.
 */
public class LoginPage extends Page {


    public LoginPage(WebDriverWrapper driver) throws Exception {
        super(driver);
    }

    public void fillEmailField() throws IOException {
        web.input("EmailField", "admin");
    }

    public void fillPasswordField() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        web.clckLink("PassField");
        //web.waitForElementPresent("PassField");

        //System.out.println(web.isElementPresent("PassField"));
        //System.out.println(driver.findElement(ui("PassField")).isEnabled());

        web.inputWithoutCleaning("PassFieldInput", "admin");
    }

    public void clickloginButton() throws IOException {
        web.clckLink("LoginButton");

        if (web.isElementPresent("Logo")) {
            //log.info
        } else {

            //log.ree
        }
        Assert.assertTrue("Incorrect work login form", web.isElementPresent("Logo"));
    }


}
