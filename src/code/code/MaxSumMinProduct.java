package code.code;

import java.util.Stack;

/**
 * һ������� ��С�˻�?����Ϊ��������� ��Сֵ?����?����� ��?��
 * <p>
 * �ȷ�˵������?[3,2,5]?����Сֵ��?2������С�˻�Ϊ?2 * (3+2+5) = 2 * 10 = 20?��
 * ����һ������������?nums?�����㷵��?nums?����?�ǿ�������?����С�˻�?��?���ֵ?�����ڴ𰸿��ܴܺ����㷵�ش𰸶�??109 + 7?ȡ��?�Ľ����
 * <p>
 * ��ע�⣬��С�˻������ֵ���ǵ���ȡ����� ֮ǰ?�Ľ������Ŀ��֤��С�˻������ֵ�� ��ȡ�� ������¿����� 64 λ�з�������?���档
 * <p>
 * ������?����Ϊһ������� ����?���֡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,2]
 * �����14
 * ���ͣ���С�˻������ֵ�������� [2,3,2] ����Сֵ�� 2���õ���
 * 2 * (2+3+2) = 2 * 7 = 14 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [2,3,3,1,2]
 * �����18
 * ���ͣ���С�˻������ֵ�������� [3,3] ����Сֵ�� 3���õ���
 * 3 * (3+3) = 3 * 6 = 18 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [3,1,5,6,4,2]
 * �����60
 * ���ͣ���С�˻������ֵ�������� [5,6,4] ����Сֵ�� 4���õ���
 * 4 * (5+6+4) = 4 * 15 = 60 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 107
 * ͨ������3,250�ύ����8,957
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-subarray-min-product
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxSumMinProduct {

    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        long[] sums = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int index = -1;
        int[] indexStack = new int[len];
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int v = nums[i];
            while (index > -1 && nums[indexStack[index]] > v) {
                int pop = nums[indexStack[index--]];
                int left = index > -1 ? (indexStack[index] + 1) : 0;
                ans = Math.max(ans, pop * (sums[i] - sums[left]));
            }
            indexStack[++index] = i;
        }
        while (index > -1) {
            int pop = nums[indexStack[index--]];
            int left = index > -1 ? (indexStack[index] + 1) : 0;
            ans = Math.max(ans, pop * (sums[len] - sums[left]));
        }

        return (int) (ans % 1000000007);
    }
}
