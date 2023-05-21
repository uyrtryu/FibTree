import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciTree {

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static Node fibonacciTree(int n, Map<Integer, Node> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n < 2) {
            return new Node(n);

        }
        Node root = new Node(fibonacci(n));
        root.left = fibonacciTree(n - 1, memo);
        root.right = fibonacciTree(n - 2, memo);
        memo.put(n, root);
        return root;
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private static void outputTree(Node node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.value);
        outputTree(node.right, level + 1);
        outputTree(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n. n - это какое-то по счету число Фибоначчи");
        int n = scanner.nextInt();
        Map<Integer, Node> memo = new HashMap<>();
        Node root = fibonacciTree(n, memo);
        outputTree(root,0);
    }
}