//TEST2
//PART_1

import java.io.*;
import java.util.*;

public class BST {
    private Node root;

    public BST() {
        root = null;
    }

    // Function to insert a value into the BST
    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    // Function to print the BST in LNR (Inorder) traversal
    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    // Function to count the number of nodes in the BST
    private int countNodes(Node root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Function to check if a value x exists in the BST
    private boolean search(Node root, int x) {
        if (root == null)
            return false;

        if (root.data == x)
            return true;
        else if (x < root.data)
            return search(root.left, x);
        else
            return search(root.right, x);
    }

    // Function to find the successor of a node
    private Node findSuccessor(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Function to perform a BST operation based on the input file
    public void performBSTOperations(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                root = insert(root, value);
            }
            scanner.close();

            System.out.println("BST in LNR (Inorder) traversal:");
            inorderTraversal(root);
            System.out.println("\nNumber of nodes in the BST: " + countNodes(root));

            int searchValue = 11;
            System.out.println("Does " + searchValue + " exist in the BST? " + search(root, searchValue));

            int successorValue = 19;
            Node successor = findSuccessor(root.left); // Finding successor of node with value 19
            System.out.println("Successor of " + successorValue + ": " + successor.data);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    // Main function
    public static void main(String[] args) {
        BST bst = new BST();
        bst.performBSTOperations("text.txt");
    }
}
