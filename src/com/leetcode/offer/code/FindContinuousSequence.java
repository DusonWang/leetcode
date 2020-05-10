package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ����һ�������� target ��������к�Ϊ target ���������������У����ٺ�������������
 * <p>
 * �����ڵ�������С�������У���ͬ���а����׸����ִ�С�������С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺target = 9
 * �����[[2,3,4],[4,5]]
 * ʾ�� 2��
 * <p>
 * ���룺target = 15
 * �����[[1,2,3,4,5],[4,5,6],[7,8]]
 * ?
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= target <= 10^5
 * ?
 * <p>
 * ͨ������31,272�ύ����45,744
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int i = 1;
        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] arr = new int[i];
                for (int j = target / i, k = 0; j < target / i + i; j++, k++) {
                    arr[k] = j;
                }
                list.add(arr);
            }
        }
        Collections.reverse(list);
        int[][] res = new int[0][];
        return list.toArray(res);
    }
}
