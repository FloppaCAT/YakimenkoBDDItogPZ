package Steps;

import Pages.*;
import Util.DriverManager;
import Util.TestPropertiesManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ScenarioSteps {

    private static TestPropertiesManager propManager = TestPropertiesManager.getInstance();
    public static WebDriver driver = DriverManager.getDriverManager().getDriver();
    public static String baseUrl;
    public static Properties properties = propManager.getProperties();

    MainYandexPage mainYandexPage = new MainYandexPage();

    AllCategoryPage allCategoryPage = new AllCategoryPage();

    SelectedCategoryPage selectedCategoryPage = new SelectedCategoryPage();

    AdvancedFilterPage advancedFilterPage = new AdvancedFilterPage();

    AllFiltersPage allFiltersPage = new AllFiltersPage();


    @Before
    public void BeforeTest(){
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.get(baseUrl);
    }

    @When("^Выбран пункт меню \"(.+)\"$")//Маркет
    public void stepSelectMenuItem(String itemName){
        mainYandexPage.selectMenuBarItem(itemName);
    }

    @When("Выбрана категория \"(.+)\"$")//Электроника
    public void stepSelectCategoryItem(String itemName){
        allCategoryPage.selectCategoryItem(itemName);
    }

    @When("Выбран тип текущей категории - \"(.+)\"$")//Телевизоры
    public void stepSelectItemOfCurrentCategory(String itemName){
        selectedCategoryPage.selectItemOfCurrentCategory(itemName);
    }

    @When("Нажата кнопка для перехода - \"(.+)\"$")//Все фильтры
    public void stepClickAllFiltersButton(String itemName){
        allFiltersPage.clickAllFiltersButton(itemName);
    }

    @When("^Введен параметр суммы:(\\d+) рублей$")//20000
    public void stepFillField(String cost){
       advancedFilterPage.fillField(cost);
    }

    @When("^Выбран первый производитель - \"(.+)\"$")//LG
    public void stepClickFirstManufacturer(String itemName){
        advancedFilterPage.clickFirstManufacturer(itemName);
    }

    @When("^Выбран второй производитель - \"(.+)\"$")//Samsung
    public void stepClickSecondManufacturer(String itemName){
        advancedFilterPage.clickSecondManufacterer(itemName);
    }

    @When("^Введено значение для поиска по фильтрам - \"(.+)\"$")//Beats
    public void stepFillSearchFilterField(String itemName){
        advancedFilterPage.fillSearchFilterField(itemName);
    }

    @When("^Выбран производитель - \"(.+)\"$")//Beats
    public void stepClickCustomManufaсterer(String ItemName){
        advancedFilterPage.clickCustomManufacterer(ItemName);
    }

    @When("Нажата кнопка подтверждения - \"(.+)\"$")//Показать
    public void stepSlickAcceptButton(String itemName){
        advancedFilterPage.clickAcceptButton(itemName);
    }

    @When("^Подсчет кол-ва отображаемых на странице товаров в категории - \"(.+)\"$")
    public void stepCountNumberOfProducts(String itemName){
        allFiltersPage.countNumberOfProducts(itemName);
    }

    @When("^В поисковую строку вставлено значение первого элемента$")
    public void stepPutInSearchLine(){
        allFiltersPage.putInSearchLine();
    }

    @When("^Нажата кнопка поиска записанного товара$")
    public void stepClickSearchButton(){
        allFiltersPage.clickSearchButton();
    }

    @When("^Проверить, что наименование товара соответствует запросу$")
    public void stepCheckEqualFirstProductName(){
        allFiltersPage.checkEqualFirstProductName();
    }
}
