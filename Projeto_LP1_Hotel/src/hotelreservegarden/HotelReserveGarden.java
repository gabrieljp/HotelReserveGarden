
package hotelreservegarden;

import java.util.Scanner;

public class HotelReserveGarden {

  
    public static void main(String[] args) {
        int opcao;
        boolean condicao=false;
        String nome = null;
        String telefone = null;
        String login = null;
        String senha = null;
        
        String nomeFunc = null;
        String telFunc = null;
        String loginFunc = null;
        String senhaFunc = null;

        Scanner teclado = new Scanner(System.in);
        
        CadastroDeLogin cadUsuario = new CadastroDeLogin();
        CadastroDeFuncionario cadFuncionario = new CadastroDeFuncionario();
    
        do{
            
            System.out.println("HOTEL RESERVE GARDEN");
            System.out.println("1 - JA TENHO UMA RESERVA");
            System.out.println("2 - QUERO FAZER UMA RESERVA");
            System.out.println("3 - OLHAR QUARTOS DISPONIVEIS");
            System.out.println("4 - SOU FUNCIONARIO");
            System.out.println("0 - SAIR");
            
            opcao=teclado.nextInt();
            
            switch(opcao){

                case 1:
                    System.out.println("\nFACA SEU LOGIN \n");
                    break;
                case 2:
                    System.out.println("\nVAMOS FAZER UM BREVE CADASTRO \n");
                    cadUsuario.cadastrar(nome, telefone, login, senha);
                    break;
                case 3: 
                    System.out.println("\nVEJA OS QUARTOS DISPONIVEIS \n");
                    break;
                case 4: 
                    System.out.println("\nAREA DO FUNCIONAIO \n");
                    cadFuncionario.cadastrarFuncionario(nomeFunc,telFunc,loginFunc,senhaFunc);
                    break;
                case 0:
                    condicao=true;
                    break;
                default:
                    System.out.println("\nOPCAO INVALIDA! \n");


            }            
            
            
            
        }while(condicao != true);
        teclado.close();
    
        
    }
    
}
