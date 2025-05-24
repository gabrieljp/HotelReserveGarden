/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservegarden;

import java.util.Scanner;

public class CadastroDeLogin {
    private String nomeUsuario;
    private String telUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    
    
    
    Scanner teclado = new Scanner(System.in);
    
    void cadastrar(String nome, String telefone, String login, String senha){
        System.out.println("Qual o seu nome?");
        nomeUsuario = teclado.nextLine();
        
        System.out.println("Qual o seu telefone?");
        telUsuario = teclado.nextLine();
        
        System.out.println("Digite um login.");
        loginUsuario = teclado.nextLine();
        
        System.out.println("Digite uma senha.");
        senhaUsuario = teclado.nextLine();
        
        System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");
    }
}
