package com.leetcode.offer.code;

/**
 * ����һ���������� nums�����㷵�ظ�������ǡ���ĸ���������Щ�����ĸ�����֮�͡�
 * <p>
 * ��������в���������������������򷵻� 0 ��
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺nums = [21,4,7]
 * �����32
 * ���ͣ�
 * 21 �� 4 ��������1, 3, 7, 21
 * 4 �� 3 ��������1, 2, 4
 * 7 �� 2 ��������1, 7
 * �𰸽�Ϊ 21 �����������ĺ͡�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 * ͨ������4,171�ύ����12,850
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/four-divisors
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SumFourDivisors {

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int count = 0;
            int temp = 0;
            for (int k = 1; k * k <= num; k++) {
                if (num % k == 0) {
                    temp += k;
                    count++;
                    if (k * k != num) {
                        temp += num / k;
                        count++;
                    }
                    if (count > 4) {
                        break;
                    }
                }
            }
            if (count == 4) {
                res += temp;
            }

        }
        return res;
    }
}
