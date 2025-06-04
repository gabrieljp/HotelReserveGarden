package hotelreservegarden;

import java.util.Scanner;

public class HotelReserveGarden {

    public static GestaoQuartos gestaoQuartos = new GestaoQuartos();
    private static Scanner teclado = new Scanner(System.in);
    private static CadastroDeLogin cadastroDeLogin = new CadastroDeLogin(teclado, null);
    public static GerenciadorDeReservas gerenciadorDeReservas = new GerenciadorDeReservas(gestaoQuartos, cadastroDeLogin, teclado);
    private static CadastroDeFuncionario cadFuncionario = new CadastroDeFuncionario();
    private static AuthenticacaoLoginFuncionario autenticacaoFuncionario = new AuthenticacaoLoginFuncionario(cadFuncionario, gestaoQuartos);

    static {
        cadastroDeLogin.setGerenciadorDeReservas(gerenciadorDeReservas);
    }

    public static void main(String[] args) {
        int opcao;
        boolean condicao = false;

        do {
            System.out.println("\n--- HOTEL RESERVE GARDEN ---");
            System.out.println("1 - JA TENHO UMA RESERVA");
            System.out.println("2 - QUERO FAZER UMA RESERVA");
            System.out.println("3 - OLHAR QUARTOS DISPONIVEIS");
            System.out.println("4 - SOU FUNCIONARIO");
            System.out.println("5 - AREA DO USUARIO");
            //System.out.println("6 - LISTAR RESERVAS (ADMIN)"); // Adicionado para teste
            System.out.println("0 - SAIR");
            System.out.print("ESCOLHA UMA OPCAO: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // Consome a linha restante

            switch (opcao) {
                case 1:
                    cadastroDeLogin.menuUsuario(); // Leva ao menu do usuário para verificar reserva
                    break;
                case 2:
                    cadastroDeLogin.menuUsuario();
                    break;
                case 3:
                    System.out.println("\n--- QUARTOS DISPONIVEIS ---");
                    gestaoQuartos.mostrarQuartosDisponiveis();
                    break;
                case 4:
                    System.out.println("\n--- AREA DO FUNCIONARIO ---");
                    cadFuncionario.exibirMenuCadastro(autenticacaoFuncionario);
                    break;
                case 5:
                    System.out.println("\n--- AREA DO USUARIO ---");
                    cadastroDeLogin.menuUsuario();
                    break;
                
                case 0:
                    System.out.println("SAINDO DO SISTEMA.");
                    condicao = true;
                    break;
                default:
                    System.out.println("OPCAO INVALIDA!");
            }
        } while (!condicao);
        teclado.close();
    }
}