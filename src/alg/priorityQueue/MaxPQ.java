package alg.priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implementaton of Priority Queue that sorts highest variable first
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private ArrayList<Key> pq;
    private Comparator<Key> c;

    private int parent(int key) {return (key-1)/2;}
    private int leftChild(int key) {return 2*key+1;}
    private int rightChild(int key) {return 2*key+2;}

    public MaxPQ(){
        pq = new ArrayList<>();
    }

    public MaxPQ(Comparator<Key> c){
        pq = new ArrayList<>();
        this.c = c;

    }

    public Key max(){
        return pq.get(0);
    }

    public void insert(Key v){
        pq.add(v);
        swim(size()-1);
    }

    /**
     * Returns and removes the largest key
     *
     */
    public Key delMax(){
        Key max = max();
        swap(0,size()-1);
        pq.remove(size()-1);
        sink(0);
        return max;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public int size(){
        return pq.size();
    }

    private boolean less(int i, int j){
        return c==null ? pq.get(i).compareTo(pq.get(j))<0 :c.compare(pq.get(i),pq.get(j))<0;
    }

    private void swap(int i, int j){
        Collections.swap(pq,i,j);
    }

    private void swim(int key){
        Key value = pq.get(key);
        while (key>0 && value.compareTo(pq.get(parent(key)))>0) {
            //swap(parent(key),key);
            pq.set((key),pq.get(parent(key)));
            key = parent(key);
        }
        pq.set(key,value);

    }

    private void sink(int key){
        int max = key;
        while (true) {
            if (leftChild(key) < size() && less(max, leftChild(key))) max = leftChild(key);
            if (rightChild(key) < size() && less(max, rightChild(key))) max = rightChild(key);
            if (max != key) {
                swap(key,max);
                key = max;
            } else break;
        }
    }



}

