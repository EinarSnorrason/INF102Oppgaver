package alg.union;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Einar Snorrason on 30/08/2017.
 */

public class UnionTest {
    public static void main(String[] args){
        int size = 5000000;
        double time;
        Random random = new Random();

        IUnionFind uf1 = new QuickFind(size);
        IUnionFind uf2 = new QuickUnion(size);
        IUnionFind uf3 = new WeightedUnion(size);
        Scanner in = new Scanner(System.in);
        long start = System.nanoTime();
        /**for (int i=0;i<size*5;i++){
            uf1.union(random.nextInt(size),random.nextInt(size));
        }
        time = (System.nanoTime()-start)/1000000.0;
        System.out.println("QuickFind:");
        System.out.println(uf1.count());
        System.out.println(time+" ms\n");

        start = System.nanoTime();
         **/
        /**for (int i=0;i<size*5;i++){
            uf2.union(random.nextInt(size),random.nextInt(size));
        }
        time = (System.nanoTime()-start)/1000000.0;
        System.out.println("QuickUnion:");
        System.out.println(uf2.count());
        System.out.println(time+" ms\n");
        **/
        start = System.nanoTime();
        for (int i=0;i<size*5;i++){
            uf3.union(random.nextInt(size),random.nextInt(size));
        }
        time = (System.nanoTime()-start)/1000000000.0;
        System.out.println("WeightedUnion:");
        System.out.println(uf3.count());
        System.out.println(time+" s\n");


    }

}
