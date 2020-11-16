package code.code;

/**
 * @author duson
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {

    public class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow, cur = slow.next;
        if (cur != null) {
            ListNode tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = mid.next;
            mid.next = cur;
            cur = tmp;
        }

        ListNode left = head, right = mid.next;
        while (right != null) {
            mid.next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = mid.next;
        }
    }
}
