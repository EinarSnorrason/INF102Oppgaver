package alg;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Counts number of quadruplets that sum to 0 in given list of integers
 */
public class FourSum {

    private FourSum(){};

    public static int count(int[] list){
        Arrays.sort(list);
        int count = 0;
        for (int i=0;i<list.length;i++){
            for (int j=i+1;j<list.length;j++){
                for (int k=j+1;k<list.length;k++){
                    int n = Arrays.binarySearch(list,-(list[i]+list[j]+list[k]));
                    if (n>k){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        Random random = new Random();
        int[] list;
        In in = new In("1Kints.txt");
        int[] a = in.readAllInts();

        System.out.println(count(a));

    }
}
