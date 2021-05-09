package code.code;

/**
 * ����һ����ά�������� logs ������ÿ�� logs[i] = [birthi, deathi] ��ʾ�� i ���˵ĳ�����������ݡ�
 * <p>
 * ��� x �� �˿� ����Ϊ��һ���ڼ���ŵ��˵���Ŀ���� i ���˱�������� x ���˿���Ҫ���㣺x �ڱ����� [birthi, deathi - 1] �ڡ�ע�⣬�˲�Ӧ��������������������˿��С�
 * <p>
 * ���� �˿���� �� ���� ����ݡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺logs = [[1993,1999],[2000,2010]]
 * �����1993
 * ���ͣ��˿����Ϊ 1 ���� 1993 ���˿�Ϊ 1 ��������ݡ�
 * ʾ�� 2��
 * <p>
 * ���룺logs = [[1950,1961],[1960,1971],[1970,1981]]
 * �����1960
 * ���ͣ�
 * �˿����Ϊ 2 ���ֱ������ 1960 �� 1970 ��
 * ������������� 1960 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 * ͨ������3,581�ύ����6,660
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-population-year
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximumPopulation {

    public int maximumPopulation(int[][] logs) {
        int[] temp = new int[101];
        for (int[] log : logs) {
            temp[log[0] - 1950]++;
            temp[log[1] - 1950]--;
        }
        int max = 0;
        int ans = 0;
        for (int i = 0, cnt = 0; i <= 100; i++) {
            cnt += temp[i];
            if (cnt > max) {
                max = cnt;
                ans = i;
            }
        }
        return ans + 1950;
    }
}
