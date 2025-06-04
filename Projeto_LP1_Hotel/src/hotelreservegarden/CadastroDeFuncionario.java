package hotelreservegarden;

import java.util.ArrayList;
import java.util.Locale; // Import para usar Locale.ENGLISH
import java.util.Scanner;

public class CadastroDeFuncionario {
    private ArrayList<Funcionario> funcionarios;
    private Scanner teclado = new Scanner(System.in);

    public CadastroDeFuncionario() {
        this.funcionarios = new ArrayList<>();
        adicionarFuncionario(new Funcionario("ADMINISTRADOR", "123456789", "ADMIN", "ADMIN123"));
        adicionarFuncionario(new Funcionario("GERENTE", "987654321", "GABRIEL", "123"));
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public Funcionario buscarFuncionarioPorLogin(String login) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getLogin().equalsIgnoreCase(login)) { // Ignorar case para busca
                return funcionario;
            }
        }
        return null;
    }

    public void exibirMenuCadastro(AuthenticacaoLoginFuncionario autenticacao) {
        boolean sair = false;
        do {
            System.out.println("\nMENU DE FUNCIONARIOS");
            System.out.println("1 - LOGIN");
            System.out.println("2 - QUERO ME CADASTRAR");
            System.out.println("3 - CORRIGIR MEU CADASTRO");
            System.out.println("4 - EXCLUIR MEU CADASTRO");
            System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
            System.out.print("ESCOLHA A OPCAO ");
            int opcao = teclado.nextInt();
            teclado.nextLine(); // Consome a linha restante

            switch (opcao) {
                case 1:
                    autenticacao.realizarLogin();
                    break;
                case 2:
                    cadastrarNovoFuncionario();
                    break;
                case 3:
                    corrigirCadastroFuncionario();
                    break;
                case 4:
                    excluirCadastroFuncionario();
                    break;
                case 0:
                    System.out.println("VOLTANDO AO MENU PRINCIPAL");
                    sair = true;
                    break;
                default:
                    System.out.println("OPCAO INVALIDA!");
            }
        } while (!sair);
    }

    public void cadastrarNovoFuncionario() {
        System.out.println("\nNOVO CADASTRO DE FUNCIONARIO");
        System.out.print("QUAL O SEU NOME? ");
        String nome = teclado.nextLine().toUpperCase();
        System.out.print("QUAL O SEU TELEFONE? ");
        String telefone = teclado.nextLine();
        System.out.print("DIGITE UM LOGIN: ");
        String login = teclado.nextLine().toUpperCase();
        System.out.print("DIGITE UMA SENHA: ");
        String senha = teclado.nextLine();
        Funcionario novoFuncionario = new Funcionario(nome, telefone, login, senha);
        adicionarFuncionario(novoFuncionario);
        System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");
    }

    private void corrigirCadastroFuncionario() {
        System.out.println("\n--- CORRIGIR CADASTRO DE FUNCIONARIO ---");
        System.out.print("DIGITE O SEU LOGIN: ");
        String loginParaCorrigir = teclado.nextLine().toUpperCase();//transforma em maiúsculas 

        Funcionario funcionarioParaCorrigir = buscarFuncionarioPorLogin(loginParaCorrigir);

        if (funcionarioParaCorrigir != null) {
            System.out.println("\nDADOS ATUAIS:");
            System.out.println("NOME: " + funcionarioParaCorrigir.getNome());
            System.out.println("TELEFONE: " + funcionarioParaCorrigir.getTelefone());
            System.out.println("LOGIN: " + funcionarioParaCorrigir.getLogin());
            System.out.println("SENHA: " + funcionarioParaCorrigir.getSenha());

            System.out.println("\nDIGITE OS NOVOS DADOS (DEIXE EM BRANCO PARA MANTER O ATUAL):");
            System.out.print("NOVO NOME: ");
            String novoNome = teclado.nextLine().toUpperCase();
            if (!novoNome.isEmpty()) {
                funcionarioParaCorrigir.setNome(novoNome);
            }

            System.out.print("NOVO TELEFONE: ");
            String novoTelefone = teclado.nextLine();
            if (!novoTelefone.isEmpty()) {
                funcionarioParaCorrigir.setTelefone(novoTelefone);
            }

            System.out.print("NOVO LOGIN: ");
            String novoLogin = teclado.nextLine().toUpperCase();//toUpperCase pega a String resultante do nextLine() e converte todos os caracteres para letras maiúsculas.
            if (!novoLogin.isEmpty()) {
                if (buscarFuncionarioPorLogin(novoLogin) == null || funcionarioParaCorrigir.getLogin().equalsIgnoreCase(novoLogin)) {
                    funcionarioParaCorrigir.setLogin(novoLogin);
                } else {
                    System.out.println("LOGIN JA EXISTENTE. A CORRECAO DO LOGIN FOI IGNORADA.");
                }
            }

            System.out.print("NOVA SENHA: ");
            String novaSenha = teclado.nextLine();
            if (!novaSenha.isEmpty()) {// o metodo isEmpty verifica se a nova senha fornecida não está vazia antes de atribuí-la ao objeto funcionarioParaCorrigir
                funcionarioParaCorrigir.setSenha(novaSenha);
            }

            System.out.println("\nCADASTRO ATUALIZADO COM SUCESSO!\n");

        } else {
            System.out.println("\nFUNCIONARIO NAO ENCONTRADO COM O LOGIN INFORMADO.\n");
        }
    }

    private void excluirCadastroFuncionario() {
        System.out.println("\n--- EXCLUIR CADASTRO DE FUNCIONARIO ---");
        System.out.print("DIGITE O SEU LOGIN PARA CONFIRMAR A EXCLUSAO: ");
        String loginParaExcluir = teclado.nextLine().toUpperCase();

        Funcionario funcionarioParaExcluir = buscarFuncionarioPorLogin(loginParaExcluir);

        if (funcionarioParaExcluir != null) {
            System.out.print("TEM CERTEZA QUE DESEJA EXCLUIR SEU CADASTRO? (SIM/NAO): ");
            String confirmacao = teclado.nextLine().toUpperCase();
            if (confirmacao.equals("SIM")) {
                funcionarios.remove(funcionarioParaExcluir);
                System.out.println("\nCADASTRO EXCLUIDO COM SUCESSO!\n");
            } else {
                System.out.println("\nEXCLUSAO CANCELADA.\n");
            }
        } else {
            System.out.println("\nFUNCIONARIO NAO ENCONTRADO COM O LOGIN INFORMADO.\n");
        }
    }
}