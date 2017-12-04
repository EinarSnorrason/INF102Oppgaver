package alg.searching;

/**
 * Created by Einar Snorrason on 04/12/2017.
 */
public class BinarySearch {
    public static <T extends Comparable<T>>int rank(T[] list, T val){
        return rank(list,0,list.length-1,val);
    }

    public static <T extends Comparable<T>>int rank(T[] list, int lo, int hi, T val){
        while (lo<hi){
            int mid = (lo+hi)/2;
            if (list[mid]==val){
                return mid;
            } else if (list[mid].compareTo(val)<0){
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return hi;
    }
}
