package ua.cucumberTest.ua.selenium;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ua.cucumberTest.ua.selenium.utils.WebDriverFactory;
import ua.cucumberTest.ua.selenium.utils.WebDriverWrapper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static ua.cucumberTest.ua.selenium.utils.ConfigData.ui;

/**
 * Created by ViTaLES on 01.11.2015.
 */
public class TestGrid {
    public static RemoteWebDriver remoteWebDriver;
    public static WebDriver driver;
    public static WebDriverWrapper webDriverWrapper;
    public static WebDriverFactory webDriverFactory;

    DesiredCapabilities capability;

    //@Test
    public void remoteTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        webDriverWrapper = new WebDriverWrapper(WebDriverFactory.getInstance());

        webDriverWrapper.get("http://isdev.ellos.se/INTERSHOP/web/WFS/Ellos-EllosSE-Site/sv_SE/-/SEK/Default-Start");
        webDriverWrapper.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        System.out.println("start");

        System.out.println(webDriverWrapper.getCurrentUrl());
        System.out.println(webDriverWrapper.getTitle());
        System.out.println(webDriverWrapper.findElement(ui("Logo")).isDisplayed());
        System.out.println(webDriverWrapper.getPageSource());

        Assert.assertTrue(webDriverWrapper.findElement(ui("Logo")).isDisplayed());
        System.out.println("end");

        webDriverWrapper.quit();

    }

}
