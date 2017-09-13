package alg;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Einar Snorrason on 28/08/2017.
 */
public class Parentheses {

    private static char[] open = {'(','[','{'};
    private static char[] close = {')',']','}'};


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(isBalanced(input));
    }

    private static boolean isBalanced(String input){
        Stack paren = new Stack();
        int pos = 0;
        for (int i = 0; i<input.length(); i++){
            pos = get(input.charAt(i));
            if (pos != -1){
                if (!paren.pop().equals(open[pos])){
                    return false;
                }
            } else {
                paren.push(input.charAt(i));
            }
        }
        return true;
    }

    private static int get(char c){
        for (int j=0; j<open.length; j++){
            if (close[j] == c){
                return j;
            }
        }
        return -1;
    }
}
