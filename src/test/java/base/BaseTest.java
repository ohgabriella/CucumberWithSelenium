package base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public static void init() {
        System.out.println("Início dos testes");
    }

    @AfterClass
    public static void quit() {
        System.out.println("Fim  dos testes");
    }

    public void BaseTest() {

    }

    @Before
    public void hi() {
        //driver.get();
    }

    @After
    public void bye() {
        driver.close();
    }

}
