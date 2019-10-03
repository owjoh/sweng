import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    @Test
    void testNullTree() {
        BinaryTree tree = new BinaryTree(null);
        assertNull(tree.lca(1, 2));
    }

    @Test
    void testOneNodeTree() {
        Node root = new Node(0);
        BinaryTree tree = new BinaryTree(root);
        assertTrue(tree.lca(0, 0) == root);
    }

    @Test
    void testNodePredecessor() {
        Node root = new Node(0);
        BinaryTree tree = new BinaryTree(root);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.right = new Node(7);
        assertTrue(tree.lca(0, 2) == root);
        assertTrue(tree.lca(6, 5) == tree.root.left);
    }
}