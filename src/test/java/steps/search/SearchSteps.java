package steps.search;

import base.BaseApi;
import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.SearchPage;

import java.util.ArrayList;
import java.util.List;

public class SearchSteps extends BaseTest {

    WebDriver driver;
    SearchPage searchPage = new SearchPage(driver);
    BaseApi baseApi = new BaseApi();

    static final String SITE = "https://www.google.com/";

    @Before
    public void init() {
        searchPage.setChromeDriver();
    }

    @Given("the user open the Amazon Brasil site")
    public void theUserOpenTheAmazonBrasilSite() {
        //configuration
        searchPage.navigateToSite(SITE);

        //search site
        searchPage.setInputSite("Amazon Brasil");
        searchPage.enterAmazonSite();
        searchPage.clickAmazonSite();
    }

    @When("^search for (.*) using the search bar")
    public void searchForIphoneUsingTheSearchBar(String product) {
        //search the product
        searchPage.searchProduct(product);
        searchPage.setClickProduct();
    }

    @And("count the total list of found products")
    public void countTheTotalListOfFoundProducts() {
        WebElement results = searchPage.setFindList();
        List<WebElement> resultsList = results.findElements(By.tagName("li"));

        //list the product and put in a List
        List<String> lista = new ArrayList<>();
        for (WebElement li : resultsList) {
            lista.add(li.getText());
        }
        System.out.println("List of found products " + lista.get(lista.size() - 2));
    }

    @And("count the total of Iphone items found")
    public void countTheTotalOfIphoneItemsFound() throws InterruptedException {
        //search the product
        searchPage.clickRadioApple();
        totalQuantity = searchPage.getQuantityProduct().substring(8, 11);

    }

    @Then("^make sure at least (.*)% of items found are Iphone")
    public void makeSureAtLeastOfItemsFoundAreIphone(double valor) {
        //here I did some validations
        searchPage.getSmartphone();
        quantity = searchPage.getQuantityProduct().substring(8, 11);
        System.out.println(quantity);

        //here I put a total Iphone found
        double calculo = (Double.valueOf(quantity) / Integer.parseInt(totalQuantity)) * 100;

        Assert.assertTrue("The total Iphone items found is bigger than 80%", calculo >= valor);
        System.out.println("The total Iphone items found is about " + calculo + "%");
    }

    //---------------------- Second Scenario

    @When("^find the more expensive (.*) in page")
    public void findTheMoreExpensiveIphoneInPage(String product) {
        //search the product
        searchPage.searchProduct(product);
        searchPage.setClickProduct();
        searchPage.getSmartphone();
        searchPage.clickRadioApple();

        //select the price
        searchPage.selectSpanHighestPrice();
        searchPage.selectHighestPrice();

        price = searchPage.getPrice().replace(".", "");

        System.out.println(price);
    }

    @When("convert its value to USD")
    public void convertItsValueToUSD() {
        //here I call the api methods
        baseApi.requestGet();

        real = baseApi.response.path("rates.BRL").toString();
        dolar = baseApi.response.path("rates.USD").toString();

        convertRealEuro = Double.parseDouble(price) / Double.parseDouble(real);
        convertEuroDolar = convertRealEuro * Double.parseDouble(dolar);

        System.out.println(convertEuroDolar);
    }

    @Then("^make sure the converted value is not greater than US (.*)")
    public void makeSureTheConvertedValueIsNotGreaterThanUS2000(double valor) {
        //did some validations
        Assert.assertTrue("The converted value is not greater than US", convertEuroDolar <= valor);
        System.out.println("The converted value is not greater than US" + convertEuroDolar);
    }

    //---------------------- Third Scenario

    @When("find products which are not Iphone")
    public void findProductsWhichAreNotIphone() throws InterruptedException {
        //search the product
        searchPage.getSmartphone();
        searchPage.clickRadioApple();

        //select the price
        searchPage.selectSpanHighestPrice();
        searchPage.selectSpanLowestPrice();
        searchPage.inputSpecification();
        price = searchPage.getPrice().replace(".", "");

        Thread.sleep(2000);
        searchPage.clickRadioApple();
        searchPage.clickRadioXiaomi();
        priceXiaomi = searchPage.getPrice().replace(".", "");
    }

    @Then("make sure all found products are cheaper than the cheapest Iphone")
    public void makeSureAllFoundProductsAreCheaperThanTheCheapestIphone() {
        //some validations
        Assert.assertTrue("Xiaomi is cheaper than cheapest Iphone", Integer.parseInt(price) > Integer.parseInt(priceXiaomi));
    }

    @After
    public void end() {
        searchPage.bye();
    }
}