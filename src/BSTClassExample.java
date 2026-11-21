
import java.util.Scanner;

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
    }
}

public class BSTClassExample {

    // Insert a character into the Binary Search Tree
    static Node insert(Node root, char value) {

        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        }
        else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Inorder Traversal: Left, Root, Right
    static void inorder(Node root) {

        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal: Root, Left, Right
    static void preorder(Node root) {

        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal: Left, Right, Root
    static void postorder(Node root) {

        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Receive the number of characters
        System.out.print("Enter the number of characters: ");
        int size = input.nextInt();

        // Create an array to store characters
        char[] data = new char[size];

        // Receive character values
        System.out.println("Enter " + size + " characters (enter 'null' to skip):");

        for (int i = 0; i < size; i++) {

            String value = input.next();

            // Skip null values
            if (value.equalsIgnoreCase("null")) {
                data[i] = '\0';
            }
            else {
                data[i] = value.charAt(0);
            }
        }

        // Construct the Binary Search Tree
        Node root = null;

        for (int i = 0; i < size; i++) {

            if (data[i] != '\0') {
                root = insert(root, data[i]);
            }
        }

        // Display menu until user selects Exit
        int choice;

        do {
            System.out.println("\n===== BINARY SEARCH TREE MENU =====");
            System.out.println("1. Inorder traversal");
            System.out.println("2. Preorder traversal");
            System.out.println("3. Postorder traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Inorder Traversal:");
                    inorder(root);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Preorder Traversal:");
                    preorder(root);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Postorder Traversal:");
                    postorder(root);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
            // Continues the program as long at the user does not type 4.
        } while (choice != 4);

        input.close();
    }
}

// Assisted by ChatGPT
