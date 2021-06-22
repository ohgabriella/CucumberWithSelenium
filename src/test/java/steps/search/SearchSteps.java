package steps.search;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.SearchPage;
import java.util.ArrayList;
import java.util.List;

public class SearchSteps extends BaseTest{
    WebDriver driver;
    SearchPage searchPage = new SearchPage(driver);

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
        searchPage.searchProduct(product);
        searchPage.setClickProduct();
    }

    @And("count the total list of found products")
    public void countTheTotalListOfFoundProducts() {
        WebElement results = searchPage.setFindList();
        List<WebElement> resultsList = results.findElements(By.tagName("li"));

        List<String> lista = new ArrayList<>();
        for (WebElement li : resultsList) {
                lista.add(li.getText());
        }
        System.out.println("List of found products " + lista.get(lista.size()-2));
    }

    @And("count the total of Iphone items found")
    public void countTheTotalOfIphoneItemsFound(){
        WebElement results = searchPage.setFindList();
        List<WebElement> resultsList = results.findElements(By.tagName("li"));

        for(int i=1; i<resultsList.size(); i++) {

//                    resultsList.get(i).click();

        }


    }

    @Then("^make sure at least (.*)% of items found are Iphone")
    public void makeSureAtLeastOfItemsFoundAreIphone(int valor) throws InterruptedException {

        Thread.sleep(2000);
        searchPage.bye();
    }


}