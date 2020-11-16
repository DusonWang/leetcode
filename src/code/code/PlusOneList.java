package code.code;

/**
 * @author duson
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 * <p>
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 * <p>
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOneList {

    public class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode plusOne(ListNode head) {
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        while (fast != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }

        slow.val += 1;
        ListNode cur = slow.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        return slow.next == head ? slow : head;
    }
}
