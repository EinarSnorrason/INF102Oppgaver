package alg.union;

import java.util.ArrayList;

/**
 * Quick union implementation of union Find with path compression
 */
public class QuickUnion implements IUnionFind {
    private ArrayList<Integer> nodes;
    private int count;

    public QuickUnion(int N){
        count = N;
        nodes = new ArrayList<>();
        for (int i=0;i<N;i++){
            nodes.add(i);
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return (find(p)==find(q));
    }

    @Override
    public int find(int p) {
        while (p!=nodes.get(p)){
            p=nodes.get(p);
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int a = find(p);
        int b = find(q);

        int temp;

        if (a != b){
            nodes.set(a,b);
            count--;
        }

        // Path compression:
        while(nodes.get(p)!=b){
            temp = nodes.get(p);
            nodes.set(p,b);
            p=temp;
        }
        while(nodes.get(q)!=b){
            temp = nodes.get(q);
            nodes.set(q,b);
            q=temp;
        }

    }

    @Override
    public String toString(){
        return nodes.toString();
    }
}
