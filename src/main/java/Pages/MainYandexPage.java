package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainYandexPage extends BasePage{

    @FindBy(xpath = "//ul[@class='services-new__list']")
    WebElement menuBarItems;

    @Step("^Выбран пункт меню {0}")//Маркет
    public AllCategoryPage selectMenuBarItem(String itemName){
        String first_handle = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuBarItems.findElement(By.xpath("//DIV[@class='services-new__item-title'][text()='"+itemName+"']")));
        new WebDriverWait(driver,5).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allHandles = driver.getWindowHandles();
        for(String winHandle:allHandles)
        {
            if (!first_handle.equalsIgnoreCase(winHandle))
            {
                driver.switchTo().window(winHandle);
            }
        }
        return new AllCategoryPage();
    }

}
