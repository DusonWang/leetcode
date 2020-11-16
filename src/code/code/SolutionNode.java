package code.code;

import java.util.Random;

/**
 * @author duson
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 * <p>
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 * <p>
 * 示例:
 * <p>
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-random-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionNode {

    public class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    private ListNode head;
    private Random randomGenerator;

    public SolutionNode(ListNode head) {
        this.head = head;
        this.randomGenerator = new Random();

    }

    public int getRandom() {
        ListNode result = null;
        ListNode current = head;
        for (int n = 1; current != null; n++) {
            if (randomGenerator.nextInt(n) == 0) {
                result = current;
            }
            current = current.next;
        }
        return result != null ? result.val : -1;
    }

}
