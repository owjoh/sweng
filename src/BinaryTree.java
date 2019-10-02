public class BinaryTree {
    Node root;

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

        findLca(node.left,node1, node2);
        findLca(node.right, node1, node2);

        return null;
    }
}
