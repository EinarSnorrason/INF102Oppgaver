package alg.sorting;

/**
 * ShellSort implementation
 */
public class ShellSort {
    private static  <T extends Comparable<? super T>>void hsort(int h, T[] a){
        for (int i=h;i<a.length;i++){
            T value = a[i];
            int j;
            for (j=i;j-h>=0&&less(value,a[j-h]);j-=h){
                a[j] = a[j-h];
            }
            a[j] = value;
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] a){
        int N = a.length;
        while(N>1){
            hsort(N,a);
            N /=3;
        }
        hsort(1,a);
    }


    private static <T extends Comparable<? super T>> boolean less(T a, T b){
        return a.compareTo(b)<0;
    }




}
