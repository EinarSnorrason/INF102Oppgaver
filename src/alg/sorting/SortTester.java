package alg.sorting;

import java.util.Random;

/**
 *Class to test sorting algorithms
 */
public class SortTester {
    private static Random random=new Random();
    public static void main(String[] args){
        int size = 1000000;
        Integer[] list = new Integer[size];
        scramble(list);

        long start;
        double time;
        /*
        //Insertion sort
        long start = System.nanoTime();
        InsertionSort.sort(list);
        double time = (System.nanoTime()-start)/1000000.0;
        System.out.println(isSorted(list));
        System.out.println("Time taken: "+time);



        //ShellSort
        scramble(list);
        start = System.nanoTime();
        ShellSort.sort(list);
        time = (System.nanoTime()-start)/1000000.0;
        System.out.println("ShellSort with "+size+" values:");
        System.out.println("Time taken: "+time+" ms");


        //Mergesort
        scramble(list);
        start = System.nanoTime();
        MergeSort.sort(list);
        time = (System.nanoTime()-start)/1000000.0;
        System.out.println(isSorted(list));
        System.out.println("MergeSort with "+size+" values:");
        System.out.println("Time taken: "+time+" ms");


        //Quicksort
        scramble(list);
        start = System.nanoTime();
        QuickSort.sort(list);
        time = (System.nanoTime()-start)/1000000.0;
        System.out.println(isSorted(list));
        System.out.println("QuickSort with "+size+" values:");
        System.out.println("Time taken: "+time+" ms");

        //Heapsort
        scramble(list);
        start = System.nanoTime();
        HeapSort.sort(list);
        time = (System.nanoTime()-start)/1000000.0;
        System.out.println(isSorted(list));
        System.out.println("HeapSort with "+size+" values:");
        System.out.println("Time taken: "+time+" ms");

        */

        Integer[] intList = new Integer[100000];
        for (int i =0;i<intList.length;i++){
            intList[i] = random.nextInt(100);
        }

        Integer[] smallIntList = {3,2,1};
        System.out.println(isSorted(intList));
        CountingSort.sort(intList);
        System.out.println(isSorted(intList));
    }

    private static <T extends Comparable<? super T>> boolean isSorted(T[] a){
        for (int i=1;i<a.length;i++){
            if(a[i].compareTo(a[i-1])<0){
                return false;
            }
        }
        return true;
    }

    private static void scramble(Comparable[] a){
        for(int i=0;i<a.length;i++){
            a[i] = random.nextInt();
        }
    }

    public static void printList(Comparable[] a){
        for (Comparable i:a){
            System.out.print(i+",");
        }
    }
}
