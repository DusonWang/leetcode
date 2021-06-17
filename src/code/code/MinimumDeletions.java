package code.code;

import java.util.Stack;

/**
 * ����һ���ַ���s�����������ַ�'a' ��'b' ��
 * <p>
 * �����ɾ��s��������Ŀ���ַ���ʹ��s ƽ�⡣���ǳ�sƽ��ĵ��������±��(i,j)����i < j ��s[i] = 'b'ͬʱs[j]= 'a'��
 * <p>
 * ���㷵��ʹ sƽ��� ����ɾ��������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aababbab"
 * �����2
 * ���ͣ������ѡ����������һ�ַ�����
 * �±�� 0 ��ʼ��ɾ���� 2 �͵� 6 ���ַ���"aababbab" -> "aaabbb"����
 * �±�� 0 ��ʼ��ɾ���� 3 �͵� 6 ���ַ���"aababbab" -> "aabbbb"����
 * ʾ�� 2��
 * <p>
 * ���룺s = "bbaaaaabb"
 * �����2
 * ���ͣ�Ψһ�����Ž���ɾ����ǰ�������ַ���
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 105
 * s[i]Ҫô��'a' Ҫô��'b'��
 * ͨ������3,017�ύ����6,119
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-deletions-to-make-string-balanced
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinimumDeletions {

    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'b') {
                stack.push('b');
            } else {
                if (!stack.empty()) {
                    cnt++;
                    stack.pop();
                }
            }
        }
        return cnt;
    }

}
