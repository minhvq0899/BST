
import java.util.LinkedList;

public class BST<Key extends Comparable, Value> {
    private class Node {
        Value val;
        Key key;
        Node left, right;

        public Node(Key k, Value v) {
            val = v;
            key = k;
        }

    }

    private Node root; // only instance variable of BST


    public BST() {
        root = null;
    }

    public void put(Key k, Value v) {
        root = put(k, v, root);    // helper method


    }

    public Value get(Key k) {
        return get(k, root);

    }


    public boolean isEmpty() {
        return root == null;
    }


    public boolean contains(Key k) {
        return contains(k, root);
    }

    public Iterable<Key> keys() {
        LinkedList<Key> l = new LinkedList<>();
        traverse(root, l);
        return l;

    }

    //helper methods:

    private Node put(Key k, Value v, Node root) {
        if (root == null) {

            root = new Node(k, v);
            return root;
        }

        if (root.key.compareTo(k) == 0) {
            Node tmp = new Node(k, v);
            tmp.right = root.right;
            tmp.left = root.left;

            return tmp;
        }

        if (root.key.compareTo(k) > 0) {
            root.left = put(k, v, root.left);
            return root;
        }
        else {
            root.right = put(k, v, root.right);
            return root;

        }
    }


    private Value get(Key k, Node root) {
        if (root == null) {

            return null;
        }

        if (root.key.compareTo(k) == 0) {

            return root.val;
        }

        if (root.key.compareTo(k) > 0) {
            return get(k, root.left);

        }
        else {
            return get(k, root.right);


        }
    }

    private boolean contains(Key k, Node root) {
        if (root == null) {

            return false;
        }

        if (root.key.compareTo(k) == 0) {

            return true;
        }

        if (root.key.compareTo(k) > 0) {
            return contains(k, root.left);

        }
        else {
            return contains(k, root.right);


        }
    }


    private void traverse(Node root, LinkedList<Key> l) {
        if (root == null)
            return;
        traverse(root.left, l);
        l.add(root.key);
        traverse(root.right, l);
        return;
    }


    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        BST<Integer, String> bst = new BST<>();
        bst.put(1, "1");
        bst.put(2, "2");
        bst.put(-12, "-12");
        bst.put(-2, "-2");

        bst.traverse(bst.root, l);
        StdOut.println(l);
    }
}
