public class Node {
    int iData;      // Chave
    double fData;   // Valor
    int height;     // Altura do nó
    Node leftChild;
    Node rightChild;

    public Node(int iData, double fData) {
        this.iData = iData;
        this.fData = fData;
        this.height = 1; // Inicializamos a altura como 1 para um novo nó
        this.leftChild = null;
        this.rightChild = null;
    }

    public void displayNode() {
        System.out.println("iData: " + iData + ", fData: " + fData + ", Height: " + height);
    }
}