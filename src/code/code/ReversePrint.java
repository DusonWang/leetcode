package code.code;

import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePrint {
    public class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addFirst(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] values = new int[size];
        int i = 0;
        for (int v : list) {
            values[i++] = v;
        }
        return values;
    }
}
