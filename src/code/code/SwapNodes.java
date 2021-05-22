package code.code;

/**
 * ���������ͷ�ڵ� head ��һ������ k ��
 * <p>
 * ���� ���������� k ���ڵ�͵����� k ���ڵ��ֵ�󣬷��������ͷ�ڵ㣨���� �� 1 ��ʼ��������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺head = [1,2,3,4,5], k = 2
 * �����[1,4,3,2,5]
 * ʾ�� 2��
 * <p>
 * ���룺head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * �����[7,9,6,6,8,7,3,0,9,5]
 * ʾ�� 3��
 * <p>
 * ���룺head = [1], k = 1
 * �����[1]
 * ʾ�� 4��
 * <p>
 * ���룺head = [1,2], k = 1
 * �����[2,1]
 * ʾ�� 5��
 * <p>
 * ���룺head = [1,2,3], k = 2
 * �����[1,2,3]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * �����нڵ����Ŀ�� n
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 * ͨ������8,224�ύ����12,614
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
