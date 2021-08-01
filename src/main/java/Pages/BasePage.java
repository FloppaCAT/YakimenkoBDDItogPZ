package Pages;

import Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class BasePage {
    protected WebDriver driver = DriverManager.getDriverManager().getDriver();

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public BasePage() {
        PageFactory.initElements(driver, this);
    }


    public void sendText(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    private final HashMap<String, String> tvModelId = new HashMap<>();

    {
        tvModelId.put("Asano", "16657528");
        tvModelId.put("BBK", "152701");
        tvModelId.put("BQ", "10556303");
        tvModelId.put("Erisson", "240924");
        tvModelId.put("HARPER", "11169208");
        tvModelId.put("Hyundai", "16207630");
        tvModelId.put("JVC", "152968");
        tvModelId.put("LG", "153074");
        tvModelId.put("Philips", "14694813");
        tvModelId.put("Samsung", "153061");
        tvModelId.put("Sony", "152955");
        tvModelId.put("TELEFUNKEN", "7347270");
    }


    public HashMap<String, String> getTVModelId() {
        return tvModelId;
    }

    private final HashMap<String, String> categoriesId = new HashMap<>();

    {
        categoriesId.put("Смартфоны", "0");
        categoriesId.put("Телевизоры", "1");
        categoriesId.put("Компьютеры и ноутбуки", "2");
        categoriesId.put("Беспроводные наушники", "3");
        categoriesId.put("Умные часы и браслеты", "4");
        categoriesId.put("Планшеты", "5");
        categoriesId.put("Умные колонки", "6");
        categoriesId.put("Портативная акустика", "7");
    }


    public HashMap<String, String> getCategoriesId() {
        return categoriesId;
    }

}

