import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir elementos manualmente");
            System.out.println("2. Mostrar árvore em lista");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Escolha o número de elementos a serem inseridos (100, 500, 1000, 10000, 20000):");
                    int numElements = scanner.nextInt();
                    if (numElements == 100 || numElements == 500 || numElements == 1000 || numElements == 10000 || numElements == 20000) {
                        long startTime = System.nanoTime();
                        for (int i = 0; i < numElements; i++) {
                            int randomKey = random.nextInt(100000); // Gere chaves aleatórias de 0 a 99.999
                            double randomValue = random.nextDouble(); // Gere valores aleatórios entre 0.0 e 1.0
                            tree.insert(randomKey, randomValue);
                        }
                        long endTime = System.nanoTime();
                        long elapsedTime = endTime - startTime;
                        System.out.println("Inserção de " + numElements + " elementos levou " + (elapsedTime / 1000000) + " milissegundos.");

                        // Medição do tempo total para construir a árvore
                        System.out.println("Tempo total para construir a árvore: " + (elapsedTime / 1000000) + " milissegundos.");
                    } else {
                        System.out.println("Número de elementos inválido. Escolha entre 100, 500, 1000, 10000 ou 20000.");
                    }
                    break;
                case 2:
                    System.out.println("Árvore em lista:");
                    tree.displayInOrder();
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
