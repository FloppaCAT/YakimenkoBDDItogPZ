import Util.DriverManager;
import Util.TestPropertiesManager;
import io.cucumber.java.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseTest {
    private static TestPropertiesManager propManager = TestPropertiesManager.getInstance();
    public static WebDriver driver = DriverManager.getDriverManager().getDriver();
    public static String baseUrl;
    public static Properties properties = propManager.getProperties();

    @Before
    public void BeforeTest(){
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.get(baseUrl);
    }

    public void sendText (By locator, String value)
    {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public static void tearDown(){
        driver.quit();
    }

}
