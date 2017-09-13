package alg.sorting;


/**
 * MergeSort implementation
 *
 * Implements two of the three improvements suggested in Ex 2.2.11:
 * Insertionsort for smaller arrays and switching arguments in recursive code
 */
public class MergeSort {
    private static Comparable[] aux;

    private static void merge(Comparable[] a , Comparable[] aux, int lo, int mid, int hi){
        int i=lo; int j=mid+1;

        for (int k=lo; k<=hi; k++){
            if (i>mid)a[k] = aux[j++];
            else if(j>hi) a[k] = aux[i++];
            else if (less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        for (int i=0;i<a.length;i++){
            aux[i] = a[i];
        }
        sort1(a,0,a.length-1);
    }


    // Two different sorts to create "recursive trickery"
    private static void sort1(Comparable[] a, int lo, int hi){
        if (hi-lo <15){
            // Use insertionsort for small arrays
            InsertionSort.sort(a,lo,hi);
            return;
        }
        int mid = lo+(hi-lo)/2;
        sort2(a,lo,mid);
        sort2(a,mid+1,hi);

        merge(a,aux,lo,mid,hi);

    }
    private static void sort2(Comparable[] a, int lo, int hi){
        if (hi-lo <15){
            InsertionSort.sort(aux,lo,hi);
            return;
        }

        int mid = lo+(hi-lo)/2;
        sort1(a,lo,mid);
        sort1(a,mid+1,hi);

        merge(aux,a,lo,mid,hi);
    }



    public static void printList(Comparable[] a){
        System.out.print("[");
        for (Comparable i:a){
            System.out.print(i+" ");
        }
        System.out.println("]");
    }


    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    /*public static void main(String[] args){
        Comparable[] a = {9,8,7,6,5,4,3,2,1,0};
        sort(a);
    }*/
}
