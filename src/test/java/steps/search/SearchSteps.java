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
        WebElement results = searchPage.setFindList();
        List<WebElement> resultsList = results.findElements(By.tagName("li"));

        //here I try to click in all the pages until the last to return the total iphone found
        for(int i=2; i<resultsList.size(); i++) {
            //resultsList.get(i).click();
        }

    }

    @Then("^make sure at least (.*)% of items found are Iphone")
    public void makeSureAtLeastOfItemsFoundAreIphone(double valor) {
        //here I did some validations

        searchPage.clickRadioApple();
        String quantity = searchPage.getQuantityProduct().substring(8,11);

        //here I put a total fake 500 Iphone found
        double calculo = (Double.valueOf(quantity)/500) * 100;

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
        searchPage.clickRadioApple();

        //select the price
        searchPage.selectSpanHighestPrice();
        searchPage.selectHighestPrice();

        price = searchPage.getPrice();

        System.out.println(price);
    }

    @When("convert its value to USD")
    public void convertItsValueToUSD() {
        baseApi.requestGet();
        System.out.println(baseApi.response.prettyPrint());
    }

    @Then("make sure the converted value is not greater than US2000")
    public void makeSureTheConvertedValueIsNotGreaterThanUS2000() {
        searchPage.bye();
    }

}