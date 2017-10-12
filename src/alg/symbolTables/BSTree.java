package alg.symbolTables;

import java.util.Iterator;
import java.util.Stack;

/**
 * Implementation of Binary Search Tree
 */
public class BSTree <Key extends Comparable<? super Key>,Value>implements ISymbolTable<Key,Value>{

    private Node root;

    @Override
    public Iterator<Key> iterator() {
        return new Itr();
    }

    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;
        public Node(Key key,Value val, int N){
            this.key = key; this.val = val; this.N = N;
        }
    }
    @Override
    public int size() {
        return size(root);
    }
    private int size(Node x){
        if (x==null) return 0;
        return x.N;
    }

    @Override
    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node x, Key key){
        if (x==null) return null;

        if (key.equals(x.key)) return x.val;
        int comp = key.compareTo(x.key);
        if (comp<0) return get(x.left,key);
        return get(x.right,key);
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root,key,val);
    }

    private Node put(Node x, Key key, Value val){
        if (x==null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if (cmp <0) x.left = put(x.left,key,val);
        else if (cmp >0) x.right = put(x.right,key,val);
        else x.val = val;
        x.N= size(x.left)+size(x.right)+1;
        return x;
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
