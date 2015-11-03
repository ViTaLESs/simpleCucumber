package ua.cucumberTest.ua.selenium.utils;


import net.anthavio.phanbedder.Phanbedder;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
       /*
        Need log4j !!!
    */

    public static WebDriver webDriver;
    private static GridInitialization gridInit = null;

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String PHANTOMJS = "phantomjs";
    public static final String HTML_UNIT = "htmlunit";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String LINUX = "linux";

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("browser.platform");
    public static final String hub = PropertyLoader.loadProperty("grid2.hub");


    public WebDriverFactory() {
    }

    /*
	 * Factory method to return a RemoteWebDriver instance given the url of the
	 * Grid hub and a Browser instance.
	 * SetUp grid : browserName, browserVersion, platform.
	 * @setBrowserAndVersion
	 * @setPlatform
	 *
	 * @return WebDriver
	 */
    public static WebDriver getInstance() throws MalformedURLException {

        webDriver = null;

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setJavascriptEnabled(true);

        gridInit = new GridInitialization(browserName, browserVersion, platform);

        setBrowserAndVersion(capability);
        setPlatform(capability);

        webDriver = new RemoteWebDriver(getHubURL(), capability);

        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();

        return webDriver;
    }


    /*
	 * Need log4j !!!
	 */
    /*
	 * Method makes the check and returns hub url
	 */
    public static URL getHubURL() throws MalformedURLException {
        URL hubUrl = new URL(hub);
        // In case there is no Hub
        if (hubUrl == null) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAA NO hub!");
            return null;
        } else {
            return hubUrl;
        }
    }


    /*
     * Factory method to return a WebDriver instance given the browser to hit
     * @param capability : : DesiredCapabilities object coming from getInstance()
     * @param browserName : browserName from PropertyLoader.loadProperty("browser.name");
     * @param browserVersion : browserVersion from PropertyLoader.loadProperty("browser.version");
     *
     * @void : setUp capability
     */
    public static void setBrowserAndVersion(DesiredCapabilities capability, String browserName, String browserVersion) {

        if (CHROME.equals(browserName)) {
            capability.setBrowserName(browserName);

        } else if (FIREFOX.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

        } else if (INTERNET_EXPLORER.equals(browserName)) {
            capability = DesiredCapabilities.internetExplorer();
            capability
                    .setCapability(
                            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                            true);

        } else if (PHANTOMJS.equals(browserName)) {                                 //most likely not work!
            File phantomjs = Phanbedder.unpack();
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());

        } else if (HTML_UNIT.equals(browserName)) {
            capability = DesiredCapabilities.htmlUnit();        //need debug
        }

        if (gridInit.getBrowserVersion() != null) {
            capability.setVersion(browserVersion);
        }
    }


    public static void setBrowserAndVersion(DesiredCapabilities capability) {

        if (CHROME.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.chrome();

        } else if (FIREFOX.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.firefox();
            capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

        } else if (INTERNET_EXPLORER.equals(browserName)) {
            capability = DesiredCapabilities.internetExplorer();
            capability
                    .setCapability(
                            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                            true);

        } else if (PHANTOMJS.equals(browserName)) {                                 // most likely not work
            File phantomjs = Phanbedder.unpack();
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());

        } else if (HTML_UNIT.equals(browserName)) {
            capability = DesiredCapabilities.htmlUnit();        //need debug
        }

        if (gridInit.getBrowserVersion() != null) {
            capability.setVersion(browserVersion);
        }

    }


    /*
     * Helper method to set version and platform for a specific browser
     * @param capability : DesiredCapabilities object coming from getInstance()
     * @param platform : browser platform
     *
     * @void setUp DesiredCapabilities
     */
    private static void setPlatform(DesiredCapabilities capability, String platform) {

        if (LINUX.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.LINUX);

        } else if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS);
        } else {
            capability.setPlatform(Platform.ANY);
        }

    }


    private static void setPlatform(DesiredCapabilities capability) {

        if (LINUX.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.LINUX);
        } else if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS);
        } else {
            capability.setPlatform(Platform.ANY);
        }

    }


    //old version
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
            Assert.fail("invalid driver name");
        }

        driverWripper.manage().deleteAllCookies();
        driverWripper.manage().window().maximize();

        return driverWripper;
    }

}