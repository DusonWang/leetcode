package com.leetcode.offer.code;

/**
 * ����һ�������� 0 �� 1 ��ɵ����� nums �Լ����� k��������� 1 ��������� k ��Ԫ�أ��򷵻� True �����򣬷��� False ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺nums = [1,0,0,0,1,0,0,1], k = 2
 * �����true
 * ���ͣ�ÿ�� 1 ��������� 2 ��Ԫ�ء�
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺nums = [1,0,0,1,0,1], k = 2
 * �����false
 * ���ͣ��ڶ��� 1 �͵����� 1 ֮��ֻ���� 1 ��Ԫ�ء�
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,1,1,1,1], k = 0
 * �����true
 * ʾ�� 4��
 * <p>
 * ���룺nums = [0,1,0,1], k = 1
 * �����true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] ��ֵΪ 0 �� 1
 * ͨ������3,886�ύ����6,269
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class KLengthApart {

    public boolean kLengthApart(int[] nums, int k) {
        int count = k;
        for (int num : nums) {
            if (num == 1) {
                if (count < k) {
                    return false;
                }
                count = 0;
            } else {
                count++;
            }
        }
        return true;
    }
}
