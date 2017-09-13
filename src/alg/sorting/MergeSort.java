package alg.sorting;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Einar Snorrason on 06/09/2017.
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

    public static void sortBottom(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int i=1;i<N; i*=2){
            for (int j=0; i*(j+1)<N; j+=2){
                for(int n=0;n<N;n++){
                    aux[n]=a[n];
                }
                merge(a,aux,i*j,i*(j+1),Math.min(N-1,i*(j+2)-1));
            }
        }
    }

    private static void sort1(Comparable[] a, int lo, int hi){
        if (hi-lo <15){
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
