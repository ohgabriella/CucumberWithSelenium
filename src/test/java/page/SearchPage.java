package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    WebDriver driver;

    By inputSite = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
    By amazonSite = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a");
    By product = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    By clickProduct = By.xpath("//*[@id=\"nav-search-submit-button\"]");
    By findList = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[61]/span/div/div");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void navigateToSite(String site) {
        driver.navigate().to(site);
    }

    public void setInputSite(String input) {
        driver.findElement(inputSite).sendKeys(input);
    }

    public void enterAmazonSite(){
        driver.findElement(inputSite).sendKeys(Keys.ENTER);
    }

    public void clickAmazonSite() {
        driver.findElement(amazonSite).click();
    }

    public void searchProduct(String products) {
        driver.findElement(product).sendKeys(products);
    }

    public void setClickProduct() {
        driver.findElement(clickProduct).click();
    }

    public WebElement setFindList() {
        return driver.findElement(findList);
    }

    public WebDriverWait waitPageLoad() {
       return new WebDriverWait(driver, 1000);
    }

    public void bye() {
        driver.close();
    }
}
