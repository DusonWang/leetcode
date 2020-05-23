package com.leetcode.offer.code;

/**
 * ����һ���������ʽ��һ�������Ĳ������ result���������ʽ�� 0 (false)��1 (true)��& (AND)�� | (OR) �� ^ (XOR) ������ɡ�ʵ��һ������������м��ֿ�ʹ�ñ��ʽ�ó� result ֵ�����ŷ�����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: s = "1^0|0|1", result = 0
 * <p>
 * ���: 2
 * ����:?���ֿ��ܵ����ŷ�����
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * ʾ�� 2:
 * <p>
 * ����: s = "0&0&0&1^1|0", result = 1
 * <p>
 * ���: 10
 * ��ʾ��
 * <p>
 * ����������������� 19 ��
 * ͨ������691�ύ����1,455
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/boolean-evaluation-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountEval {

    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] cache = new int[n][n][];
        char[] chars = s.toCharArray();
        int[] res = backtrack(chars, 0, chars.length - 1, cache);
        return result == 0 ? res[0] : res[1];
    }

    private int[] backtrack(char[] chars, int left, int right, int[][][] cache) {
        if (left >= right) {
            int[] arr = new int[2];
            arr[chars[left] - '0'] = 1;
            return arr;
        }
        if (cache[left][right] != null) {
            return cache[left][right];
        }
        int[] res = new int[2];
        for (int i = left; i <= right; i++) {
            if (chars[i] == '0' || chars[i] == '1') {
                continue;
            }
            int[] l = backtrack(chars, left, i - 1, cache);
            int[] r = backtrack(chars, i + 1, right, cache);
            switch (chars[i]) {
                case '&':
                    // ���Ϊ0 ���������0 0��0 1��1 0
                    // ���Ϊ1 һ�������1 1
                    res[0] += (l[0] * r[0]) + (l[0] * r[1]) + (l[1] * r[0]);
                    res[1] += l[1] * r[1];
                    break;
                case '|':
                    // ���Ϊ0 һ�������0 0
                    // ���Ϊ1 ���������1 1��0 1��1 0
                    res[0] += l[0] * r[0];
                    res[1] += (l[1] * r[1]) + (l[0] * r[1]) + (l[1] * r[0]);
                    break;
                case '^':
                    // ���Ϊ0 ���������0 0��1 1
                    // ���Ϊ1 ���������0 1��1 0
                    res[0] += (l[0] * r[0]) + (l[1] * r[1]);
                    res[1] += (l[0] * r[1]) + (l[1] * r[0]);
                    break;
                default:
                    break;
            }
        }
        return cache[left][right] = res;
    }
}
