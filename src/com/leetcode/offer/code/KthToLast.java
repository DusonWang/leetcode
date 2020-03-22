package com.leetcode.offer.code;

/**
 * @author duson
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 * <p>
 * 通过次数4,338提交次数5,453
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthToLast {

    public class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode listNode, int k) {
        if (listNode == null || k <= 0) {
            return -1;
        }

        ListNode ahead = listNode;
        ListNode behind;
        for (int i = 0; i < k - 1; i++) {
            ahead = ahead.next;
        }

        behind = listNode;
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind.val;
    }
}
