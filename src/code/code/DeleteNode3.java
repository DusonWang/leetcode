package code.code;

/**
 * @author duson
 * �������������ͷָ���һ��Ҫɾ���Ľڵ��ֵ������һ������ɾ���ýڵ㡣
 * <p>
 * ����ɾ����������ͷ�ڵ㡣
 * <p>
 * ע�⣺����Ա�ԭ���иĶ�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: head = [4,5,1,9], val = 5
 * ���: [4,1,9]
 * ����: ������������ֵΪ?5?�ĵڶ����ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 1 -> 9.
 * ʾ�� 2:
 * <p>
 * ����: head = [4,5,1,9], val = 1
 * ���: [4,5,9]
 * ����: ������������ֵΪ?1?�ĵ������ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 5 -> 9.
 * ?
 * <p>
 * ˵����
 * <p>
 * ��Ŀ��֤�����нڵ��ֵ������ͬ
 * ��ʹ�� C �� C++ ���ԣ��㲻��Ҫ free �� delete ��ɾ���Ľڵ�
 * ͨ������21,857�ύ����36,981
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class DeleteNode3 {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        if (node.val == val) {
            return head.next;
        }
        while (node.next.val != val) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}
