package alg.union;

import java.util.ArrayList;
/**
 * Implementation of union find
 */
public class QuickFind implements IUnionFind {

    private ArrayList<Integer> nodes;
    private int count;

    public QuickFind(int N){
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
        return nodes.get(p);
    }

    @Override
    public void union(int p, int q) {
        if (!connected(p,q)){
            int a = find(p);
            int b = find(q);
            for (int i=0;i<nodes.size();i++){
                if (find(i)==b){
                    nodes.set(i,a);
                }
            }
            count--;
        }

    }

    @Override
    public String toString(){
        String ans = "[";
        for (int i=0;i<nodes.size()-1;i++) {
            ans += i + ", ";
        }
        ans += (nodes.size()-1)+"]\n"+nodes.toString();
        return ans;
    }
}
