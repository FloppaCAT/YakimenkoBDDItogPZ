package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllCategoryPage extends BasePage {

    @FindBy(xpath = "//div[@data-zone-name='menu']")
    WebElement categoryItem;

    @Step("^Выбрана категория {0}")//Электроника
    public SelectedCategoryPage selectCategoryItem(String itemName){
       categoryItem.findElement(By.xpath("//div[@data-zone-data='{\"id\":\"97017420\"}']//span[text()='"+itemName+"']")).click();
       return new SelectedCategoryPage();
    }

}
