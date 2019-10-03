public class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    Node lca(int node1, int node2) {
        return findLca(this.root, node1, node2);
    }

    Node findLca(Node node, int node1, int node2) {

        //Recursion base case
        if(node == null) {
            return null;
        }

        if(node.data == node1 || node.data == node2) {
            return node;
        }

        Node left = findLca(node.left,node1, node2);
        Node right = findLca(node.right, node1, node2);

        if(left != null && right != null) {
            return node;
        }

        return (left != null) ? left : right;
    }

}
