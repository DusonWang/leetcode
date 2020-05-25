package com.leetcode.offer.code;

import java.util.HashMap;

/**
 * ����һ�������ַ������ֵ����飬�ҵ���������飬�Ұ������ַ������ֵĸ�����ͬ��
 * <p>
 * ���ظ������飬�����ڶ��������飬������˵���С�ġ������������������飬����һ�������顣
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * <p>
 * ���: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * ʾ�� 2:
 * <p>
 * ����: ["A","A"]
 * <p>
 * ���: []
 * ��ʾ��
 * <p>
 * array.length <= 100000
 * ͨ������971�ύ����2,740
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-longest-subarray-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindLongestSubarray {

    public String[] findLongestSubarray(String[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = -1;
        int len = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < array.length; ++i) {
            char c = ' ';
            for (char ch : array[i].toCharArray()) {
                c = ch;
            }
            if (c >= '0' && c <= '9') {
                sum--;
            } else {
                sum++;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                if (i - map.get(sum) > len) {
                    l = map.get(sum);
                    len = i - l;
                }
            }
        }
        String[] res = new String[len];
        for (int i = 1; i <= len; ++i) {
            res[i - 1] = array[i + l];
        }
        return res;
    }

}
