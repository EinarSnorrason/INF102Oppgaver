package alg.oblig1;

import java.util.Arrays;
import java.util.Random;

/**
 * Compares linear search to binary search on unsorted lists with different amounts of searches
 */
public class profitSorting {

    /**
     * Simple linear search
     * @param array
     * @param value
     * @return position of element in array
     */

    private static final int arraySize = 1000000;
    private static final int ceiling = Integer.MAX_VALUE;
    private static Random random = new Random();
    private static int[] largeArray = new int[arraySize];


    private static int linearSearch(int[] array, int value){
        for (int i=0;i<array.length;i++){
            if (value==array[i]){
                return i;
            }
        }
        // Element is not in array
        return -1;
    }

    private static int binarySearch(int[] list, int key) {
        int lo = 0;
        int hi = list.length - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (key == list[mid]) return mid;
            else if (key < list[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        int N = 10;
        int cutoff = 0;
        for (int i=0;i<N;i++){
            cutoff += findCutoff();
        }
        System.out.println("Cutoff is: "+cutoff/N);
    }

    public static int findCutoff(){

        // Create array:
        double linearTime = 0;
        double binaryTime = 0;
        int S = 5;

        while(true){
            if (compareSearches(S)) break;
            S*=2;
        }
        // Use binary search to find out when binary search becomes profitable
        int hi = S;
        int lo = S/2;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (compareSearches(mid)) hi = mid -1;
            else lo = mid + 1;
        }
        System.out.println(lo);
        return lo;
    }

    /**
     * Tests linear and binary search on a list with 1 million integers, and returns true
     * if binary search was faster
     * @param S number of searches to perform
     * @return true if binary search was faster
     */
    private static boolean compareSearches(int S){
        for (int i=0;i<arraySize;i++){
            largeArray[i]= random.nextInt();
        }

        // linear search
        double time = System.nanoTime();
        for(int i=0;i<S;i++){
            int value = random.nextInt();
            int pos = linearSearch(largeArray,value);
            if (pos>=0){
                System.out.println(value+" found at: "+pos);
            }
        }
        double linearTime = (System.nanoTime()-time)/Math.pow(10,6);

        // binary search
        time = System.nanoTime();
        Arrays.sort(largeArray);
        for(int i=0;i<S;i++){
            int value = random.nextInt();
            int pos = binarySearch(largeArray,value);
            if (pos>=0){
                System.out.println(value+" found at: "+pos);
            }
        }
        double binaryTime = (System.nanoTime()-time)/Math.pow(10,6);
        return linearTime>binaryTime;
    }
}
