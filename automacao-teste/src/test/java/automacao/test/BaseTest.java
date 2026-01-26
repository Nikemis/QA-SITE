package automacao.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**Ambiente onde a lógica está**/
public abstract class BaseTest {
    
    protected static WebDriver driver;
    private static final String URL_BASE = "C:/Users/osafu.CYBERPUNK/Desktop/TesteSiteQA/controle-de-produtos/sistema/login.html";

    /**Chama antes de qualquer teste**/
    
    @BeforeAll
    public static void iniciar(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**Chama depois de qualquer teste -- Finaliza o navegador**/

    @AfterAll
    public static void finalizar(){
        driver.quit();
    }
}
