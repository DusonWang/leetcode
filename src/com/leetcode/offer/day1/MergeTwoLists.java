package com.leetcode.offer.day1;

/**
 * @author duson
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeNode;
        if (l1.val < l2.val) {
            mergeNode = l1;
            mergeNode.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeNode = l2;
            mergeNode.next = mergeTwoLists(l1, l2.next);
        }
        return mergeNode;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(-1);

        ListNode mergeNode = pHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pHead.next = l1;
                l1 = l1.next;
            } else {
                pHead.next = l2;
                l2 = l2.next;
            }
            pHead = pHead.next;
        }
        pHead.next = l1 == null ? l2 : l1;
        return mergeNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(listNode1, listNode2);

        int i = 0;
        while (listNode != null) {
            System.out.println((i++) + "<>" + listNode.val);
            listNode = listNode.next;
        }
    }
}
