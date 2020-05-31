package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * ����һ������������ 3n �鲻ͬ��С�Ĳ�����ɣ�������������������Ҫ�������¹�������������
 * <p>
 * ����ѡ ����?һ��������
 * Alice ������ѡ����ѡ���������ʱ�뷽�����һ��������
 * Bob ������ѡ����ѡ�������˳ʱ�뷽�����һ��������
 * �ظ���������ֱ��û������ʣ�¡�
 * ÿһ�������Ĵ�С��˳ʱ�뷽����ѭ������ slices?��ʾ��
 * <p>
 * ���㷵������Ի�õ�������С�ܺ͵����ֵ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺slices = [1,2,3,4,5,6]
 * �����10
 * ���ͣ�ѡ���СΪ 4 ��������Alice �� Bob �ֱ���ѡ��СΪ 3 �� 5 ��������Ȼ����ѡ���СΪ 6 ��������Alice �� Bob �ֱ���ѡ��СΪ 2 �� 1 �����������õ������ܴ�СΪ 4 + 6 = 10 ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺slices = [8,9,8,6,1,1]
 * �����16
 * ���ͣ����ֶ�ѡ��СΪ 8 �������������ѡ���СΪ 9 ����������������Ǿͻ�ѡ���СΪ 8 ���������������������ܺͲ������ġ�
 * ʾ�� 3��
 * <p>
 * ���룺slices = [4,1,2,5,8,3,1,9,7]
 * �����21
 * ʾ�� 4��
 * <p>
 * ���룺slices = [3,1,2]
 * �����3
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= slices.length <= 500
 * slices.length % 3 == 0
 * 1 <= slices[i] <= 1000
 * ͨ������927�ύ����2,136
 * ����ʵ������������������⣿
 * <p>
 * <p>
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/pizza-with-3n-slices
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxSizeSlices {

    public int maxSizeSlices(int[] slices) {
        int m = slices.length, n = m / 3;
        int[] slices1 = Arrays.copyOfRange(slices, 0, m - 1);
        int[] slices2 = Arrays.copyOfRange(slices, 1, m);
        return Math.max(maxSum(slices1, n), maxSum(slices2, n));
    }

    private int maxSum(int[] arr, int n) {
        int m = arr.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == 1) {
                    dp[i][j] = arr[0];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + arr[i - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
