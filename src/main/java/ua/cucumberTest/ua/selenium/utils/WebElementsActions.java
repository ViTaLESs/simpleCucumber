package ua.cucumberTest.ua.selenium.utils;


import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static ua.cucumberTest.ua.selenium.utils.ConfigData.ui;


/**
 * Class that provides most frequently used steps for working with elements on Web pages
 */
public class WebElementsActions {

    static Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    public static WebDriverWait waitForElement;
    public WebDriverWrapper driver;

    public WebElementsActions(WebDriverWrapper driver) {
        this.driver = driver;
        waitForElement = new WebDriverWait(driver, 30);
    }

    public void clickButton(String buttonLacotor) throws IOException {
        driver.findElement(ui(buttonLacotor)).click();
        log.info("click Button" + buttonLacotor);
    }

    public void clckLink(String linkLocator) throws IOException {
        driver.findElement(ui(linkLocator)).click();
        log.info("click Button" + linkLocator);
    }

    public void input(String inputLocator, String inputData) throws IOException {
        driver.findElement(ui(inputLocator)).clear();
        driver.findElement(ui(inputLocator)).sendKeys(inputData);
        log.info("input - " + inputData + ", to  - " + inputLocator);
    }

    public void inputWithoutCleaning(String inputLocator, String inputData) throws IOException {
        driver.findElement(ui(inputLocator)).sendKeys(inputData);

        log.info("input - " + inputData + ", to  - " + inputLocator);
    }

    /*
     * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) throws IOException {
        driver.findElement(ui(inputLocator)).clear();
        driver.findElement(ui(inputLocator)).sendKeys(inputData);
        log.info("input - " + inputData + ", to  - " + inputLocator);
        driver.findElement(ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("press ENTER button");
    }

    public boolean isElementPresent(String elementLocator) {
        try {
            driver.findElement(ui(elementLocator)).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isAlertPresent() {
        boolean alertPresent = false;
        try {
            Alert alert = driver.switchTo().alert();
            alertPresent = true;
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
        return alertPresent;
    }

    public String getAlertText() {
        String alertText;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
            ex.printStackTrace();
        }
        return alertText;
    }


    public void refreshPage() {
        driver.navigate().refresh();
    }

    public boolean waitForElementPresent(String elementLocator) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        try {
            System.out.println(1);
            waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui(elementLocator)));
        } catch (NoSuchElementException Ex) {
            return false;
        }
        return true;
    }


    public boolean waitForInvisabilityOfElement(String elemeentLocator) {
        try {
            waitForElement.until(ExpectedConditions.invisibilityOfElementLocated(ui(elemeentLocator)));
        } catch (NoSuchElementException Ex) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


}
