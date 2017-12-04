package alg.exam;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Einar Snorrason on 28/11/2017.
 */
public class Threesumtest {
    public static void main(String[] args){
        int n  = 1000;
        //Random random = new Random(100);
        int[] a = new int[2*n];
        for(int i =0;i<n*2;i++){
            a[i] = i-n;
        }

        long start = System.nanoTime();
        System.out.println(threeSumLong(a));
        System.out.println(System.nanoTime()-start);
        start = System.nanoTime();
        System.out.println(threeSumShort(a));
        System.out.println(System.nanoTime()-start);
        //System.out.println(threeSumShorter(a));
    }

    public static int threeSumLong(int[] a){
        int count = 0;
        for (int i=0;i<a.length-2;i++){
            for (int j=i+1;j<a.length-1;j++){
                for (int k=j+1;k<a.length;k++){
                    if (a[i]+a[j]+a[k]==0) count++;
                }
            }
        }
        return count;
    }

    public static int threeSumShort(int[] a){
        int count = 0;
        Arrays.sort(a);
        for (int i=0;i<a.length-2;i++){
            for (int j=i+1;j<a.length-1;j++){
                int maybe = Arrays.binarySearch(a,j+1,a.length,-(a[i]+a[j]));
                if (maybe>-1){
                    count ++;
                }
            }
        }
        return count;
    }

    static int threeSumShorter(int[] a){
        Arrays.sort(a);
        int count =0;
        for (int i=0;i<a.length-3;i++){
            int start = i+1;
            int end  = a.length-1;
            int A = a[i];
            while (start<end){
                int B = a[start];
                int C = a[end];
                if (A+B+C==0){
                    count++;
                    if (B==a[start+1]){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
                else if (A+B+C<0){
                    end--;
                }
                else start++;
            }
        }
        return count;
    }

    public static int binarySearch(int[] a,int from,int to,int key){
        while (from <= to){
            int mid = (to + from)/ 2;
            if (a[from] == key) return from;
            if (a[mid]==key) return mid;
            else if (a[mid]< key) from = mid+1;
            else to = mid-1;
        }
        return from;
    }
}
