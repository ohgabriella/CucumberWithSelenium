package base;

import org.junit.AfterClass;
import org.junit.BeforeClass;


public class BaseTest {

    @BeforeClass
    public static void init() {
        System.out.println("Início dos testes");
    }

    @AfterClass
    public static void quit() {
        System.out.println("Fim  dos testes");
    }


}
