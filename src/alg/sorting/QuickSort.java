package alg.sorting;

import java.util.Random;

/**
 * Created by Einar Snorrason on 10/09/2017.
 */
public class QuickSort {
    private static Random random = new Random();
    public static void sort(Comparable[] a){
        shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi-lo<=15) {
            InsertionSort.sort(a,lo,hi);
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        //Choose pivot
        Comparable v = a[lo];
        int l=lo, h=hi;

        while(true){
            while (less(v,a[h])) h--;
            while(l<h && !less(v,a[l+1])) l++;
            if (l+1<h){
                swap(a,l+1,h);
                l++;
            }
            else break;
        }
        swap(a,l,lo);
        return l;
    }
    private static void shuffle(Comparable[] a){
        for (int i=0;i<a.length;i++){
            swap(a,i,i+random.nextInt(a.length-i));
        }

    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    private static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
