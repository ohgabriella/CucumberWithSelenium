package base;

import org.junit.AfterClass;
import org.junit.BeforeClass;


public class BaseTest {

    protected String price;
    protected String real;
    protected String dolar;
    protected String totalQuantity;
    protected String quantity;
    protected double convertRealEuro;
    protected double convertEuroDolar;

    @BeforeClass
    public static void init() {
        System.out.println("Início dos testes");
    }

    @AfterClass
    public static void quit() {
        System.out.println("Fim  dos testes");
    }


}
