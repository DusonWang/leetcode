package com.leetcode.offer.day4;

/**
 * @author duson
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        int cnt = 0;
        ListNode p = head;
        for (; p != null && cnt < k; p = p.next) {
            ++cnt;
        }

        if (cnt == k) {
            ListNode prev = head, cur = head.next, next;
            for (; cur != p; prev = cur, cur = next) {
                next = cur.next;
                cur.next = prev;
            }
            head.next = reverseKGroup2(p, k);
            return prev;
        }
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {

            int count = 0;
            while (tail != null && count != k) {
                count++;
                tail = tail.next;
            }

            if (tail == null) {
                break;
            }

            ListNode head1 = pre.next;

            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }

            pre = head1;
            tail = head1;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        //1->2->3->4->5
        // 当 k = 2 时，应当返回: 2->1->4->3->5
        //当 k = 3 时，应当返回: 3->2->1->4->5

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        int[] kArray = new int[]{3};
        for (int k : kArray) {
            ListNode listNode = reverseKGroup.initListNode();
            listNode = reverseKGroup.reverseKGroup2(listNode, k);
            System.out.println();
            while (listNode != null) {
                System.out.print(listNode.val + "->");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }

    private ListNode initListNode() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNodeTmp = listNode;
        while (listNodeTmp != null) {
            System.out.print(listNodeTmp.val + "->");
            listNodeTmp = listNodeTmp.next;
        }
        System.out.println();
        return listNode;
    }
}
