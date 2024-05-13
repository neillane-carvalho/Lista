import java.util.Scanner;
import java.util.Stack;

public class Ativ05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Paciente> pilhaAtendimento = new Stack<>();

        System.out.println("Bem-vindo ao Gerenciador de Atendimento!");

        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("a) Inserir Paciente");
            System.out.println("b) Atender Paciente");
            System.out.println("c) Verificar se há paciente");
            System.out.println("d) Indicar próximo paciente a ser atendido");
            System.out.println("e) Quantidade de pacientes que aguardam atendimento");
            System.out.println("f) Sair");

            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    System.out.print("Digite o nome do paciente: ");
                    String nomePaciente = scanner.nextLine();
                    Paciente novoPaciente = new Paciente(nomePaciente);
                    pilhaAtendimento.push(novoPaciente);
                    System.out.println("Paciente \"" + nomePaciente + "\" inserido na pilha de atendimento.");
                    break;
                case "b":
                    if (!pilhaAtendimento.isEmpty()) {
                        Paciente pacienteAtendido = pilhaAtendimento.pop();
                        System.out.println("Paciente \"" + pacienteAtendido.getNome() + "\" atendido.");
                    } else {
                        System.out.println("Não há pacientes para atender.");
                    }
                    break;
                case "c":
                    System.out.println("Há paciente(s) aguardando atendimento: " + (!pilhaAtendimento.isEmpty()));
                    break;
                case "d":
                    if (!pilhaAtendimento.isEmpty()) {
                        System.out.println("Próximo paciente a ser atendido: " + pilhaAtendimento.peek().getNome());
                    } else {
                        System.out.println("Não há pacientes para atender.");
                    }
                    break;
                case "e":
                    System.out.println("Quantidade de pacientes aguardando atendimento: " + pilhaAtendimento.size());
                    break;
                case "f":
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }
}
