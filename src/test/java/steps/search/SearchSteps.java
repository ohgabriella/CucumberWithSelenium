package steps.search;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchSteps extends BaseTest {

    static final String SITE = "https://www.google.com/";

    @Given("The User Open the Amazon Brasil Site")
    public void theUserOpenTheAmazonBrasilSite() {
        //configuration
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //search site
        driver.navigate().to(SITE);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Amazon Brasil");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a")).click();
    }

    @When("Search For Iphone Using The Search Bar")
    public void searchForIphoneUsingTheSearchBar() {
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Iphone");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
    }

    @And("Count The Total List Of Found Products")
    public void countTheTotalListOfFoundProducts() {

    }

    @And("Count The Total Of Iphone Items Found")
    public void countTheTotalOfIphoneItemsFound() {

    }

    @Then("Make Sure At Least {int}% Of Items Found are Iphone")
    public void makeSureAtLeastOfItemsFoundAreIphone(Integer int1) throws InterruptedException {

        Thread.sleep(2000);

        bye();
    }


}