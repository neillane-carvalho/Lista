import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ativ04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Aluno> filaSalaDeAula = new LinkedList<>();

        System.out.println("Bem-vindo ao Gerenciador de Fila da Sala de Aula!");

        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("a) Inserir aluno na fila");
            System.out.println("b) Consultar alunos na fila");
            System.out.println("c) Sair");

            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a idade do aluno: ");
                    int idade = Integer.parseInt(scanner.nextLine());
                    Aluno novoAluno = new Aluno(nome, idade);
                    inserirOrdenadoPorIdade(filaSalaDeAula, novoAluno);
                    System.out.println("Aluno \"" + nome + "\" adicionado à fila.");
                    break;
                case "b":
                    if (!filaSalaDeAula.isEmpty()) {
                        System.out.println("\nAlunos na fila da sala de aula:");
                        for (Aluno aluno : filaSalaDeAula) {
                            System.out.println(aluno);
                        }
                    } else {
                        System.out.println("A fila está vazia. Não há alunos para consultar.");
                    }
                    break;
                case "c":
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }

    private static void inserirOrdenadoPorIdade(Queue<Aluno> fila, Aluno novoAluno) {
        Queue<Aluno> temp = new LinkedList<>();
        while (!fila.isEmpty() && fila.peek().getIdade() < novoAluno.getIdade()) {
            temp.offer(fila.poll());
        }
        fila.offer(novoAluno);
        while (!temp.isEmpty()) {
            fila.offer(temp.poll());
        }
    }
}
