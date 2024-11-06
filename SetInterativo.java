import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class SetInterativo {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);     // Inicializa o scanner para leitura de entradas do usuário


        // Cria um conjunto (HashSet) para armazenar as frutas. 
        // Usamos Set para evitar duplicatas automaticamente.
        Set<String> frutas = new HashSet<>();

        while (true) {    // Loop infinito que permite ao usuário interagir com o programa até escolher sair
            try {   //menu de opcoes ao usuario 
                System.out.println("Escolha uma opcao:");
                System.out.println("1. Adicionar uma fruta");
                System.out.println("2. Listar todas as frutas");
                System.out.println("3. Remover uma fruta");
                System.out.println("4. Verificar se uma fruta esta presente");
                System.out.println("5. Sair");
                System.out.print("Opcao: ");

                int opcao = scanner.nextInt(); // le a opcao escolhida pelo usuario
                scanner.nextLine(); // Consome a nova linha

                switch (opcao) {  //avalia a opcao escolhida 
                    case 1:
                        System.out.print("Digite o nome da fruta para adicionar: ");  //opcao para escolher nova fruta
                        String novaFruta = scanner.nextLine().toLowerCase().trim(); // Normaliza a entrada
                        if (frutas.add(novaFruta)) {  // Tenta adicionar a fruta ao conjunto
                            System.out.println(novaFruta + " foi adicionada.");
                        } else {
                            System.out.println(novaFruta + " ja esta presente no conjunto.");
                        }
                        break;

                    case 2:  
                        // Opção para listar todas as frutas
                        System.out.println("Frutas: " + frutas);
                        break;

                    case 3:
                        // Opção para remover uma fruta existente
                        System.out.print("Digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine().toLowerCase().trim(); // Normaliza a entrada
                        if (frutas.remove(frutaRemover)) { // Tenta remover a fruta
                            System.out.println(frutaRemover + " foi removida.");
                        } else {
                            System.out.println(frutaRemover + " nao foi encontrada.");
                        }
                        break;

                    case 4:
                         // Opção para verificar se uma fruta está no conjunto
                        System.out.print("Digite o nome da fruta para verificar: ");
                        String frutaVerificar = scanner.nextLine().toLowerCase().trim(); // Normaliza a entrada
                        if (frutas.contains(frutaVerificar)) {
                            System.out.println(frutaVerificar + " esta presente no conjunto.");
                        } else {
                            System.out.println(frutaVerificar + " nao foi encontrado no conjunto.");
                        }
                        break;

                    case 5:
                         // Opção para sair do programa
                        System.out.println("Saindo...");
                        scanner.close(); // Fecha o scanner para liberar recursos
                        return;  // Encerra o programa

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
