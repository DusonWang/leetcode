package code.code;

/**
 * @author duson
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindromeList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        fast = fast == null ? slow : slow.next;
        slow = pre;
        for (; slow != null && fast != null; slow = slow.next, fast = fast.next) {
            if (slow.val != fast.val) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head.next, pre = null, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;

            pre.next = prepre;
            prepre = pre;
        }

        ListNode p2 = slow.next;
        slow.next = pre;
        ListNode p1 = fast == null ? slow.next : slow;
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
