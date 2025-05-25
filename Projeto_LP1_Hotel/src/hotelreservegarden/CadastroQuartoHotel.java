
package hotelreservegarden;

import java.util.Scanner;

public class CadastroQuartoHotel {
    
    private int numQuarto;
    private String nomeQuarto;
    private double valorQuarto;
    private String tipoQuarto;
    private boolean livre;
    
    
    Scanner teclado=new Scanner (System.in);
    
    public void CadastroQuarto(int numQuarto, String nomeQuarto, double valorQuarto, String tipoQuarto){
        System.out.println("Qual o numero do quarto");
        numQuarto = teclado.nextInt();
        
        System.out.println("Qual o nome do quarto?");
        nomeQuarto = teclado.nextLine();
        
        System.out.println("Digite o preco.");
        valorQuarto = teclado.nextDouble();
        
        System.out.println("Digite uma senha.");
        tipoQuarto = teclado.nextLine();
        
        livre=false;
        
        System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");
        
    }
    
    
    
}
