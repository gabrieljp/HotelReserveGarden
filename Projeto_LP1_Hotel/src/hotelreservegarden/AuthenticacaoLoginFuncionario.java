package hotelreservegarden;

import java.util.Scanner;

public class AuthenticacaoLoginFuncionario {

    private CadastroDeFuncionario cadastroDeFuncionario;
    private Scanner teclado = new Scanner(System.in);

    public AuthenticacaoLoginFuncionario(CadastroDeFuncionario cadastro) {
        this.cadastroDeFuncionario = cadastro;
    }

    public boolean realizarLogin() {
        System.out.println("DIGITE SEU LOGIN:");
        String loginFunc = teclado.nextLine();

        System.out.println("DIGITE SUA SENHA:");
        String senhaFunc = teclado.nextLine();

        Funcionario funcionario = cadastroDeFuncionario.buscarFuncionarioPorLogin(loginFunc);

        if (funcionario != null && funcionario.getSenha().equals(senhaFunc)) {
            System.out.println("\nLOGIN REALIZADO COM SUCESSO!\n");
            System.out.println("\nFALTA IMPLEMENTAR O QUE O FUNCIONARIO PODE OU NAO FAZER\n");
            
            return true;
        } else {
            System.out.println("\nLOGIN OU SENHA INCORRETO!\n");
            return false;
        }
    }
}