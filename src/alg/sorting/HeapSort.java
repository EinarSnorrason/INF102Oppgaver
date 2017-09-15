package alg.sorting;

/**
 * Implementation of HeapSort, constructs a max first heap to sort a given list
 */
public class HeapSort {

    /**
     * Sorts given list using heapsort
     * @param a List to be sorted
     */
    public static <T extends Comparable<? super T>> void sort(T[] a){
        int N = a.length-1;
        // Construct heap
        for (int k=N/2; k>=0; k--){
            sink(a,k,N);
        }
        /* Since 1 is always largest value, we can swap it for the last value,then
         * fix the heap at each step to sort the list
         */
        while (N>=1){
            swap(a,0,N--);
            sink(a,0,N);
        }
    }

    /**
     * Sinks value at index i in heap a down to correct position
     * N is length of heap
     */
    private static <T extends Comparable<? super T>> void sink(T[] a, int i, int N){
        int max = i;
        while (true){
            int leftChild = 2*i+1;
            int rightChild = 2*i+2;
            if (leftChild<=N && less(a,max,leftChild)) max = leftChild;
            if (rightChild<=N && less(a,max,rightChild)) max = rightChild;
            if (max != i){
                swap(a,i,max);
                i=max;
            } else break;
        }
    }

    private static <T extends Comparable<? super T>> boolean less(T[] a, int i, int j){
        return a[i].compareTo(a[j])<0;
    }
    /**
     * Swaps two variables in given list
     */
    private static <T extends Comparable<? super T>> void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
