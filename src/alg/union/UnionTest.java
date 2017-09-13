package alg.union;

import java.util.Random;
import java.util.Scanner;

/**
 * Class that tests union find implementations. Creates nodes equal to 
 * size variable, then creates 5*size random connections and times how
 * long this takes.
 */

public class UnionTest {
    public static void main(String[] args){
        int size = 1000000;
        double time;
        Random random = new Random();

        IUnionFind uf1 = new QuickUnion(size);
        IUnionFind uf2 = new WeightedUnion(size);


        long start = System.nanoTime();
        for (int i=0;i<size*5;i++){
            uf1.union(random.nextInt(size),random.nextInt(size));
        }
        time = (System.nanoTime()-start)/1000000000.0;
        System.out.println("QuickUnion:");
        System.out.println(uf1.count());
        System.out.println(time+" ms\n");

        start = System.nanoTime();
        for (int i=0;i<size*5;i++){
            uf2.union(random.nextInt(size),random.nextInt(size));
        }
        time = (System.nanoTime()-start)/1000000000.0;
        System.out.println("WeightedUnion:");
        System.out.println(uf2.count());
        System.out.println(time+" s\n");


    }

}
