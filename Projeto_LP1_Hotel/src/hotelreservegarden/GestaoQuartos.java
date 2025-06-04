package hotelreservegarden;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class GestaoQuartos {
    private List<Quarto> quartosDisponiveis;   

    public GestaoQuartos() {
        this.quartosDisponiveis = new ArrayList<>();
        cadastrarQuartosIniciais();
    }

    public static class Quarto {
        private int numero;
        private String tipo;
        private double diaria;
        private boolean disponivel;

        public Quarto(int numero, String tipo, double diaria, boolean disponivel) {
            this.numero = numero;
            this.tipo = tipo;
            this.diaria = diaria;
            this.disponivel = disponivel;
        }

         //get e set
        public int getNumero() { 
            return numero;         
        }
        public String getTipo() {
            return tipo; 
        }
        public double getDiaria() { 
            return diaria;
        }
        public boolean isDisponivel() {
            return disponivel;
        }
        public void setDisponivel(boolean disponivel) { 
            this.disponivel = disponivel; 
        }
    }

    // cadastrar quartos iniciais
    private void cadastrarQuartosIniciais() {
        quartosDisponiveis.add(new Quarto(101, "Standard", 200.00, true));
        quartosDisponiveis.add(new Quarto(102, "Standard", 200.00, true));
        quartosDisponiveis.add(new Quarto(201, "Luxo", 350.00, true));
        quartosDisponiveis.add(new Quarto(202, "Luxo", 350.00, true));
        quartosDisponiveis.add(new Quarto(301, "Suite Presid.", 600.00, true));
    }

    // Método para mostrar quartos disponíveis
    public void mostrarQuartosDisponiveis() {
        System.out.println("\n--- QUARTOS DISPONIVEIS: ---");
        System.out.println("--------------------------------------------------");
        System.out.println("NUMERO\tTIPO\t\tDIARIA\tDISPONIVEL");
        System.out.println("--------------------------------------------------");
        
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto.isDisponivel()) {
                System.out.printf("%d\t%-15sR$%.2f\t%s%n",
                        quarto.getNumero(),
                        quarto.getTipo(),
                        quarto.getDiaria(),
                        quarto.isDisponivel() ? "Sim" : "Nao");
            }
        }
        System.out.println("--------------------------------------------------");
    }

    // menu do funcionário com opções para gerenciar quartos
    public void menuFuncionario(Scanner teclado) {
        int opcaoFunc;
        do {
            System.out.println("\nMENU FUNCIONARIO - GESTAO DE QUARTOS");
            System.out.println("1 - CADASTRAR NOVO QUARTO");
            System.out.println("2 - REMOVER QUARTO");
            System.out.println("3 - ALTERAR STATUS DO QUARTO");
            System.out.println("4 - LISTAR TODOS OS QUARTOS");
            System.out.println("0 - VOLTAR");
            
            opcaoFunc = teclado.nextInt();
            teclado.nextLine(); // Limpar buffer
            
            switch(opcaoFunc) {
                case 1:
                    cadastrarNovoQuarto(teclado);
                    break;
                case 2:
                    removerQuarto(teclado);
                    break;
                case 3:
                    alterarStatusQuarto(teclado);
                    break;
                case 4:
                    listarTodosQuartos();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while(opcaoFunc != 0);
    }

    //gerenciar quartos
    private void cadastrarNovoQuarto(Scanner teclado) {
        System.out.println("\nCADASTRAR NOVO QUARTO");
        System.out.print("NUMERO DO QUARTO: ");
        int numero = teclado.nextInt();
        teclado.nextLine();
        
        System.out.print("TIPO DE QUARTO: ");
        String tipo = teclado.nextLine();
        
        System.out.print("VALOR: ");
        double diaria = teclado.nextDouble();
        
        quartosDisponiveis.add(new Quarto(numero, tipo, diaria, true));
        System.out.println("QUARTO CADASTRADO COM SUCESSO!");
    }
    
    private void removerQuarto(Scanner teclado) {
        System.out.print("\nDIGITE O NUMERO DO QUARTO: ");
        int numero = teclado.nextInt();
        
        for (int i = 0; i < quartosDisponiveis.size(); i++) {
            if (quartosDisponiveis.get(i).getNumero() == numero) {
                quartosDisponiveis.remove(i);
                System.out.println("QUARTO REMOVIDO COM SUCESSO!");
                return;
            }
        }
        System.out.println("Quarto não encontrado!");
    }
    
    private void alterarStatusQuarto(Scanner teclado) {
        System.out.print("\nDIGITE O NUMERO QUE QUER ALTERAR: ");
        int numero = teclado.nextInt();
        
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto.getNumero() == numero) {
                System.out.print("ALTERAR DISPONIBILIDADE (true/false): ");
                boolean disponivel = teclado.nextBoolean();
                quarto.setDisponivel(disponivel);
                System.out.println("STATUS DO QUARTO ATUALIZADO!");
                return;
            }
        }
        System.out.println("QUARTO NAO ENCONTRADO!");
    }
    
    private void listarTodosQuartos() {
        System.out.println("\nLISTA DE TODOS OS QUARTOS:");
        System.out.println("--------------------------------------------------");
        System.out.println("NUMERO\tTIPO\t\tDIARIA\tDISPONIVEL");
        System.out.println("--------------------------------------------------");
        
        for (Quarto quarto : quartosDisponiveis) {//faz uma interação onde busca os quartos 
            System.out.printf("%d\t%-15sR$%.2f\t%s%n",//formata os dados que %d( int ), \t(espaçamento e alinhamento das colunas), %-15s( o S - String, o - alinhara aesquerda, 15 - quantidade minima) %n pular a linha apos a formatção , 
                    quarto.getNumero(),
                    quarto.getTipo(),
                    quarto.getDiaria(),
                    quarto.isDisponivel() ? "Sim" : "Nao");
        }
        System.out.println("--------------------------------------------------");
    }
    
    // verificar se um quarto específico está disponível pelo numero do quarto
    public boolean isQuartoDisponivel(int numeroQuarto) {
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto.getNumero() == numeroQuarto && quarto.isDisponivel()) {
                return true;
            }
        }
        return false;
    }
    
    // obter um quarto pelo número
    public Quarto getQuartoPorNumero(int numeroQuarto) {
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto.getNumero() == numeroQuarto) {
                return quarto;
            }
        }
        return null;
    }
}


