package directedGraphs;

/**
 * Created by Einar Snorrason on 04/12/2017.
 */
public class DirectedDFS {
    private boolean marked[];
    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    public boolean marked(int a){return this.marked[a];}

    private void dfs(Digraph G, int s){
        marked[s] = true;
        for (int a:G.adj(s)){
            if (!marked[a]){
                dfs(G,a);
            }
        }
    }
}
