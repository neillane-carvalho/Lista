import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ativ03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> filaSupermercado = new LinkedList<>();

        System.out.println("Bem-vindo ao Gerenciador de Fila de Supermercado!");

        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("a) Inserir cliente na fila");
            System.out.println("b) Remover cliente da fila");
            System.out.println("c) Consultar quantidade de clientes na fila");
            System.out.println("d) Sair");

            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();
                    filaSupermercado.offer(cliente);
                    System.out.println("Cliente \"" + cliente + "\" adicionado à fila.");
                    break;
                case "b":
                    if (!filaSupermercado.isEmpty()) {
                        String clienteRemovido = filaSupermercado.poll();
                        System.out.println("Cliente \"" + clienteRemovido + "\" removido da fila.");
                    } else {
                        System.out.println("A fila está vazia. Não há clientes para remover.");
                    }
                    break;
                case "c":
                    int tamanhoFila = filaSupermercado.size();
                    System.out.println("A fila de supermercado atualmente tem " + tamanhoFila + " cliente(s).");
                    break;
                case "d":
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }
}
