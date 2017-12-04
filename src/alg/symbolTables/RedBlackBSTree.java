package alg.symbolTables;

import java.util.Iterator;
import java.util.Stack;

/**
 * Implementation of Red Black BSTree
 */
public class RedBlackBSTree<Key extends Comparable<?super Key>,Value> implements Iterable<Key>{

    private Node root;
    private int compares=0;
    private enum Colour{
        RED,BLACK;
    }
    private class Node{
        Key key;
        Value val;
        Node left, right;
        int N;
        Colour colour;

        Node(Key key,Value val, int N, Colour colour){
            this.key = key;
            this.val = val;
            this.N = N;
            this.colour = colour;
        }


    }

    private boolean isRed(Node x){
        if (x==null) return false;
        return x.colour==Colour.RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.colour = h.colour;
        h.colour = Colour.RED;
        x.N = h.N;
        h.N = size(h.left)+size(h.right)+1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.colour = h.colour;
        h.colour = Colour.RED;
        x.N = h.N;
        h.N = size(h.left)+size(h.right)+1;
        return x;
    }

    private void flipColours(Node h){
        h.colour = Colour.RED;
        h.left.colour = Colour.BLACK;
        h.right.colour = Colour.BLACK;
    }

    public int numberOfCompares(){
        return compares;
    }

    public int size() {return size(root);}

    private int size(Node x){
        if (x==null) return 0;
        return x.N;
    }


    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node x, Key key){
        if (x==null) return null;

        if (key.equals(x.key)) return x.val;
        int comp = key.compareTo(x.key);
        compares++;
        if (comp<0) return get(x.left,key);
        return get(x.right,key);
    }


    public void put(Key key, Value value) {
        root = put(root,key,value);
    }

    private Node put(Node h, Key key, Value val){
        if (h==null) return new Node(key,val,1,Colour.RED);
        int cmp = key.compareTo(h.key);
        compares++;
        if (cmp < 0) h.left = put(h.left,key,val);
        else if (cmp >0) h.right = put(h.right,key,val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColours(h);

        h.N = size(h.left)+size(h.right)+1;
        return h;
    }

    @Override
    public Iterator<Key> iterator() {
        return new Itr();
    }


    /**
     * Iterator over the binary tree using stack
     * Goes from smallest to largest key
     */
    private class Itr implements Iterator<Key>{
        /**
         * Stack that stores the nodes being iterated
         */
        private Stack<Node> nodeStack;
        private Node x;

        /**
         * Construct new iterator. Starts by adding all left nodes to the stack
         * until it reaches the leftmost node
         */
        private Itr(){
            nodeStack = new Stack<>();
            if (root!=null) getLeftMost(root);
        }

        @Override
        public boolean hasNext() {
            return (!nodeStack.isEmpty());
        }

        @Override
        public Key next() {
            if (nodeStack.isEmpty()) return null;
            x = nodeStack.peek();
            Key answer = x.key;
            // If subtree exists to the right, next becomes leftmost node in subtree
            if (x.right != null) {
                getLeftMost(x.right);
            }
            else{
                // Go up until we find node we have not returned yet
                x = nodeStack.pop();
                while (!nodeStack.isEmpty() && x.equals(nodeStack.peek().right)){
                    x= nodeStack.pop();
                }
            }
            return answer;

        }

        /**
         * Find leftmost node under given node
         */
        private void getLeftMost(Node n){
            nodeStack.push(n);
            while (n.left!=null){
                nodeStack.push(n.left);
                n = n.left;
            }
        }
    }
}
