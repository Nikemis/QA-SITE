package automacao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import automacao.page.LoginPO;



public class LoginTest extends BaseTest {


    private static LoginPO loginPage;
    
 @BeforeAll
  
    /**Metodo inicial que isntancia PO login**/
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void CT001_nao_deve_logar_retorna_mensagem_camposVazio_usuarioVazio_senhaVazia(){
        loginPage.executarAcaoLogar("", "");
        String mensagem= loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void CT002_nao_deve_logar_retorna_mensagem_campoSenhaVazio_EmailPreenchido_senhaVazia(){
        loginPage.executarAcaoLogar("admin@admin.com", "");
        String mensagem= loginPage.obterMensagem();
        assertEquals("Senha Obrigatório", mensagem);
    }

    @Test
    public void CT003_nao_deve_logar_retorna_mensagem_campoEmailVazio_EmailVazio_senhaPreenchida(){
        loginPage.executarAcaoLogar("", "admin@123");
        String mensagem= loginPage.obterMensagem();
        assertEquals("Email Obrigatório", mensagem);
    }
    
    @Test
    public void CT004_nao_deve_logar_retorna_mensagem_camposInvalidos_usuarioPreenchido_senhaPreenchida(){
        loginPage.executarAcaoLogar("teste@gmail.com", "Senh@");
        String mensagem= loginPage.obterMensagem();
        assertEquals("E-mail ou senha inválidos", mensagem);
    }
    
    @Test
    public void CT005_deve_logar_retorna_telaCadastroUsuario_camposValidos_usuarioPreenchido_senhaPreenchida(){
        loginPage.executarAcaoLogar("admin@admin.com", "admin@123");
       
        //assertEquals( loginPage.obterTituloPagina(), "Controles de Produtos");
    }
}
