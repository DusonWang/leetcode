package code.code;

/**
 * @author duson
 * �������⡣�и�С��������¥�ݣ�¥����n��̨�ף�С��һ�ο�����1�ס�2�׻�3�ס�ʵ��һ�ַ���������С���ж�������¥�ݵķ�ʽ��������ܴܺ�����Ҫ�Խ��ģ1000000007��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺n = 3
 * �����4
 * ˵��: �������߷�
 * ʾ��2:
 * <p>
 * ���룺n = 5
 * �����13
 * ��ʾ:
 * <p>
 * n��Χ��[1, 1000000]֮��
 * ͨ������7,375�ύ����21,618
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/three-steps-problem-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class WaysToStep {

    public int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int d1 = 1;
        int d2 = 2;
        int d3 = 4;
        int val = 0;
        for (int i = 3; i < n; i++) {
            val = (d1 + d2) % 1000000007 + d3;
            val %= 1000000007;
            d1 = d2;
            d2 = d3;
            d3 = val;
        }
        return val;
    }
}
