package ua.cucumberTest.ua.selenium.utils;

/**
 * Created by ViTaLES on 01.11.2015.
 */
public class ClassNameUtil {

    private ClassNameUtil(){}

    public static String getCurrentClassName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e){
            return e.getStackTrace()[1].getClassName();
        }
    }

}
