package alg.sorting;

/**
 * Runtime: (N^2-N)/2
 */
public class BubbleSort {
    public static void sort(Comparable[] a){
        boolean sorted = false;
        for (int i=a.length-1;i>0;i--){
            for (int j=1;j<=i;j++){
                if (a[j].compareTo(a[j-1])<0){
                    swap(a,j-1,j);
                }
            }
        }
    }

    public static void swap(Comparable[] a, int  i, int j){
        Comparable t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    public static void main(String[] args){
        Integer[] a = {5,4,2,1,7,0,-4,123,6,5,5};
        sort(a);
        for (Integer i:a){
            System.out.print(i+" ");
        }
    }
}
