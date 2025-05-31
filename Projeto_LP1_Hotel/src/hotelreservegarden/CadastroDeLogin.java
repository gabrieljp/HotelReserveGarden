
package hotelreservegarden;

import java.util.Scanner;

public class CadastroDeLogin {
    private String nomeUsuario;
    private String telUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    
    
    
    Scanner teclado = new Scanner(System.in);
    
    
    
    
    void cadastrar(String nome, String telefone, String login, String senha){
        System.out.println("QUAL O SEU NOME?");
        nomeUsuario = teclado.nextLine();
        
        System.out.println("QUAL O SEU TELEFONE?");
        telUsuario = teclado.nextLine();
        
        System.out.println("DIGITE SEU LOGIN");
        loginUsuario = teclado.nextLine();
        
        System.out.println("DIGITE SUA SENHA");
        senhaUsuario = teclado.nextLine();
        
        System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");
        
    }
    
}
