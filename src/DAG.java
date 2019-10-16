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
    private void validateVertex(int v){
        if((v<0)||(v>=V)){
            throw new IllegalArgumentException("Edgesless than one means no verices are joined, and if there is a cycle it cannot be moved");
        }
    }

    //adds directed edge from v to w
    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v][w]=1;
        indegree[w]++;
        outdegree[v]++;
        E++;
    }


    //returns the number of directed edges out of vertex v
    public int outdegree(int v){
        validateVertex(v);
        return outdegree[v];
    }

    //returns the number of directed edges into vertex v
    public int indegree(int v){
        validateVertex(v);
        return indegree[v];
    }

    //returns the vertices adjacent from vertex v
    public int[] adj(int v){
        validateVertex(v);
        int[] temp = new int[outdegree[v]];
        int count =0;
        for(int i=0;i<V;i++){
            if(adj[v][i]==1){
                temp[count]=i;
                count++;
            }
        }
        return temp;
    }


    //This public function is used to find the lowest commond ancestor in a directed acyclic graph
    public int findLCA(int v, int w){
        validateVertex(v);
        validateVertex(w);
//        hasCycle();
        if(E>0){
            return LCAUtil(v,w);
        }
        else{
            throw new IllegalArgumentException("No");
        }
    }

    //helper function for LCA
    private int LCAUtil(int v, int w){
        int[] vArr = new int[E];
        int[] wArr = new int[E];
        boolean[] vMarked = new boolean[V];
        boolean[] wMarked = new boolean[V];
        int vCount =0;
        int wCount = 0;
        vArr[vCount]=v;
        wArr[wCount]=w;
        for(int j=0; j<V;j++){//mark all vertices as not been visited yet
            vMarked[j]=false;
            wMarked[j]=false;
        }
        for(int i =0;i<V;i++){
            vMarked[v] =true;
            wMarked[w] =true;
            for(int j = 0; j<V;j++){
                if(adj[i][j]==1 && vMarked[i]){
                    vCount++;
                    vArr[vCount]=j;
                    vMarked[j]=true;
                }
                if(adj[i][j]==1 && wMarked[i]){
                    wCount++;
                    wArr[wCount]=j;
                    wMarked[j]=true;
                }
                if(wArr[wCount]==vArr[vCount]){
                    return wArr[wCount];
                }
            }
        }
        return -1;//returns -1 if no ancestor found
    }
}