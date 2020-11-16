package code.code;

/**
 * @author duson
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�����������������򷵻�?true�����򷵻�?false���������������������������ֶ�������ͬ��
 * <p>
 * ?
 * <p>
 * �ο�������Ŷ�����������
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * ʾ�� 1��
 * <p>
 * ����: [1,6,3,2,5]
 * ���: false
 * ʾ�� 2��
 * <p>
 * ����: [1,3,2,6,5]
 * ���: true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ���鳤�� <= 1000
 * ͨ������12,008�ύ����23,737
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] nodes, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = nodes[right];
        int index = left;
        while (nodes[index] < root) {
            ++index;
        }
        for (int i = index; i < right; ++i) {
            if (nodes[i] < root) {
                return false;
            }
        }
        return helper(nodes, left, index - 1)
                && helper(nodes, index, right - 1);
    }
}
