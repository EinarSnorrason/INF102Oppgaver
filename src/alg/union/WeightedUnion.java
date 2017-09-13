package alg.union;

import java.util.ArrayList;

/**
 * Weighted union implementation of union find with path compression
 */
public class WeightedUnion implements IUnionFind {
    private ArrayList<Integer> nodes;
    private ArrayList<Integer> size;
    private int count;

    public WeightedUnion(int N){
        count = N;
        nodes = new ArrayList<>();
        size = new ArrayList<>();
        for (int i=0;i<N;i++){
            nodes.add(i);
            size.add(1);
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
        int sza = size.get(a);
        int szb = size.get(b);
        int root;
        int temp;

        if (a == b){
            return;
        }

        // Compare sizes to figure out which parent to set as root
        if (sza<szb){
            root = b;
            size.set(b,sza+szb);
        } else {
            root = a;
            size.set(a,sza+szb);
        }

        // Path compression:
        while(nodes.get(p)!=root){
            temp = nodes.get(p);
            nodes.set(p,root);
            p=temp;
        }
        while(nodes.get(q)!=root){
            temp = nodes.get(q);
            nodes.set(q,root);
            q=temp;
        }
        count--;
    }

    @Override
    public String toString(){
        return nodes.toString();
    }
}
