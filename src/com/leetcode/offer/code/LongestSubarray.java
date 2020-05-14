package com.leetcode.offer.code;

/**
 * ����һ���������� nums ����һ����ʾ���Ƶ����� limit�����㷵�������������ĳ��ȣ����������е���������Ԫ��֮��ľ��Բ����С�ڻ��ߵ��� limit ��
 * <p>
 * ������������������������飬�򷵻� 0 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [8,2,4,7], limit = 4
 * �����2
 * ���ͣ��������������£�
 * [8] �����Բ� |8-8| = 0 <= 4.
 * [8,2] �����Բ� |8-2| = 6 > 4.
 * [8,2,4] �����Բ� |8-2| = 6 > 4.
 * [8,2,4,7] �����Բ� |8-2| = 6 > 4.
 * [2] �����Բ� |2-2| = 0 <= 4.
 * [2,4] �����Բ� |2-4| = 2 <= 4.
 * [2,4,7] �����Բ� |2-7| = 5 > 4.
 * [4] �����Բ� |4-4| = 0 <= 4.
 * [4,7] �����Բ� |4-7| = 3 <= 4.
 * [7] �����Բ� |7-7| = 0 <= 4.
 * ��ˣ�����������������ĳ���Ϊ 2 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [10,1,2,4,7,2], limit = 5
 * �����4
 * ���ͣ������������������� [2,4,7,2]���������Բ� |2-7| = 5 <= 5 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [4,2,2,2,4,4,2,2], limit = 0
 * �����3
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 * ͨ������3,446�ύ����9,179
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int maxI = 0;
        int minI = 0;
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] > nums[maxI]) {
                maxI = r;
            }
            if (nums[r] < nums[minI]) {
                minI = r;
            }
            while (nums[maxI] - nums[minI] > limit) {
                if (maxI < minI) {
                    l = ++maxI;
                } else {
                    l = ++minI;
                }
                r = l;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
