import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DAGTest {

    @Test
    void testNullTree() {

    }

    @Test
    void testOneNodeTree() {

    }

    @Test
    void testLcaOnTheSameNode() {

    }

    @Test
    void testNodeThatDoesNotExist() {

    }

    @Test
    void v() {
        DAG dag = new DAG(100);
        assertTrue(dag.V == 100);
    }

    @Test
    void e() {
        DAG dag = new DAG(7);
        dag.addEdge(6,3);
        dag.addEdge(3,2);
        dag.addEdge(2,1);
        dag.addEdge(1,0);
        dag.addEdge(6,5);
        dag.addEdge(5,4);
        dag.addEdge(4,1);
        assertTrue(dag.E == 7);
    }

    @Test
    void addEdge() {
        DAG dag = new DAG(7);
        dag.addEdge(6,3);
        dag.addEdge(3,2);
        dag.addEdge(2,1);
        dag.addEdge(1,0);
        dag.addEdge(6,5);
        dag.addEdge(5,4);
        dag.addEdge(4,1);
        assertTrue(dag.adj[4][1] == 1);
        assertTrue(dag.adj[6][3] == 1);
        assertFalse(dag.adj[1][2]==1);
    }

    @Test
    void indegree() {
    }

    @Test
    void adj() {
    }

    @Test
    void hasCycle() {
    }

    @Test
    void findLCA() {
    }
}