package alg.symbolTables;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList implementation of a symbol table
 */
public class ArrayListST <Key extends Comparable<? super Key>, Value> implements Iterable<Key>{

    private int N = 0;
    private ArrayList<Key> keys = new ArrayList<>();
    private ArrayList<Value> values = new ArrayList<>();

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<Key> iterator(){
        return keys.iterator();
    }

    private int rank(Key key){
        int lo=0; int hi = N-1;
        while (lo<=hi){
            int mid = (hi+lo)/2;
            int cmp = key.compareTo(keys.get(mid));
            if (cmp==0) return mid;
            else if (cmp<0) hi=mid-1;
            else lo = mid+1;
        }
        return lo;
    }

    public void put(Key key, Value v){
        int pos = rank(key);
        if (pos<N && key.equals(keys.get(pos))) values.set(pos,v);
        else{
            keys.add(pos,key);
            values.add(pos,v);
            N++;
        }
    }

    public Value get(Key key){
        int pos = rank(key);
        if (pos<N && key.equals(keys.get(pos))){
            return values.get(pos);
        }
        else {
            return null;
        }
    }

    public Value del(Key key){
        int pos = rank(key);
        if (pos<N && key.equals(keys.get(pos))){
            keys.remove(pos);
            N--;
            return values.remove(pos);
        }
        else{
            return null;
        }
    }

    @Override
    public String toString(){
        String s = "";
        for (Key k:keys){
            s+= k+" ";
        }
        s+="\n";
        for (Value v:values){
            s+= v+" ";
        }
        return s;
    }
}
