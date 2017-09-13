package alg;

import java.util.ArrayList;

/**
 * Tester for PrintLists class
 */
public class SortedListTest {
    public static void main(String[] args){
        PrintLists<Integer> pairs = new PrintLists<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i=0;i<10;i++){
            a.add(i);
        }
        for (int i=0;i<20;i++){
            b.add(i);
        }
        pairs.printSorted(a,b);
    }
}
