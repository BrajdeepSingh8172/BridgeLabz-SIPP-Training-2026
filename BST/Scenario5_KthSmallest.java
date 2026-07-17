import java.util.*;

class Node {
    int val;
    Node left, right;
}

class Scenario5 {
    int kthSmallest(Node root, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (--k == 0) {
                return current.val;
            }

            current = current.right;
        }

        throw new IllegalArgumentException();
    }
}
