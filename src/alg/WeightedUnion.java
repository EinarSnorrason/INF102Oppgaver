package alg;

import java.util.ArrayList;

/**
 * Created by Einar Snorrason on 30/08/2017.
 */
public class WeightedUnion implements IUnionFind{
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
        if (nodes.get(p)==p){
            return p;
        } else {
            nodes.set(p,find(nodes.get(p)));
            return nodes.get(p);
        }
    }

    @Override
    public void union(int p, int q) {
        int a = find(p);
        int b = find(q);
        int sza = size.get(a);
        int szb = size.get(b);

        if (a == b){
            return;
        }
        if (sza<szb){
            nodes.set(a,b);
            size.set(b,sza+szb);
        } else {
            nodes.set(b,a);
            size.set(a,sza+szb);
        }
        count--;
    }

    @Override
    public String toString(){
        return nodes.toString();
    }
}
