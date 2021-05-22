package code.code;

/**
 * 给你链表的头节点 head 和一个整数 k 。
 * <p>
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * 示例 3：
 * <p>
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 * ?
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 * 通过次数8,224提交次数12,614
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapNodes {

    public class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode right = head;
        ListNode left = head;
        ListNode a;
        ListNode b;
        for (int i = 0; i < k - 1; i++) {
            right = right.next;
        }
        a = right;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        b = left;
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
        return head;
    }
}
