package com.leetcode.offer.code;

/**
 * @author duson
 * ����һ���ַ��� s?��һ������ k?�������� s?�ַ����� �����ַ�?���� k?���ǿ� ���Ĵ�?��
 * <p>
 * ����������?s?�������ַ�����?k?�������ַ�������ô���㷵�� True?�����򷵻�?False?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "annabelle", k = 2
 * �����true
 * ���ͣ������� s �������ַ����� 2 �������ַ�����
 * һЩ���еĹ��췽��������"anna" + "elble"��"anbna" + "elle"��"anellena" + "b"
 * ʾ�� 2��
 * <p>
 * ���룺s = "leetcode", k = 3
 * �����false
 * ���ͣ��޷��� s �������ַ����� 3 �����Ĵ���
 * ʾ�� 3��
 * <p>
 * ���룺s = "true", k = 4
 * �����true
 * ���ͣ�Ψһ���еķ������� s ��ÿ���ַ���������һ���ַ�����
 * ʾ�� 4��
 * <p>
 * ���룺s = "yzyzyzyzyzyzyzy", k = 2
 * �����true
 * ���ͣ���ֻ��Ҫ�����е� z ����һ���ַ����У����е� y ������һ���ַ����С���ô�����ַ������ǻ��Ĵ���
 * ʾ�� 5��
 * <p>
 * ���룺s = "cr", k = 7
 * �����false
 * ���ͣ�����û���㹻���ַ�ȥ���� 7 �����Ĵ���
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 10^5
 * s?�������ַ�����СдӢ����ĸ��
 * 1 <= k <= 10^5
 * ͨ������2,413�ύ����4,298
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/construct-k-palindrome-strings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CanConstruct2 {

    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int ones = 0;
        for (int i : count) {
            if ((i & 1) == 1) {
                ones++;
            }
        }
        return ones <= k;
    }
}
