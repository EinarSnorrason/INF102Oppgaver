package alg.sorting;

/**
 * Performs counting sort for ints between 0 and 99
 */
public class CountingSort {
    public static void sort(Integer[] a){
        sort(a,0,100);
    }
    public static void sort(Integer[] a,int start, int stop){
        int[] values = new int[stop-start];
        for(int i:a){
            values[i-start]++;
        }
        int i = 0;
        for (int j=0;j<values.length;j++){
            while(values[j]-->0){
                a[i++]=j+start;
            }
        }
    }
}
