package hotelreservegarden;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDeFuncionario {
    private ArrayList<Funcionario> funcionarios;
    private Scanner teclado = new Scanner(System.in);

    public CadastroDeFuncionario() {
        this.funcionarios = new ArrayList<>();
        // Adicionando alguns funcionários iniciais para teste
        adicionarFuncionario(new Funcionario("Administrador", "123456789", "admin", "admin123"));
        adicionarFuncionario(new Funcionario("Gerente", "987654321", "gabriel", "123"));
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public Funcionario buscarFuncionarioPorLogin(String login) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getLogin().equals(login)) {
                return funcionario;
            }
        }
        return null;
    }

    public void exibirMenuCadastro(AuthenticacaoLoginFuncionario autenticacao) {
        boolean sair = false;
        do {
            System.out.println("\nMENU DE FUNCIONÁRIOS");
            System.out.println("1 - LOGIN");
            System.out.println("2 - QUERO ME CADASTRAR");
            System.out.println("3 - CORRIGIR MEU CADASTRO (Falta implementar)");
            System.out.println("0 - VOLAR AO MENU PRINCIPAL");
            System.out.print("ESCOLHA A OPCAO ");
            int opcao = teclado.nextInt();
            teclado.nextLine(); // Consome a linha restante

            switch (opcao) {
                case 1:
                    autenticacao.realizarLogin();
                    break;
                case 2:
                    System.out.println("1 - Já possuo cadastro (Login)");
                    
                    break;
                case 3:
                    System.out.println("Funcionalidade de correção de cadastro ainda não implementada.");
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!sair);
    }

    void cadastrarNovoFuncionario(String nomeFunc, String telFunc, String loginFunc, String senhaFunc) {
        System.out.println("\nNOVO CADASTRO DE FUNCIONARIO");
        System.out.print("Qual o seu nome? ");
        String nome = teclado.nextLine();

        System.out.print("Qual o seu telefone? ");
        String telefone = teclado.nextLine();

        System.out.print("Digite um login: ");
        String login = teclado.nextLine();

        System.out.print("Digite uma senha: ");
        String senha = teclado.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, telefone, login, senha);
        adicionarFuncionario(novoFuncionario);
        System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");
    }
}