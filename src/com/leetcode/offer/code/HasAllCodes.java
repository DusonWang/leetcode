package com.leetcode.offer.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author duson
 * ����һ���������ַ���?s?��һ������?k?��
 * <p>
 * ������г���Ϊ k?�Ķ������ַ������� s?���Ӵ����뷵�� True �������뷵�� False ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "00110110", k = 2
 * �����true
 * ���ͣ�����Ϊ 2 �Ķ����ƴ����� "00"��"01"��"10" �� "11"�����Ƿֱ��� s ���±�Ϊ 0��1��3��2 ��ʼ�ĳ���Ϊ 2 ���Ӵ���
 * ʾ�� 2��
 * <p>
 * ���룺s = "00110", k = 2
 * �����true
 * ʾ�� 3��
 * <p>
 * ���룺s = "0110", k = 1
 * �����true
 * ���ͣ�����Ϊ 1 �Ķ����ƴ����� "0" �� "1"����Ȼ���Ƕ��� s ���Ӵ���
 * ʾ�� 4��
 * <p>
 * ���룺s = "0110", k = 2
 * �����false
 * ���ͣ�����Ϊ 2 �Ķ����ƴ� "00" û�г����� s �С�
 * ʾ�� 5��
 * <p>
 * ���룺s = "0000000001011100", k = 4
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 5 * 10^5
 * s ��ֻ�� 0 �� 1 ��
 * 1 <= k <= 20
 * ͨ������1,901�ύ����4,337
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class HasAllCodes {

    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        if (s.length() - k < 0) {
            return false;
        }
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == Math.pow(2, k);
    }
}
