package Steps;

import Util.DriverManager;
import Util.TestPropertiesManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {

    private static TestPropertiesManager propManager = TestPropertiesManager.getInstance();
    public static WebDriver driver = DriverManager.getDriverManager().getDriver();
    public static String baseUrl;
    public static Properties properties = propManager.getProperties();

    @Before
    public void prepareData() {
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.get(baseUrl);
    }

    @After
    public void clearData() {
        driver.quit();
    }
}
