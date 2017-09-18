package alg.oblig1;

import java.util.Stack;

/**
 * Ex 1: Takes arbitrary reverse polish expression and converts it into infix
 */
public class rpTranslator {

    /**
     * Main method. Takes in reverse polish expression as args[0] and prints out
     * infix notation
     * @param args Reverse polish expression
     */
    public static void main(String args[]){
        Stack<String> polishStack = new Stack<>();

        // Spit up list and then iterate over it
        String[] polish = args[0].split(" ");
        for (String value:polish){

            if (isOperator(value)){
                combine(polishStack,value);
            }
            else{
                polishStack.push(value);
            }
        }
        System.out.println(polishStack.pop());
    }

    /**
     * Pops two arguments from the stack, writes them in infix notation
     * with the given operation and then pushes that onto the stack
     * @param polishStack Stack of values that need to be combined
     * @param operation Operation to perform
     */
    private static void combine(Stack<String> polishStack,String operation){
        String b = polishStack.pop();
        String a = polishStack.pop();
        polishStack.push(String.format("(%s%s%s)",a,operation,b));
    }

    /**
     * Takes in a String, and returns true if it is an operator
     * @param value String to check
     * @return True if operator, false otherwise
     */
    private static boolean isOperator(String value){
        switch (value){
            case "+":
            case "*":
            case "-":
            case "/":
            case "^":
                return true;
            default:
                return false;
        }
    }
}
