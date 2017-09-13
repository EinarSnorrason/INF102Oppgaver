package alg;

import java.util.ArrayList;

/**
 * Takes in two sorted lists and prints out all elements contained in both lists
 * Run SortedListTest to test this
 * (Runs in O(N))
 */
public class PrintLists<E extends Comparable<E>>{

    public void printSorted(ArrayList<E> a, ArrayList<E> b){
        int iA = 0;
        int iB = 0;
        while(iA<a.size()&&iB<b.size()){
            if (a.get(iA).compareTo(b.get(iB))==0){
                System.out.println(a.get(iB));
                iB++;
                iA++;
            } else if (a.get(iA).compareTo(b.get(iB))<0){
                iA++;
            } else {
                iB++;
            }
        }

    }


}
