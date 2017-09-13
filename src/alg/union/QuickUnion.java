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
        int temp = nodes.get(p);
        if (temp == p){
            return p;
        } else {
            nodes.set(p,find(temp));
            return nodes.get(p);
        }
    }

    @Override
    public void union(int p, int q) {
        int a = find(p);
        int b = find(q);
        if (a == b){
            return;
        }
        nodes.set(a,b);
        count--;


    }

    @Override
    public String toString(){
        return nodes.toString();
    }
}
