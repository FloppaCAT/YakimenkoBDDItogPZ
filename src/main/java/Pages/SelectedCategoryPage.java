package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class SelectedCategoryPage extends BasePage {

    BasePage basePage = new BasePage();

    @FindBy(xpath = "//div[@data-zone-name='new-category-snippet']")
    WebElement typeOfCurrentCategory;

    @Step("Выбрна тип текущей категории - {0}")//Телевизоры
    public AllFiltersPage selectItemOfCurrentCategory(String itemName){
        String indexValue;
        HashMap<String, String> hashMap = basePage.getCategoriesId();
        indexValue = hashMap.get(itemName);
    typeOfCurrentCategory.findElement(By.xpath("//div[@data-zone-data='{\"index\":"+indexValue+",\"title\":\""+itemName+"\"}']")).click();
    return new AllFiltersPage();
    }
}

