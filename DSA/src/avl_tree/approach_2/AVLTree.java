package avl_tree.approach_2;

// AVL tree implementation in Java

// Create node
class Node {
    int item, height;
    Node left, right;

    Node(int d) {
        item = d;
        height = 1;
    }
}

// Tree class
class AVLTree {
    Node root;

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // Get balance factor of a node
    int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Insert a node
    Node insertNode(Node root, int item) {

        // Find the position and insert the node
        if (root == null)
            return (new Node(item));
        if (item < root.item)
            root.left = insertNode(root.left, item);
        else if (item > root.item)
            root.right = insertNode(root.right, item);
        else
            return root;

        // Update the balance factor of each node
        // And, balance the tree
        root.height = 1 + max(height(root.left), height(root.right));
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (item < root.left.item) {
                return rightRotate(root);
            } else if (item > root.left.item) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if (balanceFactor < -1) {
            if (item > root.right.item) {
                return leftRotate(root);
            } else if (item < root.right.item) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    Node nodeWithMimumValue(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a node
    Node deleteNode(Node root, int item) {

        // Find the node to be deleted and remove it
        if (root == null)
            return root;
        if (item < root.item)
            root.left = deleteNode(root.left, item);
        else if (item > root.item)
            root.right = deleteNode(root.right, item);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = nodeWithMimumValue(root.right);
                root.item = temp.item;
                root.right = deleteNode(root.right, temp.item);
            }
        }
        if (root == null)
            return root;

        // Update the balance factor of each node and balance the tree
        root.height = max(height(root.left), height(root.right)) + 1;
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.left) >= 0) {
                return rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(root.right) <= 0) {
                return leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.item + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Print the tree
    private void printTree(Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.item);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }

    // Driver code
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insertNode(tree.root, 14);
        tree.root = tree.insertNode(tree.root, 17);
        tree.root = tree.insertNode(tree.root, 11);
        tree.root = tree.insertNode(tree.root, 7);
        tree.root = tree.insertNode(tree.root, 53);
        tree.root = tree.insertNode(tree.root, 4);
        tree.printTree(tree.root, "", true);
        tree.root = tree.deleteNode(tree.root, 11);
        System.out.println("After Deletion: ");
        tree.printTree(tree.root, "", true);
    }
}

/*
References:
https://www.programiz.com/dsa/avl-tree
 */