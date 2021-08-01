package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AllFiltersPage extends BasePage {

    @FindBy(xpath = "//div[@id='search-prepack']")//div[@data-zone-name='all-filters-button']//span[text()='Все фильтры']
    public WebElement filterItem;

    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/SearchResults']")
    public WebElement products;

    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/HeaderSearch']")
    public WebElement searchLine;

    @Step("Нажата кнопка для перехода - {0}")//Все фильтры
    public AdvancedFilterPage clickAllFiltersButton(String itemName) {
        filterItem.findElement(By.xpath("//div[@data-zone-name='all-filters-button']//span[text()='"+itemName+"']")).click();
        return new AdvancedFilterPage();
    }

    String firstProductName;

    @Step("Подсчет кол-во отображаемых на странице товаров")
    public AllFiltersPage countNumberOfProducts(String itemName) {
        boolean counter;
        List<WebElement> list = products.findElements(By.xpath("//span[@data-tid='ce80a508'][contains(text(),'"+itemName+"')]"));
        if (list.size() >= 12) {
            counter = true;
            firstProductName = list.get(0).getText();
        } else counter = false;
        System.out.println(firstProductName);
        Assert.assertTrue(counter);
        return this;
    }

    @Step("В поисковую строку вставлено значение первого элемента")
    public AllFiltersPage putInSearchLine() {
        fillField(searchLine.findElement(By.xpath("//INPUT[@id='header-search']")), firstProductName);
        return this;
    }

    @Step("Нажата кнопка поиска записанного товара")
    public AllFiltersPage clickSearchButton() {
        searchLine.findElement(By.xpath("//button[@role='button']/span[text()='Найти']")).click();
        return this;
    }

    //строку разбить на массив стрингов, вытащить последний элемент
    //перебором проверять каждый элемент на соответствие последнему в строке оригинала
    //как только встречается последний элемент - склеить его и выйти из цикла
    @Step("Проверить, что наименование товара соответствует запросу")
    public AllFiltersPage checkEqualFirstProductName() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
        String itemTextAttribute;
        String itemText;
        boolean flagFinder = false;
        List<WebElement> listOfWeb = products.findElements(By.xpath("//h3/a[@title]"));
        for (WebElement item : listOfWeb) {
            itemTextAttribute = item.getAttribute("title").replaceAll("\\s+", "");
            firstProductName = firstProductName.replaceAll("\\s+", "");
            itemText = item.getText().replaceAll("\\s+", "");
            if (itemTextAttribute.equals(firstProductName) || itemText.equals(firstProductName)){
                System.out.println(itemText);
                System.out.println(firstProductName);
                flagFinder = true;
                break;
            }
        }
        Assert.assertTrue("Продукт с именем"+firstProductName+"не найден",flagFinder);
//        String strOfWebElem = "";
//        String[] arrStrings = firstProductName.split(" ");
//        String lastElemOfArray = arrStrings[arrStrings.length - 1];
//        System.out.println(lastElemOfArray);
//        List<WebElement> list = products.findElements(By.xpath("//h3[@class='_3dCGE8Y9v3 cLo1fZHm2y']//span[@data-tid='ce80a508']"));
//        for (int i = 0; i < list.size(); i++) {
//            strOfWebElem += list.get(i).getText();
//            if (list.get(i).getText().equals(lastElemOfArray)) {
//                System.out.println(strOfWebElem);
//                break;
//            }
//        }
//        System.out.println(strOfWebElem);
//        System.out.println(firstProductName);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException ignore) {
//        }
//        firstProductName = firstProductName.replaceAll("\\s+", "");
//        strOfWebElem = strOfWebElem.replaceAll("\\s+", "");
//        products.findElement(By.xpath("//a[@class='_27nuSZ19h7 wwZc93J2Ao cia-cs'][@title='"+firstProductName+"']"));
//        Assert.assertEquals(products.findElement(By.xpath("//a[@class='_27nuSZ19h7 wwZc93J2Ao cia-cs'][@title='" + firstProductName + "']")), firstProductName);
//        Assert.assertEquals(strOfWebElem, firstProductName);
        return this;
    }

}

