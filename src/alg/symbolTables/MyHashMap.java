package alg.symbolTables;

import java.util.LinkedList;

/**
 * Created by Einar Snorrason on 04/12/2017.
 */
public class MyHashMap <K,V>{
    private int n;
    private LinkedList<Pair>[] buckets;

    public MyHashMap(){
        this(15);
    }

    public MyHashMap(int n){
        this.n = n;
        buckets = new LinkedList[n];
        for (int i=0;i<n;i++) buckets[i]=new LinkedList<>();
    }

    public void put(K key,V value){
        int index = key.hashCode()%n;
        buckets[index].add(new Pair(key,value));
    }

    public V get(K key){
        int index = key.hashCode()%n;
        for (Pair p:buckets[index]){
            if (p.key==key) return p.value;
        }
        return null;
    }

    public boolean contains(K key){
        return get(key)!=null;
    }

    private class Pair{
    K key;
    V value;
    private Pair(K key, V value){
        this.key=key;
        this.value = value;
    }
    }
}


