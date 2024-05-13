import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ativ02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Contato> filaContatos = new LinkedList<>();

        System.out.println("Bem-vindo ao Gerenciador de Call Center!");

        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("a) Inserir Contato");
            System.out.println("b) Próximo Contato");
            System.out.println("c) Sair");

            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    Contato novoContato = new Contato(nome, telefone);
                    filaContatos.offer(novoContato);
                    System.out.println("Contato adicionado à fila.");
                    break;
                case "b":
                    if (!filaContatos.isEmpty()) {
                        Contato proximoContato = filaContatos.poll();
                        System.out.println("\nPróximo Contato:");
                        System.out.println(proximoContato);
                        System.out.println("Efetue o contato com o cliente.");
                    } else {
                        System.out.println("Não há contatos na fila.");
                    }
                    break;
                case "c":
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        }
    }
}
