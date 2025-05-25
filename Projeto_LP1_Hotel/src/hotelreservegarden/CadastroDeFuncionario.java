
package hotelreservegarden;

import java.util.Scanner;

public class CadastroDeFuncionario {
    private String nomeFunc;
    private String telFunc;
    private String loginFunc;
    private String senhaFunc;
    private boolean cond=false;
    private int opcao;
    
    
    
    
    Scanner teclado = new Scanner(System.in);
   
    
    
    
    
    void cadastrarFuncionario(String nome, String telefone, String login, String senha){
        do{  
            System.out.println("1 - JA POSSUO CADASTRO");
            System.out.println("2 - QUERO ME CADASTRAR");
            System.out.println("3 - QUERO CORRIGIR MEU CADASTRO");
            System.out.println("0 - SAIR");
            opcao = teclado.nextInt();
            teclado.nextLine(); // Consome a linha restante (incluindo o Enter), sem isso ja ia direto pra o telefone.
            
            switch(opcao){
                case 1:
                    System.out.println(" AUTHENTICAR LOGIN DO FUNCIONARIO");
                    System.out.println(" FALTA IMPLEMENTAR\n");
                    
                    
                    break;
                case 2:
                    System.out.println("Qual o seu nome?");
                    nomeFunc = teclado.nextLine();

                    System.out.println("Qual o seu telefone?");
                    telFunc = teclado.nextLine();

                    System.out.println("Digite um login.");
                    loginFunc = teclado.nextLine();

                    System.out.println("Digite uma senha.");
                    senhaFunc = teclado.nextLine();

                    System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");                    
                    break;
                case 3:
                    System.out.println(" CORRIJA SEU CADASTRO");
                    break;
                case 0:
                    System.out.println("\nVOLTANDO AO MENU PRINCIPAL \n");
                    cond=true;
                    break;
                default:
                    System.out.println("\nOPCAO INVALIDA! \n");                    
                    
            }             
        
        }while(cond!=true);
        
    }
    
}
