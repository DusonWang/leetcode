package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author duson
 * 不使用任何库函数，设计一个跳表。
 * <p>
 * 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 * <p>
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作：
 * <p>
 * <p>
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 * <p>
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 * <p>
 * 在本题中，你的设计应该要包含这些函数：
 * <p>
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 了解更多 : https://en.wikipedia.org/wiki/Skip_list
 * <p>
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 * <p>
 * 样例:
 * <p>
 * Skiplist skiplist = new Skiplist();
 * <p>
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 * 约束条件:
 * <p>
 * 0 <= num, target <= 20000
 * 最多调用 50000 次 search, add, 以及 erase操作。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-skiplist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Skiplist {

//    private ArrayList<Integer> array;
//
//    public Skiplist() {
//        array = new ArrayList<>();
//    }
//
//    public boolean search(int target) {
//        return array.contains(target);
//    }
//
//    public void add(int num) {
//        array.add(num);
//    }
//
//    public boolean erase(int num) {
//        int p = -1;
//        for (int i = 0; i < array.size(); i++) {
//            if (array.get(i) == num) {
//                p = i;
//            }
//        }
//        if (p != -1) {
//            array.remove(p);
//            return true;
//        }
//        return false;
//    }

    private static final double DEFAULT_PROB = 0.5;
    private final Random rand = new Random();
    private final List<Node> sentinels = new ArrayList<>();

    {
        sentinels.add(new Node(Integer.MIN_VALUE));
    }

    public boolean search(int target) {
        Node smallerOrEquals = getSmallerOrEquals(target);
        return smallerOrEquals.val == target;
    }

    public void add(int num) {
        Node cur = getSmallerOrEquals(num);
        // cur 最下层，比他小或者等于 num
        final Node toInsert = new Node(num);
        append(cur, toInsert);
        // populate the level
        populateLevelUp(toInsert);
    }

    private void populateLevelUp(final Node toInsert) {
        Node curPrev = toInsert.left, cur = toInsert;

        while (flipCoin()) {
            while (curPrev.left != null && curPrev.up == null) {
                curPrev = curPrev.left;
            }
            if (curPrev.up == null) {
                final Node newSentinel = new Node(Integer.MIN_VALUE);
                curPrev.up = newSentinel;
                newSentinel.down = curPrev;
                sentinels.add(curPrev.up);
            }
            curPrev = curPrev.up;
            final Node newNode = new Node(toInsert.val);
            cur.up = newNode;
            newNode.down = cur;
            cur = cur.up;
            curPrev.right = cur;
            cur.left = curPrev;
        }
    }

    private void append(Node prev, Node cur) {
        final Node next = prev.right;
        prev.right = cur;
        cur.left = prev;
        if (next != null) {
            next.left = cur;
            cur.right = next;
        }
    }

    public boolean erase(int num) {
        final Node toRemove = getSmallerOrEquals(num);
        if (toRemove.val != num) {
            return false;
        }
        Node cur = toRemove;
        while (cur != null) {
            final Node prev = cur.left, next = cur.right;
            prev.right = next;
            if (next != null) {
                next.left = prev;
            }
            cur = cur.up;
        }
        return true;
    }

    private Node getSmallerOrEquals(final int target) {
        Node cur = getSentinel();
        while (cur != null) {
            if (cur.right == null || cur.right.val > target) {
                if (cur.down == null) {
                    break;
                }
                cur = cur.down;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }

    private boolean flipCoin() {
        return rand.nextDouble() < DEFAULT_PROB;
    }

    private Node getSentinel() {
        return sentinels.get(sentinels.size() - 1);
    }

    @Override
    public String toString() {
        Node node = sentinels.get(0);
        final StringBuilder sb = new StringBuilder();
        while (node != null) {
            Node itr = node;
            while (itr != null) {
                sb.append(itr.val).append(",");
                itr = itr.up;
            }
            sb.append("\n");
            node = node.right;
        }
        return sb.toString();
    }

    private static final class Node {
        private final int val;
        private Node left, right, up, down;

        private Node(int val) {
            this.val = val;
        }
    }
}
