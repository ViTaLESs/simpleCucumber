package ua.cucumberTest.ua.selenium.utils;

/**
 * Created by ViTaLES on 01.11.2015.
 */
public class GridInitialization {

    private String browserName;
    private String browserVersion;
    private String platform;

    public GridInitialization(String browserName, String browserVersion, String platform) {
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.platform = platform;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
