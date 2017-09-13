package alg;

import java.util.ArrayList;

/**
 * Prints two sorted lists in correct order
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
