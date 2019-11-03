package com.leetcode.offer.code;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author duson
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode listNode = mergeTwoLists2(lists[0], lists[1]);
        if (lists.length > 2) {
            for (int i = 2; i < lists.length; i++) {
                listNode = mergeTwoLists2(listNode, lists[i]);
            }
        }
        return listNode;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        ListNode newListNode = new ListNode(-1);
        ListNode retNewListNode = newListNode;
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.offer(listNode.val);
                listNode = listNode.next;
            }
        }
        while (!queue.isEmpty()) {
            newListNode.next = new ListNode(queue.poll());
            newListNode = newListNode.next;
        }

        return retNewListNode.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) >> 1;
        ListNode lNode = merge(arr, left, mid);
        ListNode rNode = merge(arr, mid + 1, right);

        return mergeTwoLists2(lNode, rNode);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(9);
        queue.offer(5);
        queue.offer(6);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
