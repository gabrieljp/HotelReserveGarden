
import java.util.ArrayList;
import java.util.Scanner;


public class Gerenciamentodecadastro {

    public static void main(String[] args) {
        
        ArrayList <Cliente> arrayCliente= new ArrayList<>();
        //Funcionario objFuncionario = new Funcionario("Ana",23,"000.000.000-00","gerente",1000);
        //System.out.println(objFuncionario);
        
       // Cliente objCliente = new Cliente("Alisson",20,"111.1111.111-11","88888888","Rua: Da Paz, 101");
       // System.out.println(objCliente);
        
        Scanner teclado=new Scanner (System.in);
        
        boolean opcaoCond=true;
        int opcao;
        
        String nomeCliente;
        int idadeCliente;
        String cpfCliente;
        String telefoneCliente;
        String enderecoCliente;
        
        
        
        
        do{
            System.out.println("SISTEMA DE CADASTRO DE CLIENTES");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Corrigir");
            System.out.println("4 - Mostrar Lista de Clientes");
            System.out.println("5 - Sair");
            System.out.println("Qual a opcao?");
            opcao=teclado.nextInt();
            
            teclado.nextLine();// Consumir a quebra de linha
            
            switch(opcao){
                case 1:
                    System.out.print("Nome: ");
                    nomeCliente = teclado.nextLine();
                    System.out.print("Idade: ");
                    idadeCliente = teclado.nextInt();
                    teclado.nextLine(); // Consumir a quebra de linha
                    System.out.print("CPF: ");
                    cpfCliente = teclado.nextLine();
                    System.out.print("Telefone: ");
                    telefoneCliente = teclado.nextLine();
                    System.out.print("Endereco: ");
                    enderecoCliente = teclado.nextLine();
                    
                    Cliente novoCliente = new Cliente(nomeCliente,idadeCliente,cpfCliente,telefoneCliente,enderecoCliente);
                    arrayCliente.add(novoCliente);
                    break;
                case 4:
                    for(Cliente cliente : arrayCliente){
                        System.out.println(cliente);
                    }
                    break;
                case 5:
                    opcaoCond=false;
                    break;
                default :
                    System.out.println("Opcao invalida!");
                    
                    
            }
            
            
            
        }while(opcaoCond==true);
        
        
    }
}
