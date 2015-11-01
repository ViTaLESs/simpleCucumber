package ua.cucumberTest.ua.selenium.utils;


import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class PropertyLoader {

    private static final String PROPERTY_FILE = "/application.properties";

    private static Map propertiesMap;

    public synchronized static String loadProperty(String name) {

        if (propertiesMap == null) {
            loadAllData();
        }
        return String.valueOf(propertiesMap.get(name));
    }

    private static synchronized void loadAllData() {
        Properties properties = new Properties();
        try {
            properties.load(PropertyLoader.class.getResourceAsStream(PROPERTY_FILE));
            propertiesMap = properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
