import java.util.ArrayList;

public class DAG {
    Node root;

    public class Node {
        int data;
        ArrayList<Node> succs;

        Node(int data) {
            this.data = data;
            this.succs = new ArrayList<>();
        }
    }
}
