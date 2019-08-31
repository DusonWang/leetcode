package com.leetcode.offer.day1;

/**
 * @author duson
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode ahead = head;
        ListNode behind;
        int size = 0;
        for (int i = 0; i < n - 1; i++) {
            ahead = ahead.next;
            size++;
        }

        if (ahead == null) {
            return head;
        }

        behind = head;
        ListNode preBehind = head;
        while (ahead.next != null) {
            ahead = ahead.next;
            preBehind = behind;
            size++;
            behind = behind.next;
        }
        if (preBehind != head && preBehind.next != null) {
            preBehind.next = preBehind.next.next;
        } else {
            if (preBehind == head) {
                if (size == n - 1) {
                    if (head.next != null) {
                        head = head.next;
                    } else {
                        head = null;
                    }
                } else {
                    if (head.next != null) {
                        head.next = head.next.next;
                    }
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode newListNode = removeNthFromEnd(listNode, 5);
        int i = 0;
        while (newListNode != null) {
            System.out.println((i++) + "<>" + newListNode.val);
            newListNode = newListNode.next;
        }
    }
}
