package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private TestPropertiesManager propManager = TestPropertiesManager.getInstance();
    private WebDriver driver = null;
    private static DriverManager INSTANCE = null;

    private DriverManager() {
    }

    public WebDriver getDriver() {
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(propManager.getProperties().getProperty("timeout.implicitly.wait")), TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static DriverManager getDriverManager(){
        if (INSTANCE == null){
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }


}
