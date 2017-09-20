package alg.symbolTables;

import alg.In;

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
        ArrayListST<String,Integer> st = new ArrayListST<>();
        String word;
        while(in.hasNextLine()){
            try{
                word = in.readString();
            } catch(NoSuchElementException b){
                continue;
            }
            if (word.length()<minLen) continue;
            if (st.get(word)==null) st.put(word,1);
            else st.put(word,st.get(word)+1);
        }
        // Return word with most uses:
        int maxInt = 0;
        String maxStr = "";
        for (String s:st){
            int count = st.get(s);
            if (maxInt<count){
                maxInt = count;
                maxStr = s;
            }
        }
        System.out.println(maxInt+" "+maxStr);

    }
}
