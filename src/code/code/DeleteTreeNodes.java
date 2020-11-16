package code.code;

/**
 * ����һ���Խڵ� 0 Ϊ���ڵ�������������£�
 * <p>
 * �ڵ������Ϊ?nodes?����
 * ��?i ���ڵ��ֵΪ?value[i]?��
 * ��?i ���ڵ�ĸ��ڵ���?parent[i]?��
 * ����ɾ���ڵ�ֵ֮��Ϊ 0 ��ÿһ��������
 * <p>
 * ���������ɾ��֮�󣬷�������ʣ��ڵ����Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * <p>
 * <p>
 * ���룺nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
 * �����2
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nodes <= 10^4
 * -10^5 <= value[i] <= 10^5
 * parent.length == nodes
 * parent[0] == -1?��ʾ�ڵ� 0 �����ĸ���
 * ͨ������904�ύ����1,712
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/delete-tree-nodes
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author duson
 */
public class DeleteTreeNodes {

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        for (int i = nodes - 1; i > 0; i--) {
            value[parent[i]] += value[i];
        }
        int count = 0;
        if (value[0] != 0) {
            count++;
        }
        for (int i = 1; i < nodes; i++) {
            if (value[i] != 0) {
                if (value[parent[i]] == 0) {
                    value[i] = 0;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
