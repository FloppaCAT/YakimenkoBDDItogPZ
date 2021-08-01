package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesManager {
    private final Properties properties = new Properties();

    private static TestPropertiesManager INSTANCE = null;

    private TestPropertiesManager(){
        try {
            properties.load(new FileInputStream("src/main/resources/"+System.getProperty("application","application")+".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties);
    }

    public static TestPropertiesManager getInstance() {
        if (INSTANCE == null){
            INSTANCE = new TestPropertiesManager();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}