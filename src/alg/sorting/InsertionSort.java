package alg.sorting;

/**
 * Created by Einar Snorrason on 04/09/2017.
 */
public class InsertionSort {
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    // Sorts given part of an array
    public static void sort(Comparable[] a, int lo, int hi){
        for (int i=lo+1;i<=hi;i++){
            Comparable value = a[i];
            int j;
            for (j=i;j>lo&&less(value,a[j-1]);j--){
                a[j]=a[j-1];
            }
            a[j]=value;
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    public static void swap(Comparable[] a, int  i, int j){
        Comparable t = a[j];
        a[j] = a[i];
        a[i] = t;
    }


}

