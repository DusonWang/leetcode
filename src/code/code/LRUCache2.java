package code.code;

import java.util.HashMap;

public class LRUCache2 {

    private static class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node dummyHead = new Node();
    private final Node dummyTail = new Node();
    private final int capacity;
    private int size;
    private final HashMap<Integer, Node> hashMap = new HashMap<>();

    private void add(Node node) {
        Node originHead = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = originHead;
        originHead.pre = node;
    }

    private void del(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }

    public LRUCache2(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (null == node) {
            return -1;
        }
        del(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (null != node) {
            node.value = value;
            del(node);
            add(node);
        } else {
            if (size < capacity) {
                size++;
            } else {
                Node delNode = dummyTail.pre;
                hashMap.remove(delNode.key);
                del(delNode);
            }
            Node newNode = new Node(key, value);
            add(newNode);
            hashMap.put(key, newNode);
        }
    }
}
