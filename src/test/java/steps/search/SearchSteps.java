package steps.search;

import base.BaseApi;
import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import page.SearchPage;
import java.util.ArrayList;
import java.util.List;

public class SearchSteps extends BaseTest{
    WebDriver driver;
    SearchPage searchPage = new SearchPage(driver);
    BaseApi baseApi = new BaseApi();

    static final String SITE = "https://www.google.com/";

    @Given("the user open the Amazon Brasil site")
    public void theUserOpenTheAmazonBrasilSite() {
        //configuration
        searchPage.setChromeDriver();
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
        System.out.println("List of found products " + lista.get(lista.size()-2));
    }

    @And("count the total of Iphone items found")
    public void countTheTotalOfIphoneItemsFound() throws InterruptedException {
        //search the product
       searchPage.clickRadioApple();
       totalQuantity = searchPage.getQuantityProduct().substring(8,11);

    }

    @Then("^make sure at least (.*)% of items found are Iphone")
    public void makeSureAtLeastOfItemsFoundAreIphone(double valor) {
        //here I did some validations

        searchPage.getSmartphone();
        quantity = searchPage.getQuantityProduct().substring(8,11);
        System.out.println(quantity);

        //here I put a total Iphone found
        double calculo = (Double.valueOf(quantity)/Integer.parseInt(totalQuantity)) * 100;

        if(calculo >= valor) {
            Assert.assertTrue("The total Iphone items found is bigger than 80%", calculo>=valor);
            System.out.println("The total Iphone items found is about " + calculo + "%");
        }

        searchPage.bye();
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
        baseApi.requestGet();

        real = baseApi.response.path("rates.BRL").toString();
        dolar = baseApi.response.path("rates.USD").toString();

        convertRealEuro = Double.parseDouble(price) / Double.parseDouble(real);
        convertEuroDolar = convertRealEuro * Double.parseDouble(dolar);

        System.out.println(convertEuroDolar);
    }

    @Then("^make sure the converted value is not greater than US (.*)")
    public void makeSureTheConvertedValueIsNotGreaterThanUS2000(double valor) {
        if(convertEuroDolar <= valor) {
            Assert.assertTrue("The converted value is not greater than US", convertEuroDolar <= valor);
            System.out.println("The converted value is not greater than US" + convertEuroDolar);
        }
        searchPage.bye();
    }

}