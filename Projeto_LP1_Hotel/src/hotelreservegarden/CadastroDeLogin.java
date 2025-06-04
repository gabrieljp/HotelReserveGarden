package hotelreservegarden;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroDeLogin {
    private List<Usuario> usuarios;
    private Scanner teclado;
    private GerenciadorDeReservas gerenciadorDeReservas;

    public CadastroDeLogin(Scanner teclado, GerenciadorDeReservas gerenciadorDeReservas) {
        this.usuarios = new ArrayList<>();
        this.teclado = teclado;
        this.gerenciadorDeReservas = gerenciadorDeReservas;
        usuarios.add(new Usuario("gabriel", "99999999", "gabriel", "123"));
    }

    // Setter para gerenciadorDeReservas (para lidar com a ordem de inicialização)
    public void setGerenciadorDeReservas(GerenciadorDeReservas gerenciadorDeReservas) {
        this.gerenciadorDeReservas = gerenciadorDeReservas;
    }

    public static class Usuario {
        private String nome;
        private String telefone;
        private String login;
        private String senha;

        public Usuario(String nome, String telefone, String login, String senha) {
            this.nome = nome.toUpperCase();
            this.telefone = telefone;
            this.login = login.toUpperCase();
            this.senha = senha;
        }

        public String getNome() { return nome; }
        public String getTelefone() { return telefone; }
        public String getLogin() { return login; }
        public String getSenha() { return senha; }

        public void setNome(String nome) { this.nome = nome.toUpperCase(); }
        public void setTelefone(String telefone) { this.telefone = telefone; }
        public void setLogin(String login) { this.login = login.toUpperCase(); }
        public void setSenha(String senha) { this.senha = senha; }
    }

    public void cadastrar() {
        System.out.println("\n--- CADASTRO DE USUARIO ---");
        System.out.print("QUAL O SEU NOME? ");
        String nome = teclado.nextLine().toUpperCase();
        System.out.print("QUAL O SEU TELEFONE? ");
        String telefone = teclado.nextLine();
        System.out.print("DIGITE UM LOGIN: ");
        String login = teclado.nextLine().toUpperCase();
        if (buscarUsuarioPorLogin(login) != null) {
            System.out.println("LOGIN JA EXISTENTE. CADASTRO CANCELADO.");
            return;
        }
        System.out.print("DIGITE UMA SENHA: ");
        String senha = teclado.nextLine();

        usuarios.add(new Usuario(nome, telefone, login, senha));
        System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equalsIgnoreCase(login)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean realizarLogin(String login, String senha) {
        Usuario usuario = buscarUsuarioPorLogin(login);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            System.out.println("\nLOGIN REALIZADO COM SUCESSO, " + usuario.getNome() + "!\n");
            return true;
        } else {
            System.out.println("\nLOGIN OU SENHA INCORRETO!\n");
            return false;
        }
    }

    public void corrigirCadastro() {
        System.out.println("\n--- CORRIGIR CADASTRO DE USUARIO ---");
        System.out.print("DIGITE SEU LOGIN: ");
        String loginParaCorrigir = teclado.nextLine().toUpperCase();

        Usuario usuarioParaCorrigir = buscarUsuarioPorLogin(loginParaCorrigir);

        if (usuarioParaCorrigir != null) {
            System.out.println("\nDADOS ATUAIS:");
            System.out.println("NOME: " + usuarioParaCorrigir.getNome());
            System.out.println("TELEFONE: " + usuarioParaCorrigir.getTelefone());
            System.out.println("LOGIN: " + usuarioParaCorrigir.getLogin());

            System.out.println("\nDIGITE OS NOVOS DADOS (DEIXE EM BRANCO PARA MANTER O ATUAL):");
            System.out.print("NOVO NOME: ");
            String novoNome = teclado.nextLine().toUpperCase();
            if (!novoNome.isEmpty()) {
                usuarioParaCorrigir.setNome(novoNome);
            }

            System.out.print("NOVO TELEFONE: ");
            String novoTelefone = teclado.nextLine();
            if (!novoTelefone.isEmpty()) {
                usuarioParaCorrigir.setTelefone(novoTelefone);
            }

            System.out.print("NOVO LOGIN: ");
            String novoLogin = teclado.nextLine().toUpperCase();
            if (!novoLogin.isEmpty()) {
                if (buscarUsuarioPorLogin(novoLogin) == null || usuarioParaCorrigir.getLogin().equalsIgnoreCase(novoLogin)) {
                    usuarioParaCorrigir.setLogin(novoLogin);
                } else {
                    System.out.println("LOGIN JA EXISTENTE. A CORRECAO DO LOGIN FOI IGNORADA.");
                }
            }

            System.out.print("NOVA SENHA: ");
            String novaSenha = teclado.nextLine();
            if (!novaSenha.isEmpty()) {
                usuarioParaCorrigir.setSenha(novaSenha);
            }

            System.out.println("\nCADASTRO ATUALIZADO COM SUCESSO!\n");

        } else {
            System.out.println("\nUSUARIO NAO ENCONTRADO COM O LOGIN INFORMADO.\n");
        }
    }

    public void excluirCadastro() {
        System.out.println("\n--- EXCLUIR CADASTRO DE USUARIO ---");
        System.out.print("DIGITE SEU LOGIN PARA CONFIRMAR A EXCLUSAO: ");
        String loginParaExcluir = teclado.nextLine().toUpperCase();

        Usuario usuarioParaExcluir = buscarUsuarioPorLogin(loginParaExcluir);

        if (usuarioParaExcluir != null) {
            System.out.print("TEM CERTEZA QUE DESEJA EXCLUIR SEU CADASTRO? (SIM/NAO): ");
            String confirmacao = teclado.nextLine().toUpperCase();
            if (confirmacao.equals("SIM")) {
                usuarios.remove(usuarioParaExcluir);
                System.out.println("\nCADASTRO EXCLUIDO COM SUCESSO!\n");
            } else {
                System.out.println("\nEXCLUSAO CANCELADA.\n");
            }
        } else {
            System.out.println("\nUSUARIO NAO ENCONTRADO COM O LOGIN INFORMADO.\n");
        }
    }

    public void menuUsuario() {
    boolean sair = false;
    do {
        System.out.println("\n--- MENU DO USUARIO ---");
        System.out.println("1 - JA TENHO UMA RESERVA");
        System.out.println("2 - FAZER RESERVA");
        System.out.println("3 - CORRIGIR MEU CADASTRO");
        System.out.println("4 - EXCLUIR MEU CADASTRO");
        System.out.println("5 - FAZER MEU CADASTRO");
        System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
        System.out.print("ESCOLHA A OPCAO: ");
        int opcao = teclado.nextInt();
        teclado.nextLine(); // Consome a linha restante

        switch (opcao) {
            case 1:
                System.out.println("\n--- VERIFICAR MINHA RESERVA ---");
                System.out.print("DIGITE SEU LOGIN: ");
                String loginVerificarReserva = teclado.nextLine().toUpperCase();
                System.out.print("DIGITE SUA SENHA: ");
                String senhaVerificarReserva = teclado.nextLine();

                Usuario usuarioVerificar = buscarUsuarioPorLogin(loginVerificarReserva);
                if (usuarioVerificar != null && realizarLogin(loginVerificarReserva, senhaVerificarReserva)) {
                    List<GerenciadorDeReservas.Reserva> reservasUsuario = HotelReserveGarden.gerenciadorDeReservas.buscarReservasPorUsuario(usuarioVerificar);
                    if (reservasUsuario.isEmpty()) {
                        System.out.println("\nVOCE NAO POSSUI NENHUMA RESERVA.\n");
                    } else {
                        System.out.println("\nSUAS RESERVAS:");
                        for (GerenciadorDeReservas.Reserva reserva : reservasUsuario) {
                            HotelReserveGarden.gerenciadorDeReservas.exibirReserva(reserva);
                        }
                        System.out.println("\nOPCOES DE RESERVA:");
                        System.out.println("5 - CORRIGIR RESERVA");
                        System.out.println("6 - EXCLUIR RESERVA");
                        System.out.print("ESCOLHA A OPCAO (0 para voltar): ");
                        int opcaoGerenciarReserva = teclado.nextInt();
                        teclado.nextLine(); // Consome a linha restante

                        switch (opcaoGerenciarReserva) {
                            case 5:
                                HotelReserveGarden.gerenciadorDeReservas.corrigirReserva(usuarioVerificar);
                                break;
                            case 6:
                                HotelReserveGarden.gerenciadorDeReservas.excluirReserva(usuarioVerificar);
                                break;
                            case 0:
                                System.out.println("VOLTANDO AO MENU DO USUARIO.");
                                break;
                            default:
                                System.out.println("OPCAO INVALIDA.");
                        }
                    }
                }
                break;
            case 2:
                HotelReserveGarden.gerenciadorDeReservas.fazerReserva();
                break;
            case 3:
                corrigirCadastro();
                break;
            case 4:
                excluirCadastro();
                break;
            case 5:
                cadastrar();
            break;
            case 0:
                System.out.println("VOLTANDO AO MENU PRINCIPAL.");
                sair = true;
                break;
            default:
                System.out.println("OPCAO INVALIDA!");
        }
    } while (!sair);

    }
}