package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchPage {

    WebDriver driver;

    By inputSite = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
    By amazonSite = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a");
    By product = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    By clickProduct = By.xpath("//*[@id=\"nav-search-submit-button\"]");
    By findList = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[61]/span/div/div");
    By clickApple = By.xpath("//*[@id=\"p_89/Apple\"]/span/a/span");
    By quantityProduct = By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]");
    By dropdownOrder = By.xpath("//*[@id=\"a-autoid-0\"]/span");
    By selectPrice = By.id("a-autoid-0-announce");
    By price = By.xpath("//*[@id=\"a-popover-2\"]/div/div/ul/li[3]");
    By higuestPrice = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[4]/div/a/span/span[2]/span[2]");
    By getSmartphone = By.xpath("//*[@id=\"n/16243890011\"]/span");

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

    public void enterAmazonSite() {
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

    public void clickRadioApple() {
        driver.findElement(clickApple).click();
    }

    public String getQuantityProduct() {
        return driver.findElement(quantityProduct).getText();
    }

    public void getSmartphone() {
       driver.findElement(getSmartphone).click();
    }

    public void selectDropDown(String value) {
        Select dropdown = new Select(driver.findElement(dropdownOrder));
        dropdown.selectByVisibleText(value);
    }

    public void selectSpanHighestPrice() {
        driver.findElement(selectPrice).click();
    }

    public String getPrice() {
        return driver.findElement(higuestPrice).getText();
    }

    public void selectHighestPrice() {
        driver.findElement(price).click();

    }

    public WebDriverWait waitPageLoad() {
        return new WebDriverWait(driver, 1000);
    }

    public void bye() {
        driver.close();
    }
}
