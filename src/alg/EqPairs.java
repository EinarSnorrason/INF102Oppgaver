package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Counts number of pairs in array that are equal
 */
public class EqPairs {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        while (in.hasNextInt()){
            list.add(in.nextInt());
        }
        Integer a = null;
        Integer e = 0;
        Integer pairs = 0;
        Collections.sort(list);

        for (Integer i:list){
            if (i == a){
                pairs += ++e;
            } else {
                e = 0;
            }
            a = i;
        }
        System.out.println(list);
        System.out.println(pairs);
    }
}
