package hotelreservegarden;

import java.util.Scanner;

public class AuthenticacaoLoginFuncionario {

    private CadastroDeFuncionario cadastroDeFuncionario;
    private Scanner teclado = new Scanner(System.in);
    private GestaoQuartos gestaoQuartos; // Adicionando uma instância de GestaoQuartos
    
    

    public AuthenticacaoLoginFuncionario(CadastroDeFuncionario cadastro, GestaoQuartos gestaoQuartos) {
        this.cadastroDeFuncionario = cadastro;
        this.gestaoQuartos = gestaoQuartos; // Recebendo a instância de GestaoQuartos
    }

    public boolean realizarLogin() {
        System.out.println("DIGITE SEU LOGIN:");
        String loginFunc = teclado.nextLine();

        System.out.println("DIGITE SUA SENHA:");
        String senhaFunc = teclado.nextLine();

        Funcionario funcionario = cadastroDeFuncionario.buscarFuncionarioPorLogin(loginFunc);

        if (funcionario != null && funcionario.getSenha().equals(senhaFunc)) {
            System.out.println("\nLOGIN REALIZADO COM SUCESSO, " + funcionario.getNome() + "!\n");
            exibirMenuFuncionario(funcionario); // Chama o menu de funcionalidades do funcionário
            return true;
        } else {
            System.out.println("\nLOGIN OU SENHA INCORRETO!\n");
            return false;
        }
    }

    private void exibirMenuFuncionario(Funcionario funcionarioLogado) {
        boolean sair = false;
        do {
            System.out.println("\nMENU DE FUNCIONARIO");
            System.out.println("1 - GERENCIAR QUARTOS");
            System.out.println("2 - VISUALIZAR RESERVAS");
            System.out.println("3 - SAIR");
            System.out.print("ESCOLHA A OPCAO: ");
            int opcao = teclado.nextInt();
            teclado.nextLine(); // Consome a linha restante

            switch (opcao) {
                case 1:
                    gestaoQuartos.menuFuncionario(teclado);
                    break;
                case 2:                 
                    HotelReserveGarden.gerenciadorDeReservas.listarReservas(); //metodo que lista as reservas que pertence a classe gerenciadorDeReservas e esta instanciada no main
                    break;
                case 3:
                    System.out.println("LOGOUT REALIZADO.");
                    sair = true;
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
        } while (!sair);
    }
}