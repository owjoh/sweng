public class DAG{
    public int V;//# of vertices in graph
    public int E;//# of edges in graph
    public int[][] adj; //adjacency list for vertex v - changed to 2D array
    public int[] outdegree;//outdegree of vertex v
    public int[] indegree; // indegree of vertex v
    public int[] visited;  //vertices that have been visited
    public boolean hasCycle;


    //constructor to initialize and empty graph with size V
    public DAG(int V){
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        outdegree = new int[V];
        visited = new int[V];
        adj = new int[V][V];
        for(int i = 0; i<V; i++){//sets up an empty graph in 2D array
            for(int j=0;j<V;j++){
                adj[i][j] = 0;
            }
        }
    }

    //returns number of vertices in DAG
    public int V(){
        return V;
    }

    //returns number of edges in DAG
    public int E(){
        return E;
    }

    //throws illegal exception if the vertex put in, is out of bounds
    private void validateVertex(int v1){
        if((v1<0)||(v1>=V)){
            throw new IllegalArgumentException("Edgesless than one means no verices are joined, and if there is a cycle it cannot be moved");
        }
    }

    //adds directed edge from v to w
    public void addEdge(int v1, int v2){
        validateVertex(v1);
        validateVertex(v2);

        adj[v1][v2]=1;
        indegree[v2]++;
        outdegree[v1]++;
        E++;
    }


    //returns the number of directed edges out of vertex v1
    public int outdegree(int v1){
        validateVertex(v1);
        return outdegree[v1];
    }

    //returns the number of directed edges into vertex v
    public int indegree(int v1){
        validateVertex(v1);
        return indegree[v1];
    }

    //returns the vertices adjacent from vertex v
    public int[] adj(int v1){
        validateVertex(v1);
        int[] temp = new int[outdegree[v1]];
        int count =0;
        for(int i=0;i<V;i++){
            if(adj[v1][i]==1){
                temp[count]=i;
                count++;
            }
        }
        return temp;
    }


    //This public function is used to find the lowest commond ancestor in a directed acyclic graph
    public int findLCA(int v1, int v2){
        if(this.V == 0) {
            return -1;
        }
        else if(v1 >= V || v2 >= V) {
            return -1;
        }
        validateVertex(v1);
        validateVertex(v2);
//        hasCycle();
        if(E>0){
            return LCAUtil(v1,v2);
        }
        else{
            return -1;
        }
    }

    //helper function for LCA
    private int LCAUtil(int v1, int v2){
        int[] v1Arr = new int[E];
        int[] v2Arr = new int[E];
        boolean[] v1Marked = new boolean[V];
        boolean[] v2Marked = new boolean[V];
        int v1Count =0;
        int v2Count = 0;
        v1Arr[v1Count]=v1;
        v2Arr[v2Count]=v2;
        for(int j=0; j<V;j++){//mark all vertices as not been visited yet
            v1Marked[j]=false;
            v2Marked[j]=false;
        }
        for(int i =0;i<V;i++){
            v1Marked[v1] =true;
            v2Marked[v2] =true;
            for(int j = 0; j<V;j++){
                if(adj[i][j]==1 && v1Marked[i]){
                    v1Count++;
                    v1Arr[v1Count]=j;
                    v1Marked[j]=true;
                }
                if(adj[i][j]==1 && v2Marked[i]){
                    v2Count++;
                    v2Arr[v2Count]=j;
                    v2Marked[j]=true;
                }
                if(v2Arr[v2Count]==v1Arr[v1Count]){
                    return v2Arr[v2Count];
                }
            }
        }
        return -1;//returns -1 if no ancestor found
    }
}