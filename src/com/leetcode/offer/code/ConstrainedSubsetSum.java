package com.leetcode.offer.code;

/**
 * ����һ����������?nums?��һ������?k?�����㷵�� �ǿ�?������Ԫ�غ͵����ֵ����������Ҫ���㣺��������ÿ���� ����?������?nums[i]?��?nums[j]?��������ԭ�����е��±�?i?��?j?����?i < j?�� j - i <= k ��
 * <p>
 * ����������ж���Ϊ���������е����ɸ�����ɾ��������ɾ�� 0 �����֣���ʣ�µ����ְ���ԭ����˳���Ų���
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [10,2,-10,5,20], k = 2
 * �����37
 * ���ͣ�������Ϊ [10, 2, 5, 20] ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [-1,-2,-3], k = 1
 * �����-1
 * ���ͣ������б����Ƿǿյģ���������ѡ���������֡�
 * ʾ�� 3��
 * <p>
 * ���룺nums = [10,-2,-10,-5,20], k = 2
 * �����23
 * ���ͣ�������Ϊ [10, -2, -5, 20] ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= k <= nums.length <= 10^5
 * -10^4?<= nums[i] <= 10^4
 * ͨ������1,584�ύ����3,930
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/constrained-subsequence-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ConstrainedSubsetSum {

    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i - max > k) {
                max = i - 1;
                for (int j = i - 2; j >= i - k && j >= 0; j--) {
                    if (dp[max] < dp[j]) {
                        max = j;
                    }
                }
            }
            dp[i] = Math.max(nums[i], dp[max] + nums[i]);
            if (dp[i] > dp[max]) {
                max = i;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
