import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size = 0;
    public class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return val;
        }
    }

    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }
        Node current = root;
        while (true) {
            if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
        size++;
    }
    public V get(K key) {
        Node current = root;
        while (current != null) {
            if (key.compareTo(current.key) == 0) {
                return current.val;
            } else if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
    @Override
    public Iterator<Node> iterator() {
        return new BSTIterator();
    }
    private class BSTIterator implements Iterator<Node> {
        private Queue<Node> queue = new LinkedList<>();

        public BSTIterator() {
            inorder(root);
        }
        private void inorder(Node node) {
            if (node == null) return;
            LinkedList<Node> stack = new LinkedList<>();
            Node current = node;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                queue.offer(current);
                current = current.right;
            }
        }
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        @Override
        public Node next() {
            return queue.poll();
        }
    }
}