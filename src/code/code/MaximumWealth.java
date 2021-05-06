package code.code;

/**
 * ����һ�� m x n ���������� accounts ������ accounts[i][j] �ǵ� i???????????? λ�ͻ��ڵ� j �������йܵ��ʲ�������������пͻ���ӵ�е� �ʲ����� ��
 * <p>
 * �ͻ��� �ʲ����� ���������ڸ��������йܵ��ʲ�����֮�͡���пͻ����� �ʲ����� ���Ŀͻ���
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺accounts = [[1,2,3],[3,2,1]]
 * �����6
 * ���ͣ�
 * �� 1 λ�ͻ����ʲ����� = 1 + 2 + 3 = 6
 * �� 2 λ�ͻ����ʲ����� = 3 + 2 + 1 = 6
 * ��λ�ͻ�������еģ��ʲ��������� 6 �����Է��� 6 ��
 * ʾ�� 2��
 * <p>
 * ���룺accounts = [[1,5],[7,3],[3,5]]
 * �����10
 * ���ͣ�
 * �� 1 λ�ͻ����ʲ����� = 6
 * �� 2 λ�ͻ����ʲ����� = 10
 * �� 3 λ�ͻ����ʲ����� = 8
 * �� 2 λ�ͻ�����еģ��ʲ������� 10
 * ʾ�� 3��
 * <p>
 * ���룺accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * �����17
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * m ==?accounts.length
 * n ==?accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 * ͨ������33,728�ύ����39,722
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/richest-customer-wealth
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        int col = accounts[0].length;
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += account[j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
