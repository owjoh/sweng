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

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(new Node(1));
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.right = new Node(7);
        System.out.println(tree.lca(7,5).data);

    }
}
