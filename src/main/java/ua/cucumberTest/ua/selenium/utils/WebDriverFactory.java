package ua.cucumberTest.ua.selenium.utils;


import net.anthavio.phanbedder.Phanbedder;
import org.junit.Assert;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class WebDriverFactory {

    public static WebDriverWrapper driverWrapper;

    /*Browsers constants*/
    private static final String FIREFOX = "firefox";
    private static final String INTERNET_EXPLORER = "phantomjs";
    private static final String CHROME = "chrome";
    private static final String HTML_UNIT = "htmlunit";
    private static final String PHANTOMJS = "phantomjs";

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("browser.platform");

    public static final String grid = PropertyLoader.loadProperty("grid2.hub");

    public static final String driverName = PropertyLoader.loadProperty("grid2.hub");

    public WebDriverFactory() {
    }

    public static WebDriverWrapper initDriver(String driverName){
        WebDriverWrapper driverWripper = null;

        if(driverName.equals(FIREFOX)){
            driverWripper = new WebDriverWrapper( new FirefoxDriver());
        }else if(driverName.equals(PHANTOMJS)){
            File phantomjs = Phanbedder.unpack();
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
            driverWripper = new WebDriverWrapper( new PhantomJSDriver(caps));

        } else if(driverName.equals(CHROME)){
            ChromeOptions options = new ChromeOptions();
            driverWripper = new WebDriverWrapper( new ChromeDriver(options));
        }

        else {
            Assert.fail(driverName + " - invalid driver name");
        }

        driverWripper.manage().deleteAllCookies();
        driverWripper.manage().window().maximize();

        return driverWripper;
    }

}
