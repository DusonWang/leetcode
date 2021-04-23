package code.code;

import java.util.Arrays;

/**
 * �������ף�С�к� Tony ����һЩѩ�������
 * <p>
 * �̵����µ� n ֧ѩ�⣬�ó���Ϊ n ������ costs ��ʾѩ��Ķ��ۣ����� costs[i] ��ʾ�� i ֧ѩ����ֽ�۸�Tony һ���� coins �ֽ�����������ѣ�����Ҫ�򾡿��ܶ��ѩ�⡣
 * <p>
 * ����۸����� costs ���ֽ��� coins ��������㲢���� Tony �� coins �ֽ��ܹ��򵽵�ѩ��� ������� ��
 * <p>
 * ע�⣺Tony ���԰�����˳����ѩ�⡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺costs = [1,3,2,4,1], coins = 7
 * �����4
 * ���ͣ�Tony �������±�Ϊ 0��1��2��4 ��ѩ�⣬�ܼ�Ϊ 1 + 3 + 2 + 1 = 7
 * ʾ�� 2��
 * <p>
 * ���룺costs = [10,6,8,7,7,8], coins = 5
 * �����0
 * ���ͣ�Tony û���㹻��Ǯ���κ�һ֧ѩ�⡣
 * ʾ�� 3��
 * <p>
 * ���룺costs = [1,6,3,1,2,5], coins = 20
 * �����6
 * ���ͣ�Tony �����������е�ѩ�⣬�ܼ�Ϊ 1 + 6 + 3 + 1 + 2 + 5 = 18 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * costs.length == n
 * 1 <= n <= 105
 * 1 <= costs[i] <= 105
 * 1 <= coins <= 108
 * ͨ������8,590�ύ����7,913
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int cost : costs) {
            if (cost <= coins) {
                ans++;
                coins -= cost;
            } else {
                break;
            }
        }
        return ans;
    }

}
