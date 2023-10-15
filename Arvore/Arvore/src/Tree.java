class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insert(int id, double dd) {
        root = insertRec(root, id, dd);
    }

    private Node insertRec(Node root, int id, double dd) {
        if (root == null) {
            return new Node(id, dd);
        }

        if (id < root.iData) {
            root.leftChild = insertRec(root.leftChild, id, dd);
        } else if (id > root.iData) {
            root.rightChild = insertRec(root.rightChild, id, dd);
        }

        return root;
    }

    public Node find(int key) {
        return findRec(root, key);
    }

    private Node findRec(Node root, int key) {
        if (root == null || root.iData == key) {
            return root;
        }

        if (key < root.iData) {
            return findRec(root.leftChild, key);
        }

        return findRec(root.rightChild, key);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.iData) {
            root.leftChild = deleteRec(root.leftChild, key);
        } else if (key > root.iData) {
            root.rightChild = deleteRec(root.rightChild, key);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }

            root.iData = minValue(root.rightChild);
            root.rightChild = deleteRec(root.rightChild, root.iData);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.iData;
        while (root.leftChild != null) {
            minValue = root.leftChild.iData;
            root = root.leftChild;
        }
        return minValue;
    }

    public void displayInOrder() {
        displayInOrder(root);
    }

    private void displayInOrder(Node node) {
        if (node != null) {
            displayInOrder(node.leftChild);
            System.out.println("Valor: " + node.iData); 
            displayInOrder(node.rightChild);
        }
    }
}