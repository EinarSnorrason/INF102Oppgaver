package alg.symbolTables;

import alg.In;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Counts occurences of words in given text above given character limit and
 * prints the one that occurs most frequently
 */
public class FrequencyCounter {
    public static void main(String args[]){

        int minLen = Integer.parseInt(args[0]);
        String name = args[1];
        In in = new In(name);
        RedBlackBSTree<String,Integer> st = new RedBlackBSTree<>();
        String word;
        while(in.hasNextLine()){
            try{
                word = in.readString();
            } catch(NoSuchElementException b){
                continue;
            }
            if (word.length()<minLen) continue;
            Integer wordCount = st.get(word);
            if (wordCount==null) st.put(word,1);
            else st.put(word,wordCount+1);
        }
        // Return word with most uses:
        int maxInt = 0;
        String maxStr = "";
        for (String s:st){
            int count = st.get(s);
            System.out.println(s);
            if (maxInt<count){
                maxInt = count;
                maxStr = s;
            }
        }
        System.out.println(maxInt+" "+maxStr);
        System.out.println(st.numberOfCompares());
    }
}
