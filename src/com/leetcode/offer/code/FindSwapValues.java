package com.leetcode.offer.code;

import java.util.HashSet;
import java.util.Set;

/**
 * ���������������飬�뽻��һ����ֵ��ÿ��������ȡһ����ֵ����ʹ��������������Ԫ�صĺ���ȡ�
 * <p>
 * ����һ�����飬��һ��Ԫ���ǵ�һ��������Ҫ������Ԫ�أ��ڶ���Ԫ���ǵڶ���������Ҫ������Ԫ�ء����ж���𰸣���������һ�����ɡ�����������������ֵ�����ؿ����顣
 * <p>
 * ʾ��:
 * <p>
 * ����: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * ���: [1, 3]
 * ʾ��:
 * <p>
 * ����: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * ���: []
 * ��ʾ��
 * <p>
 * 1 <= array1.length, array2.length <= 100000
 * ͨ������1,789�ύ����4,057
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-swap-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindSwapValues {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : array1) {
            sum1 += i;
        }
        for (int i : array2) {
            sum2 += i;
            set.add(i);
        }
        int sum = sum1 + sum2;
        if (sum % 2 != 0) {
            return new int[0];
        }
        int target = sum / 2;
        for (int i : array1) {
            if (set.contains(target - (sum1 - i))) {
                return new int[]{i, target - (sum1 - i)};
            }
        }
        return new int[0];
    }
}
