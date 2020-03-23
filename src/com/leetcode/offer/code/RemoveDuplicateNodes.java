package com.leetcode.offer.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author duson
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 * <p>
 * 通过次数3,331提交次数4,999
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateNodes {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        Set<Integer> s = new HashSet<>();
        while (current != null) {
            if (!s.contains(current.val)) {
                s.add(current.val);
                prev = current;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return head;
    }
}
