package hotelreservegarden;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeReservas {//criando a classe que gerencia as reservas 
    private List<Reserva> reservas;
    private GestaoQuartos gestaoQuartos;
    private CadastroDeLogin cadastroDeLogin;
    private Scanner teclado;

    public GerenciadorDeReservas(GestaoQuartos gestaoQuartos, CadastroDeLogin cadastroDeLogin, Scanner teclado) {//esse é o metodo construtor, quando instaciarmos a classe no main , ele que sera chamado
        this.reservas = new ArrayList<>();// o this.reservas faz refenrencia ao atributo reservas o o new ArrayList cria uma lista vazia e atrinui a reserva
        this.gestaoQuartos = gestaoQuartos;
        this.cadastroDeLogin = cadastroDeLogin;
        this.teclado = teclado;
    }

    public static class Reserva {
        private CadastroDeLogin.Usuario usuario;
        private GestaoQuartos.Quarto quarto;
        // Adicione outros detalhes da reserva, como datas, número de hóspedes, etc.

        public Reserva(CadastroDeLogin.Usuario usuario, GestaoQuartos.Quarto quarto) {
            this.usuario = usuario;
            this.quarto = quarto;
        }

        public CadastroDeLogin.Usuario getUsuario() { return usuario; }
        public GestaoQuartos.Quarto getQuarto() { return quarto; }

        public void setQuarto(GestaoQuartos.Quarto quarto) {
            this.quarto = quarto;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Reserva reserva = (Reserva) o;
            return usuario.equals(reserva.usuario) && quarto.equals(reserva.quarto);
        }

        @Override
        public int hashCode() {
            int result = usuario.hashCode();
            result = 31 * result + quarto.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "RESERVA - Usuario: " + usuario.getNome() + ", Quarto: " + quarto.getNumero() + " (" + quarto.getTipo() + ")";
        }
    }

    public void fazerReserva() {
        System.out.println("\n--- FAZER UMA RESERVA ---");
        System.out.print("DIGITE SEU LOGIN: ");
        String login = teclado.nextLine().toUpperCase();
        System.out.print("DIGITE SUA SENHA: ");
        String senha = teclado.nextLine();

        CadastroDeLogin.Usuario usuario = cadastroDeLogin.buscarUsuarioPorLogin(login);

        if (usuario != null && cadastroDeLogin.realizarLogin(login, senha)) {
            gestaoQuartos.mostrarQuartosDisponiveis();
            System.out.print("DIGITE O NUMERO DO QUARTO QUE DESEJA RESERVAR: ");
            int numeroQuarto = teclado.nextInt();
            teclado.nextLine(); // Consome a linha restante

            GestaoQuartos.Quarto quartoParaReservar = gestaoQuartos.getQuartoPorNumero(numeroQuarto);

            if (quartoParaReservar != null && quartoParaReservar.isDisponivel()) {
                quartoParaReservar.setDisponivel(false); // Altera o status do quarto
                Reserva novaReserva = new Reserva(usuario, quartoParaReservar);
                reservas.add(novaReserva);
                System.out.println("\nRESERVA REALIZADA COM SUCESSO!\n" + novaReserva);
            } else if (quartoParaReservar == null) {
                System.out.println("\nQUARTO NAO ENCONTRADO.\n");
            } else {
                System.out.println("\nQUARTO INDISPONIVEL.\n");
            }
        }
    }

    public List<Reserva> buscarReservasPorUsuario(CadastroDeLogin.Usuario usuario) {
        List<Reserva> reservasDoUsuario = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                reservasDoUsuario.add(reserva);
            }
        }
        return reservasDoUsuario;
    }

    public void exibirReserva(Reserva reserva) {
        System.out.println("-------------------------");
        System.out.println("QUARTO: " + reserva.getQuarto().getNumero() + " (" + reserva.getQuarto().getTipo() + ")");
        // Exiba outros detalhes da reserva aqui (datas, etc.)
        System.out.println("-------------------------");
    }

    public void corrigirReserva(CadastroDeLogin.Usuario usuario) {
        System.out.println("\n--- CORRIGIR RESERVA ---");
        List<Reserva> reservasDoUsuario = buscarReservasPorUsuario(usuario);
        if (reservasDoUsuario.isEmpty()) {
            System.out.println("VOCE NAO POSSUI NENHUMA RESERVA PARA CORRIGIR.");
            return;
        }

        
        System.out.println("SUAS RESERVAS:");
        for (int i = 0; i < reservasDoUsuario.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + reservasDoUsuario.get(i));
        }

        System.out.print("DIGITE O NUMERO DA RESERVA QUE DESEJA CORRIGIR (0 para cancelar): ");
        int escolhaReserva = teclado.nextInt();
        teclado.nextLine(); // Consome a linha restante

        if (escolhaReserva > 0 && escolhaReserva <= reservasDoUsuario.size()) {
            Reserva reservaParaCorrigir = reservasDoUsuario.get(escolhaReserva - 1);
            System.out.println("\nRESERVA SELECIONADA: " + reservaParaCorrigir);

            System.out.println("\nO QUE DESEJA ALTERAR?");
            System.out.println("1 - QUARTO");
            // Adicione outras opções de alteração (datas, etc.)
            System.out.println("0 - CANCELAR CORRECAO");
            System.out.print("ESCOLHA A OPCAO: ");
            int escolhaAlteracao = teclado.nextInt();
            teclado.nextLine(); // Consome a linha restante

            switch (escolhaAlteracao) {
                case 1:
                    System.out.println("\n--- ALTERAR QUARTO ---");
                    gestaoQuartos.mostrarQuartosDisponiveis();
                    System.out.print("DIGITE O NUMERO DO NOVO QUARTO: ");
                    int novoNumeroQuarto = teclado.nextInt();
                    teclado.nextLine(); // Consome a linha restante
                    GestaoQuartos.Quarto novoQuarto = gestaoQuartos.getQuartoPorNumero(novoNumeroQuarto);
                    if (novoQuarto != null && novoQuarto.isDisponivel()) {
                        // Libera o quarto antigo
                        reservaParaCorrigir.getQuarto().setDisponivel(true);
                        // Aloca o novo quarto
                        novoQuarto.setDisponivel(false);
                        reservaParaCorrigir.setQuarto(novoQuarto);
                        System.out.println("RESERVA ALTERADA PARA O QUARTO: " + novoQuarto.getNumero());
                    } else if (novoQuarto == null) {
                        System.out.println("QUARTO NAO ENCONTRADO.");
                    } else {
                        System.out.println("QUARTO INDISPONIVEL.");
                    }
                    break;
                case 0:
                    System.out.println("CORRECAO CANCELADA.");
                    break;
                default:
                    System.out.println("OPCAO INVALIDA.");
            }
        } else if (escolhaReserva != 0) {
            System.out.println("NUMERO DE RESERVA INVALIDO.");
        } else {
            System.out.println("CORRECAO CANCELADA.");
        }
    }

    public void excluirReserva(CadastroDeLogin.Usuario usuario) {
        System.out.println("\n--- EXCLUIR RESERVA ---");
        List<Reserva> reservasDoUsuario = buscarReservasPorUsuario(usuario);
        if (reservasDoUsuario.isEmpty()) {
            System.out.println("VOCE NAO POSSUI NENHUMA RESERVA PARA EXCLUIR.");
            return;
        }

        System.out.println("SUAS RESERVAS:");
        for (int i = 0; i < reservasDoUsuario.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + reservasDoUsuario.get(i));
        }

        System.out.print("DIGITE O NUMERO DA RESERVA QUE DESEJA EXCLUIR (0 para cancelar): ");
        int escolhaReserva = teclado.nextInt();
        teclado.nextLine(); // Consome a linha restante

        if (escolhaReserva > 0 && escolhaReserva <= reservasDoUsuario.size()) {
            Reserva reservaParaExcluir = reservasDoUsuario.get(escolhaReserva - 1);
            System.out.print("TEM CERTEZA QUE DESEJA EXCLUIR A RESERVA PARA O QUARTO " +
                    reservaParaExcluir.getQuarto().getNumero() + "? (SIM/NAO): ");
            String confirmacao = teclado.nextLine().toUpperCase();
            if (confirmacao.equals("SIM")) {
                reservas.remove(reservaParaExcluir);
                // Libera o quarto novamente
                reservaParaExcluir.getQuarto().setDisponivel(true);
                System.out.println("RESERVA EXCLUIDA COM SUCESSO!");
            } else {
                System.out.println("EXCLUSAO CANCELADA.");
            }
        } else if (escolhaReserva != 0) {
            System.out.println("NUMERO DE RESERVA INVALIDO.");
        } else {
            System.out.println("EXCLUSAO CANCELADA.");
        }
    }

    public void listarReservas() {
        System.out.println("\n--- LISTA DE RESERVAS ---");
        if (reservas.isEmpty()) {
            System.out.println("NENHUMA RESERVA ENCONTRADA.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
        System.out.println("-------------------------\n");
    }
}