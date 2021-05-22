package code.code;

/**
 * ������������?list1 ��?list2?�����ǰ�����Ԫ�طֱ�Ϊ?n ����?m ����
 * <p>
 * ���㽫?list1?�е�?a?���ڵ㵽��?b?���ڵ�ɾ��������list2?���ڱ�ɾ���ڵ��λ�á�
 * <p>
 * ��ͼ����ɫ�ߺͽڵ�չʾ�˲�����Ľ����
 * <p>
 * <p>
 * ���㷵�ؽ�������ͷָ�롣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * �����[0,1,2,1000000,1000001,1000002,5]
 * ���ͣ�����ɾ�� list1 �е����͵��ĸ��ڵ㣬���� list2 ���ڸ�λ�á���ͼ����ɫ�ıߺͽڵ�Ϊ������
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * �����[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * ���ͣ���ͼ����ɫ�ıߺͽڵ�Ϊ������
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 * ͨ������9,245�ύ����12,063
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-in-between-linked-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MergeInBetween {

    public class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = list1;
        for (int i = 1; i < a; i++) {
            pre = pre.next;
        }
        ListNode last = pre.next;
        for (int i = 0; i <= b - a; i++) {
            last = last.next;
        }
        pre.next = list2;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = last;
        return list1;
    }
}
