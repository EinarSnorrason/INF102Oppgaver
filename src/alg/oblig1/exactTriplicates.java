package alg.oblig1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Einar Snorrason on 19/09/2017.
 */
public class exactTriplicates {
    public static void main(String[] args){

        PriorityQueue<String> triplicateWords = new PriorityQueue<>();

        String[][] listOfLists = {{"a","b","c"},{"g","c","g"},{"a","t","h"},{"b","c","d"}};
        for (int i=0;i<4;i++){
            // Sort the lists
            Arrays.sort(listOfLists[i]);
        }

        String word = "";

        for (int i=0;i<2;i++){
            for (int j=0;j<listOfLists[0].length;j++) {
                if (word.equals(listOfLists[i][j])) continue;
                word = listOfLists[i][j];
                if (search(listOfLists, word, i + 1) == 3) {
                    triplicateWords.add(word);
                }
            }
        }
        System.out.println(triplicateWords.peek());
    }

    private static int search(String[][] lists, String word, int startingList){
        int hits = 1;
        for (int i=0;i<4;i++){
            if (i==startingList) continue;
            if (contains(lists[i],word)) hits++;
        }
        return hits;
    }

    /**
     * Uses binary search to check if list contains given string
     * @param list list to search
     * @param key string to find
     * @return true if string is in list, false else
     */
    private static boolean contains(String[] list, String key) {
        int lo = 0;
        int hi = list.length - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            int cmp = key.compareTo(list[mid]);
            if (cmp == 0) return true;
            else if (cmp < 0) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
