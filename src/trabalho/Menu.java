package trabalho;

import java.util.Scanner;



public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();
        int opcao;
        do {
        	
            exibirMenu();
         // capta a opção escolhida pelo usuário
            opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1:
                    adicionarMoeda(scanner, cofrinho);
                    break;
                case 2:
                    removerMoeda(scanner, cofrinho);
                    break;
                case 3:
                    cofrinho.listarMoedas();
                    break;
                case 4:
                    System.out.printf("Total em reais: R$ %.2f\n", cofrinho.calcularTotalEmReais());
                    break;
                case 5:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
     // fecha o scanner apos o uso
        scanner.close();
    }
 // exibe o menu de opçoes para o usuário
    private static void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1 - Adicionar moeda");
        System.out.println("2 - Remover moeda");
        System.out.println("3 - Listar moedas");
        System.out.println("4 - Calcular total em reais");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }

    private static void adicionarMoeda(Scanner scanner, Cofrinho cofrinho) {
        System.out.println("Escolha o tipo de moeda a adicionar (1 - Real, 2 - Dólar, 3 - Euro): ");
        int tipo = obterOpcao(scanner);  
        
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de moeda inválido.");
            return;
        }

        // Solicitar a quantidade de moedas a ser adicionada
        System.out.print("Digite a quantidade de moedas a adicionar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro válido.");
            scanner.next(); 
        }
        int quantidadeAdicionar = scanner.nextInt();

        // Adicionar a quantidade de moedas 
        switch (tipo) {
            case 1: 
                cofrinho.adicionarMoeda(new Real(1.0), quantidadeAdicionar);
                break;
            case 2: 
                cofrinho.adicionarMoeda(new Dolar(1.0, 5.00), quantidadeAdicionar);
                break;
            case 3:
                cofrinho.adicionarMoeda(new Euro(1.0), quantidadeAdicionar);
                break;
        }
    }

    private static void removerMoeda(Scanner scanner, Cofrinho cofrinho) {
        System.out.println("Escolha o tipo de moeda a remover (1 - Real, 2 - Dólar, 3 - Euro): ");
        int tipo = obterOpcao(scanner); 

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de moeda inválido.");
            return;
        }

        // Solicita a quantidade de moedas a ser removida
        System.out.print("Digite a quantidade de moedas a remover: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro válido.");
            scanner.next(); 
        }
        int quantidadeRemover = scanner.nextInt();

        // Remover a quantidade de moedas de acordo com o tipo
        switch (tipo) {
            case 1: // Real
                cofrinho.removerMoeda(Real.class, quantidadeRemover);
                break;
            case 2: // Dólar
                cofrinho.removerMoeda(Dolar.class, quantidadeRemover);
                break;
            case 3: // Euro
                cofrinho.removerMoeda(Euro.class, quantidadeRemover);
                break;
        }
    }

}