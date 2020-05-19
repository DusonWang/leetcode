package com.leetcode.offer.code;

/**
 * @author duson
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ����������������һ����ת�������ת�������СԪ�ء����磬����?[3,4,5,1,2] Ϊ [1,2,3,4,5] ��һ����ת�����������СֵΪ1��??
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[3,4,5,1,2]
 * �����1
 * ʾ�� 2��
 * <p>
 * ���룺[2,2,2,0,1]
 * �����0
 * ע�⣺��������վ 154 ����ͬ��https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p>
 * ͨ������25,794�ύ����54,931
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinArray {

    public int minArray(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else if (nums[m] < nums[h]) {
                h = m;
            } else {
                h--;
            }
        }
        return nums[l];
    }
}
