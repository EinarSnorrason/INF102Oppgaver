package alg.symbolTables;

import java.util.Iterator;
import java.util.Stack;

/**
 * Implementation of Binary Search Tree
 */
public class BSTree <Key extends Comparable<? super Key>,Value>implements ISymbolTable<Key,Value>{

    private Node root;
    private int compares=0;

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
        Node(Key key,Value val, int N){
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

    public int numberOfCompares(){
        return compares;
    }

    @Override
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

    @Override
    public void put(Key key, Value val) {
        root = put(root,key,val);
    }

    private Node put(Node x, Key key, Value val){
        if (x==null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        compares++;
        if (cmp <0) x.left = put(x.left,key,val);
        else if (cmp >0) x.right = put(x.right,key,val);
        else x.val = val;
        x.N= size(x.left)+size(x.right)+1;
        return x;
    }

    public Node min(){
        return min(root);
    }

    private Node min(Node n){
        if (n.left != null) return min(n.left);
        return n;
    }

    public Node max(){
        Node max = root;
        while(max.right != null) max = max.right;
        return max;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    /**
     * Deletes smallest key in tree
     * @param n
     * @return
     */
    private Node deleteMin(Node n){
        if (n.left == null) return n.right;
        n.left = deleteMin(n.left);
        n.N = size(n.left)+size(n.right)+1;
        return n;
    }

    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node n, Key key){
        if (n==null) return null;
        int cmp = key.compareTo(n.key);
        compares++;
        if (cmp <0) n.left = delete(n.left,key);
        else if (cmp > 0) n.right = delete(n.right,key);
        else{
            if (n.left == null) return n.right;
            if (n.right == null) return n.left;
            Node t = n;
            n = min(t.right);
            n.right = deleteMin(t.right);
            n.left = t.left;
        }
        n.N = size(n.left)+size(n.right)+1;
        return n;

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
