
package hotelreservegarden;


import java.util.Scanner;

public class AuthenticacaoLoginFuncionario {
    
    private String loginFunc;
    private String senhaFunc;   
    
    
    
    Scanner teclado = new Scanner(System.in);
    
    CadastroDeFuncionario CadFuncionario = new CadastroDeFuncionario();
    
    
    
    
    void loginFuncionario(String login,String senha){
          
        System.out.println("DIGITE SEU LOGIN");
        loginFunc = teclado.nextLine();
            
        System.out.println("DIGITE SUA SENHA");
        senhaFunc = teclado.nextLine();
            
            
        teclado.nextLine(); // Consome a linha restante (incluindo o Enter)
        
        
        
        
        
            
    }
    
}
