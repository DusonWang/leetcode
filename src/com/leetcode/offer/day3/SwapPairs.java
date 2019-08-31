package com.leetcode.offer.day3;

/**
 * @author duson
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode node = p.next;
        p.next = p.next.next;
        node.next = p;
        head = node;

        while (p.next != null && p.next.next != null) {
            node = p;
            p = p.next;
            node.next = p.next;
            p.next = p.next.next;
            node.next.next = p;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        while (p.next != null && p.next.next != null) {

            ListNode s = p.next;
            ListNode e = p.next.next;

            p.next = e;
            s.next = e.next;
            e.next = s;

            p = s;

        }
        return pre.next;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode node = swapPairs.swapPairs(listNode);
        int i = 0;
        while (node != null) {
            System.out.println((i++) + "<>" + node.val);
            node = node.next;
        }
    }
}
