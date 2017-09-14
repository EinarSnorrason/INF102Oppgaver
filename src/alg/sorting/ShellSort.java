package alg.sorting;

/**
 * Created by Einar Snorrason on 04/09/2017.
 */
public class ShellSort {
    public static void hsort(int h, Comparable[] a){
        for (int i=h;i<a.length;i++){
            Comparable value = a[i];
            int j;
            for (j=i;j-h>=0&&less(value,a[j-h]);j-=h){
                a[j] = a[j-h];
            }
            a[j] = value;
        }
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        while(N>1){
            hsort(N,a);
            N /=3;
        }
        hsort(1,a);
    }


    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }



}
