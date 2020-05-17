package com.leetcode.offer.code;

/**
 * @author duson
 * ������ n �����۱ң�ÿ�ѵ��������������� coins �С�����ÿ�ο���ѡ������һ�ѣ��������е�һö������ö���������������۱ҵ����ٴ�����
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[4,2,1]
 * <p>
 * �����4
 * <p>
 * ���ͣ���һ�����۱�������Ҫ�� 2 �Σ��ڶ���������Ҫ�� 1 �Σ�������������Ҫ�� 1 �Σ��ܹ� 4 �μ������ꡣ
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺[2,3,10]
 * <p>
 * �����8
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 * ͨ������7,522�ύ����9,451
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/na-ying-bi
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinCount {

    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            if ((coin & 1) == 0) {
                count += coin / 2;
            } else {
                count++;
                count += coin / 2;
            }
        }
        return count;
    }
}
