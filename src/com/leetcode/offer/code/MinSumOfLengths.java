package com.leetcode.offer.code;

import java.util.HashMap;

/**
 * @author duson
 * ����һ����������?arr ��һ������ֵ?target?��
 * <p>
 * ������ arr?���� ���������ص���������?�����ǵĺͶ�����?target?�����ܻ��ж��ַ��������㷵������Ҫ������������鳤�Ⱥ͵� ��Сֵ ��
 * <p>
 * �뷵������Ҫ�����С���Ⱥͣ�����޷��ҵ����������������飬�뷵�� -1?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [3,2,2,4,3], target = 3
 * �����2
 * ���ͣ�ֻ�������������Ϊ 3 ��[3] �� [3]�������ǵĳ��Ⱥ�Ϊ 2 ��
 * ʾ�� 2��
 * <p>
 * ���룺arr = [7,3,4,7], target = 7
 * �����2
 * ���ͣ����������� 3 �������ص����������Ϊ 7 ��[7], [3,4] �� [7]���������ǻ�ѡ���һ���͵����������飬��Ϊ���ǵĳ��Ⱥ� 2 ����Сֵ��
 * ʾ�� 3��
 * <p>
 * ���룺arr = [4,3,2,6,2,3,4], target = 6
 * �����-1
 * ���ͣ�����ֻ��һ����Ϊ 6 �������顣
 * ʾ�� 4��
 * <p>
 * ���룺arr = [5,5,4,4,5], target = 3
 * �����-1
 * ���ͣ������޷��ҵ���Ϊ 3 �������顣
 * ʾ�� 5��
 * <p>
 * ���룺arr = [3,1,1,1,5,1,2,1], target = 3
 * �����3
 * ���ͣ�ע�������� [1,2] �� [2,1] ���ܳ�Ϊһ��������Ϊ�����ص��ˡ�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 1000
 * 1 <= target <= 10^8
 * ͨ������1,319�ύ����5,885
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinSumOfLengths {

    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int sum = 0, lsize = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        hmap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            hmap.put(sum, i);
        }
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hmap.get(sum - target) != null) {
                lsize = Math.min(lsize, i - hmap.get(sum - target));
            }
            if (hmap.get(sum + target) != null && lsize < Integer.MAX_VALUE) {
                result = Math.min(result, hmap.get(sum + target) - i + lsize);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
