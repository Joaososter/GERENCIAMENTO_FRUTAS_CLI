import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class SetInterativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> frutas = new HashSet<>();

        while (true) {
            try {
                System.out.println("Escolha uma opcao:");
                System.out.println("1. Adicionar uma fruta");
                System.out.println("2. Listar todas as frutas");
                System.out.println("3. Remover uma fruta");
                System.out.println("4. Verificar se uma fruta esta presente");
                System.out.println("5. Sair");
                System.out.print("Opcao: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome da fruta para adicionar: ");
                        String novaFruta = scanner.nextLine().toLowerCase().trim(); // Normaliza a entrada
                        if (frutas.add(novaFruta)) {
                            System.out.println(novaFruta + " foi adicionada.");
                        } else {
                            System.out.println(novaFruta + " ja esta presente no conjunto.");
                        }
                        break;

                    case 2:
                        System.out.println("Frutas: " + frutas);
                        break;

                    case 3:
                        System.out.print("Digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine().toLowerCase().trim(); // Normaliza a entrada
                        if (frutas.remove(frutaRemover)) {
                            System.out.println(frutaRemover + " foi removida.");
                        } else {
                            System.out.println(frutaRemover + " nao foi encontrada.");
                        }
                        break;

                    case 4:
                        System.out.print("Digite o nome da fruta para verificar: ");
                        String frutaVerificar = scanner.nextLine().toLowerCase().trim(); // Normaliza a entrada
                        if (frutas.contains(frutaVerificar)) {
                            System.out.println(frutaVerificar + " esta presente no conjunto.");
                        } else {
                            System.out.println(frutaVerificar + " nao foi encontrado no conjunto.");
                        }
                        break;

                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, digite um numero.");
                scanner.nextLine(); // Limpa a entrada incorreta
            }
        }
    }
}
