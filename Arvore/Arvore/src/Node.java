class Node {
    int iData; // dado usado como valor-chave
    double fData; // outro dado
    Node leftChild; // filho à esquerda deste nó
    Node rightChild; // filho à direita deste nó

    public Node(int iData, double fData) {
        this.iData = iData;
        this.fData = fData;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void displayNode() {
        System.out.println("iData: " + iData + ", fData: " + fData);
    }
}
