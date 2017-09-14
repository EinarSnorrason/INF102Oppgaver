package alg.sorting;

/**
 * Insertion sort implementation
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
            // Insertion sort without exchanges (Ex 2.1.25)
            for (j=i;j>lo&&less(value,a[j-1]);j--){
                a[j]=a[j-1];
            }
            a[j]=value;
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }


}

