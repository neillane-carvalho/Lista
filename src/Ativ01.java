import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ativ01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> playlist = new LinkedList<>();

        System.out.println("Bem-vindo ao Gerenciador de Playlist!");

        boolean sair = false;
        while (!sair){
            System.out.println("Escolha uma opção:");
            System.out.println("a) Inserir música na playlist");
            System.out.println("b) Consultar próxima música da playlist");
            System.out.println("c) Remover música da playlist");
            System.out.println("d) Sair");

            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao){
                case "a":
                    System.out.print("Digite o nome da música a ser inserida: ");
                    String musica = scanner.nextLine();
                    playlist.offer(musica);
                    System.out.println("Música \"" + musica + "\" adicionada à playlist.");
                    break;
                case "b":
                    if (!playlist.isEmpty()) {
                        String proximaMusica = playlist.peek();
                        System.out.println("Próxima música da playlist: " + proximaMusica);
                    } else {
                        System.out.println("A playlist está vazia.");
                    }
                    break;
                case "c":
                    if (!playlist.isEmpty()) {
                        String musicaRemovida = playlist.poll();
                        System.out.println("Música removida da playlist: " + musicaRemovida);
                    } else {
                        System.out.println("A playlist está vazia. Não há músicas para remover.");
                    }
                    break;
                case "d":
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");

            }
        }
    }
}