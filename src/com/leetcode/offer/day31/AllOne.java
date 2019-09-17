package com.leetcode.offer.day31;

import java.util.HashMap;

/**
 * @author duson
 * 实现一个数据结构支持以下操作：
 * <p>
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-oone-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllOne {

    static class Node {
        Node pre;
        Node next;
        int val;
        String s;

        Node(int x, String s) {
            val = x;
            this.s = s;
        }
    }

    private HashMap<String, Node> map;
    private Node head;
    private Node tail;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<String, Node>();
        head = new Node(Integer.MAX_VALUE, "");
        tail = new Node(Integer.MIN_VALUE, "");
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node t = map.get(key);
            t.val++;
            Node p = t.pre;
            while (p.val < t.val) {
                p = p.pre;
            }
            t.pre.next = t.next;
            t.next.pre = t.pre;

            p.next.pre = t;
            t.next = p.next;
            p.next = t;
            t.pre = p;

        } else {
            Node t = new Node(1, key);
            Node p = tail.pre;
            tail.pre = t;
            t.next = tail;
            t.pre = p;
            p.next = t;
            map.put(key, t);
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node t = map.get(key);
            t.val--;
            if (t.val == 0) {
                t.pre.next = t.next;
                t.next.pre = t.pre;
                map.remove(key);
            } else {
                Node p = t.next;
                while (p.val > t.val) {
                    p = p.next;
                }
                t.pre.next = t.next;
                t.next.pre = t.pre;

                p.pre.next = t;
                t.pre = p.pre;

                p.pre = t;
                t.next = p;
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.s;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return tail.pre.s;
    }

}
