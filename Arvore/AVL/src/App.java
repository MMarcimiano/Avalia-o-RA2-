import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Tree theTree = new Tree();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir nó");
            System.out.println("2. Deletar nó");
            System.out.println("3. Buscar nó");
            System.out.println("4. Inserir aleatoriamente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Digite a chave do nó a ser inserido: ");
                    int keyInsert = scanner.nextInt();
                    System.out.print("Digite o valor associado ao nó: ");
                    double valueInsert = scanner.nextDouble();
                    theTree.insert(keyInsert, valueInsert);
                    break;
                case 2:
                    System.out.print("Digite a chave do nó a ser deletado: ");
                    int keyDelete = scanner.nextInt();
                    theTree.delete(keyDelete);
                    break;
                case 3:
                    System.out.print("Digite a chave do nó a ser buscado: ");
                    int keySearch = scanner.nextInt();
                    Node found = theTree.find(keySearch);
                    if (found != null) {
                        System.out.println("Nó encontrado:");
                        found.displayNode();
                    } else {
                        System.out.println("Nó não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite a quantidade de elementos a serem inseridos aleatoriamente: ");
                    int numElements = scanner.nextInt();
                    for (int i = 0; i < numElements; i++) {
                        int randomKey = random.nextInt(10000); // Gere chaves aleatórias de 0 a 9999
                        double randomValue = random.nextDouble(); // Gere valores aleatórios entre 0.0 e 1.0
                        theTree.insert(randomKey, randomValue);
                    }
                    System.out.println(numElements + " elementos foram inseridos aleatoriamente.");
                    break;
                case 5:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
