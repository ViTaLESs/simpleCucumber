package ua.cucumberTest.ua.selenium;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import ua.cucumberTest.ua.selenium.pages.Ellos;
import ua.cucumberTest.ua.selenium.utils.ClassNameUtil;
import ua.cucumberTest.ua.selenium.utils.PropertyLoader;
import ua.cucumberTest.ua.selenium.utils.WebDriverFactory;
import ua.cucumberTest.ua.selenium.utils.WebDriverWrapper;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 01.11.2015.
 */
public class TestBase {

    static WebDriverWrapper webDriverWrapper;
    public static Ellos ellos;

    static Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    @BeforeClass
    public static void init() throws MalformedURLException {
        webDriverWrapper = new WebDriverWrapper(WebDriverFactory.getInstance());
        //webDriverWrapper = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));

        webDriverWrapper.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        try {
            ellos = new Ellos(webDriverWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Start tests");

    }


    @AfterClass
    public static void tearDown() {
        webDriverWrapper.quit();
        log.info("Test finished");
    }


}
