package com.leetcode.offer.code;

/**
 * @author duson
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 *  
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);
        return reverse(add(reverseL1, reverseL2));
    }

    private ListNode add(ListNode l1, ListNode l2) {
        ListNode finalNode = new ListNode(0);
        ListNode retFinalNode = finalNode;
        int up = 0;
        while (l1 != null || l2 != null) {
            int x1 = l1 == null ? 0 : l1.val;
            int x2 = l2 == null ? 0 : l2.val;
            int sum = x1 + x2 + up;

            up = sum / 10;
            sum = sum % 10;

            finalNode.next = new ListNode(sum);
            finalNode = finalNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (up == 1) {
            finalNode.next = new ListNode(1);
        }

        return retFinalNode.next;
    }

    private ListNode reverse(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode reverseHead = null;
        ListNode preNode = null;
        ListNode pNode = listNode;
        while (pNode != null) {
            ListNode pNextNode = pNode.next;
            if (pNextNode == null) {
                reverseHead = pNode;
            }
            pNode.next = preNode;
            preNode = pNode;
            pNode = pNextNode;
        }
        return reverseHead;
    }
}
