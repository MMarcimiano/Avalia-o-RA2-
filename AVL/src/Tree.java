public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insert(int key, double value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, int key, double value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key < node.iData) {
            node.leftChild = insert(node.leftChild, key, value);
        } else if (key > node.iData) {
            node.rightChild = insert(node.rightChild, key, value);
        } else {
            // Não são permitidos valores duplicados
            return node;
        }

        return balance(node);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.iData) {
            node.leftChild = delete(node.leftChild, key);
        } else if (key > node.iData) {
            node.rightChild = delete(node.rightChild, key);
        } else {
            if ((node.leftChild == null) || (node.rightChild == null)) {
                node = (node.leftChild != null) ? node.leftChild : node.rightChild;
            } else {
                Node minRight = findMin(node.rightChild);
                node.iData = minRight.iData;
                node.fData = minRight.fData;
                node.rightChild = delete(node.rightChild, minRight.iData);
            }
        }

        return balance(node);
    }

    private Node findMin(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.iData) {
            return true;
        } else if (key < node.iData) {
            return search(node.leftChild, key);
        } else {
            return search(node.rightChild, key);
        }
    }

    public void displayInOrder() {
        displayInOrder(root);
    }

    private void displayInOrder(Node node) {
        if (node != null) {
            displayInOrder(node.leftChild);
            System.out.println("Value: " + node.fData); // Exibe apenas o valor, não a chave
            displayInOrder(node.rightChild);
        }
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    private int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.leftChild) - height(node.rightChild);
    }

    private Node rotateRight(Node y) {
        Node x = y.leftChild;
        Node T2 = x.rightChild;

        x.rightChild = y;
        y.leftChild = T2;

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.rightChild;
        Node T2 = y.leftChild;

        y.leftChild = x;
        x.rightChild = T2;

        return y;
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        if (balanceFactor(node) > 1) {
            if (balanceFactor(node.leftChild) < 0) {
                node.leftChild = rotateLeft(node.leftChild);
            }
            return rotateRight(node);
        }
        if (balanceFactor(node) < -1) {
            if (balanceFactor(node.rightChild) > 0) {
                node.rightChild = rotateRight(node.rightChild);
            }
            return rotateLeft(node);
        }

        return node;
    }

    public Node find(int key) {
        return find(root, key);
    }

    private Node find(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key == node.iData) {
            return node;
        } else if (key < node.iData) {
            return find(node.leftChild, key);
        } else {
            return find(node.rightChild, key);
        }
    }
}
