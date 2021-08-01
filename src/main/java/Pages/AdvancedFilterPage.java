package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class AdvancedFilterPage extends BasePage {

    BasePage basePage = new BasePage();

    @FindBy(xpath = "//div[@data-filter-id='glprice']")
    public WebElement lowerCost;

    @FindBy(xpath = "//div[@data-filter-id='7893318']")
    public WebElement manufacturersFilterBars;

    @FindBy(xpath = "//div[@data-tid='6148972']")
    public WebElement choiceBar;

    @Step("Поле ввода заполнено значением {0}")//20000
    public AdvancedFilterPage fillField(String value) {

        //Аркадий, обрати внимание, так нормально указывать? не смог нормально зацепиться, такое обозначение с выбором
        //первого блока применяется в боевой практике?
        fillField(lowerCost.findElement(By.xpath("(//div[@data-prefix='от']/input[@type='text'])[1]")), value);
        return this;
    }


    @Step("Выбран первый производитель - {0}")//LG
    public AdvancedFilterPage clickFirstManufacturer(String itemName) {
        String mapResult;
        HashMap<String, String> hm = basePage.getTVModelId();
        mapResult = hm.get(itemName);

        System.out.println(mapResult);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", manufacturersFilterBars.findElement(By.xpath("//label[@id='"+mapResult+"']")));

        manufacturersFilterBars.findElement(By.xpath("//label[@id='"+mapResult+"']")).click();
        return this;
    }

    @Step("Выбран второй производитель - {0}")//Samsung
    public AdvancedFilterPage clickSecondManufacterer(String itemName){
        String mapResult;
        HashMap<String, String> hm = basePage.getTVModelId();
        mapResult = hm.get(itemName);

        System.out.println(mapResult);
        manufacturersFilterBars.findElement(By.xpath("//label[@id='"+mapResult+"']")).click();
        return  this;
    }

    @Step("Нажата кнопка подтверждения - {0}")//Показать
    public AllFiltersPage clickAcceptButton(String itemName){
        String attributeText = choiceBar.findElement(By.xpath("//a[contains(text(),'"+itemName+"')]")).getText();
        WebDriverWait wait = new WebDriverWait(driver, 5); // time out after 5 seconds
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(choiceBar.findElement(By.xpath("//a[contains(text(),'"+itemName+"')]")), attributeText)));
        choiceBar.findElement(By.xpath("//a[contains(text(),'"+itemName+"')]")).click();

        return new AllFiltersPage();
    }

    @Step("Введено значение для поиска по фильтрам - {0}")//Beats
    public AdvancedFilterPage fillSearchFilterField (String itemName){
        fillField(manufacturersFilterBars.findElement(By.xpath("//div[@data-filter-id='7893318']//input[@value='']")), itemName);
        return this;
    }

    @Step("Выбран производитель - {0}")
    public AdvancedFilterPage clickCustomManufacterer(String itemName){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", manufacturersFilterBars.findElement(By.xpath("//div[@data-filter-id='7893318']//input[@value='"+itemName+"']")));
        String customSearchAttribute = manufacturersFilterBars.findElement(By.xpath("//div[@data-filter-id='7893318']//label[@id]")).getAttribute("id");
        manufacturersFilterBars.findElement(By.xpath("//div[@data-filter-id='7893318']//label[@id='"+customSearchAttribute+"']")).click();
        return this;
    }
}

