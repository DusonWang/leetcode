package code.code;

import java.util.HashMap;

/**
 * ����һ���ַ���?s?��һ���ָ��Ϊ ���÷ָ?�������㣺��?s?�ָ�� 2 ���ַ���?p ��?q?������������������?s?�� p?�� q?�в�ͬ�ַ�����Ŀ��ͬ��
 * <p>
 * ���㷵�� s?�к÷ָ����Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aacaba"
 * �����2
 * ���ͣ��ܹ��� 5 �ַָ��ַ��� "aacaba" �ķ��������� 2 ���Ǻ÷ָ
 * ("a", "acaba") ����ַ������ұ��ַ����ֱ���� 1 ���� 3 ����ͬ���ַ���
 * ("aa", "caba") ����ַ������ұ��ַ����ֱ���� 1 ���� 3 ����ͬ���ַ���
 * ("aac", "aba") ����ַ������ұ��ַ����ֱ���� 2 ���� 2 ����ͬ���ַ�������һ���÷ָ
 * ("aaca", "ba") ����ַ������ұ��ַ����ֱ���� 2 ���� 2 ����ͬ���ַ�������һ���÷ָ
 * ("aacab", "a") ����ַ������ұ��ַ����ֱ���� 3 ���� 1 ����ͬ���ַ���
 * ʾ�� 2��
 * <p>
 * ���룺s = "abcd"
 * �����1
 * ���ͣ��÷ָ�Ϊ���ַ����ָ�� ("ab", "cd") ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "aaaaa"
 * �����4
 * ���ͣ����зָ�Ǻ÷ָ
 * ʾ�� 4��
 * <p>
 * ���룺s = "acbadbaada"
 * �����2
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * s?ֻ����СдӢ����ĸ��
 * 1 <= s.length <= 10^5
 * ͨ������4,588�ύ����6,948
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumSplits {

    public int numSplits(String s) {
        char[] str = s.toCharArray();
        int[] left = new int[26];
        int[] right = new int[26];
        int leftCnt = 0;
        int rightCnt = 0;
        int ans = 0;
        for (char ch : str) {
            if (++right[ch - 'a'] == 1) {
                ++rightCnt;
            }
        }
        for (char ch : str) {
            if (++left[ch - 'a'] == 1) {
                ++leftCnt;
            }
            if (--right[ch - 'a'] == 0) {
                --rightCnt;
            }
            if (leftCnt == rightCnt) {
                ++ans;
            }
        }
        return ans;
    }
}
