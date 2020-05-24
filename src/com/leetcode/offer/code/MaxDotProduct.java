package com.leetcode.offer.code;

/**
 * ������������?nums1?��?nums2?��
 * <p>
 * ���㷵�� nums1 �� nums2 ������������ͬ�� �ǿ� �����е��������
 * <p>
 * ����ķǿ���������ͨ��ɾ��ԭ������ĳЩԪ�أ�����һ��Ҳ��ɾ������ʣ��������ɵ����У������ܸı����ּ����˳�򡣱ȷ�˵��[2,3,5]?��?[1,2,3,4,5]?��һ�������ж�?[1,5,3]?���ǡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * �����18
 * ���ͣ��� nums1 �еõ������� [2,-2] ���� nums2 �еõ������� [3,-6] ��
 * ���ǵĵ��Ϊ (2*3 + (-2)*(-6)) = 18 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [3,-2], nums2 = [2,-6,7]
 * �����21
 * ���ͣ��� nums1 �еõ������� [3] ���� nums2 �еõ������� [7] ��
 * ���ǵĵ��Ϊ (3*7) = 21 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums1 = [-1,-1], nums2 = [1,1]
 * �����-1
 * ���ͣ��� nums1 �еõ������� [-1] ���� nums2 �еõ������� [1] ��
 * ���ǵĵ��Ϊ -1 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 100
 * ?
 * <p>
 * �����
 * <p>
 * ���� a?= [a1,?a2,��,?an] �� b?= [b1,?b2,��,?bn] �ĵ��Ϊ��
 * <p>
 * <p>
 * <p>
 * ����� �� ָʾ�ܺͷ��š�
 * ͨ������1,245�ύ����3,827
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author duson
 */
public class MaxDotProduct {

    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i) {
            dp[i] = new int[m];
            for (int j = 0; j < m; ++j) {
                dp[i][j] = a[i] * b[j];
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], 0);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
