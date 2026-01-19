package automacao.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**Page factory - Mapeando elementos**/
public class LoginPO extends BasePO {

    /**buscar determinado elemento**/
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha; 

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar; 

    
    @FindBy(id = "mensagem")
    public WebElement spanMensagem; 



    /**construtor padrão para criação de instancia da página de login**/
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public void escrever (WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);

    }

    public String obterMensagem(){
        return spanMensagem.getText();
    }



    /**
     * Método tenta executar Login
     * @param email Email para tentativa de Login
     * @param senha Senha para tentativa de Login
     */
        public void executarAcaoLogar(String email, String senha){
        escrever(inputEmail, " ");
        escrever(inputSenha, " ");
        buttonEntrar.click();
    }


        public String obterTituloPagina(){
         return driver.getTitle();
    }
}
