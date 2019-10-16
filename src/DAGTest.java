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
        assertTrue(dag.V() == 100);
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
        assertTrue(dag.E() == 7);
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
        DAG dag = new DAG(7);
        dag.addEdge(6,3);
        dag.addEdge(3,2);
        dag.addEdge(2,1);
        dag.addEdge(1,0);
        dag.addEdge(6,5);
        dag.addEdge(5,4);
        dag.addEdge(4,1);
        assertTrue(dag.indegree(1) == 2);
        assertTrue(dag.indegree(0) == 1);
    }

    @Test
    void outdegree() {
        DAG dag = new DAG(7);
        dag.addEdge(6,3);
        dag.addEdge(3,2);
        dag.addEdge(2,1);
        dag.addEdge(1,0);
        dag.addEdge(6,5);
        dag.addEdge(5,4);
        dag.addEdge(4,1);
        assertTrue(dag.outdegree(6)==2);
        assertTrue(dag.outdegree(1)==1);
    }

    @Test
    void adj() {
        DAG dag = new DAG(4);
        dag.addEdge(0,1);
        dag.addEdge(0,2);
        dag.addEdge(0,3);
        int[] expected = {1,2,3};
        int[] result = dag.adj(0);
        if(result.length != expected.length) {
            fail();
        }
        for(int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void findLCA() {
        DAG dag = new DAG(7);
        dag.addEdge(6,3);
        dag.addEdge(3,2);
        dag.addEdge(2,1);
        dag.addEdge(1,0);
        dag.addEdge(6,5);
        dag.addEdge(5,4);
        dag.addEdge(4,1);
        int lca = dag.findLCA(2,2);
        assertEquals(2,lca);
    }
}