package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * һ�� �������ַ���������Ϊ��
 * <p>
 * ������Сд��ĸ?['a', 'b', 'c'].
 * ��������?1?��?s.length - 1?֮���?i?������?s[i] != s[i + 1]?���ַ������±�� 1 ��ʼ����
 * �ȷ�˵���ַ���?"abc"��"ac"��"b" ��?"abcbabcbcb"?���ǿ����ַ���������?"aa"��"baa"?��?"ababbc"?�����ǿ����ַ�����
 * <p>
 * ������������ n?�� k?������Ҫ������Ϊ n?�����п����ַ������ֵ�������
 * <p>
 * ���㷵�������ĵ� k �������ַ������������Ϊ n?�Ŀ����ַ������� k?������ô���㷵�� ���ַ���?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 1, k = 3
 * �����"c"
 * ���ͣ��б� ["a", "b", "c"] ���������г���Ϊ 1 �Ŀ����ַ����������ֵ��������������ַ���Ϊ "c" ��
 * ʾ�� 2��
 * <p>
 * ���룺n = 1, k = 4
 * �����""
 * ���ͣ�����Ϊ 1 �Ŀ����ַ���ֻ�� 3 ����
 * ʾ�� 3��
 * <p>
 * ���룺n = 3, k = 9
 * �����"cab"
 * ���ͣ�����Ϊ 3 �Ŀ����ַ����ܹ��� 12 �� ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"] ���� 9 ���ַ���Ϊ "cab"
 * ʾ�� 4��
 * <p>
 * ���룺n = 2, k = 7
 * �����""
 * ʾ�� 5��
 * <p>
 * ���룺n = 10, k = 100
 * �����"abacbabacb"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 10
 * 1 <= k <= 100
 * ?
 * <p>
 * ͨ������2,165�ύ����3,171
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetHappyString {

    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        buildHappyStrings(happyStrings, new char[]{'a', 'b', 'c'}, n, "");
        return happyStrings.size() >= k ? happyStrings.get(k - 1) : "";
    }

    private void buildHappyStrings(List<String> happyStrings, char[] chars, int n, String s) {
        if (n == s.length()) {
            happyStrings.add(s);
            return;
        }
        for (char c : chars) {
            if (s.isEmpty() || c != s.charAt(s.length() - 1)) {
                buildHappyStrings(happyStrings, chars, n, s + c);
            }
        }
    }
}
