package code.code;

import java.util.Arrays;

/**
 * �г̳��ȱ��� ��һ�ֳ��õ��ַ���ѹ��������������������ͬ�ַ����ظ� 2 �λ����Σ��滻Ϊ�ַ��ͱ�ʾ�ַ����������֣��г̳��ȣ������磬�ô˷���ѹ���ַ��� "aabccc" ���� "aa" �滻Ϊ "a2" ��"ccc" �滻Ϊ` "c3" �����ѹ������ַ�����Ϊ "a2bc3" ��
 * <p>
 * ע�⣬�������У�ѹ��ʱû���ڵ����ַ��󸽼Ӽ��� '1' ��
 * <p>
 * ����һ���ַ��� s ��һ������ k ������Ҫ���ַ��� s ��ɾ����� k ���ַ�����ʹ s ���г̳��ȱ��볤����С��
 * <p>
 * ���㷵��ɾ����� k ���ַ���s �г̳��ȱ������С���� ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aaabcccd", k = 2
 * �����4
 * ���ͣ��ڲ�ɾ���κ����ݵ�����£�ѹ������ַ����� "a3bc3d" ������Ϊ 6 �����ŵķ�����ɾ�� 'b' �� 'd'������һ����ѹ������ַ���Ϊ "a3c3" �������� 4 ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "aabbaa", k = 2
 * �����2
 * ���ͣ����ɾȥ���� 'b' �ַ�����ôѹ������ַ����ǳ���Ϊ 2 �� "a4" ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "aaaaaaaaaaa", k = 0
 * �����3
 * ���ͣ����� k ���� 0 ������ɾȥ�κ��ַ���ѹ������ַ����� "a11" ������Ϊ 3 ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 100
 * 0 <= k <= s.length
 * s ������СдӢ����ĸ
 * ͨ������1,665�ύ����5,275
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/string-compression-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetLengthOfOptimalCompression {

//    public int getLengthOfOptimalCompression(String s, int k) {
//        int n = s.length();
//        int[][] f = new int[n + 1][k + 1];
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(f[i], Integer.MAX_VALUE >> 1);
//        }
//        f[0][0] = 0;
//        for (int i = 1; i <= n; ++i) {
//            for (int j = 0; j <= k && j <= i; ++j) {
//                if (j > 0) {
//                    f[i][j] = f[i - 1][j - 1];
//                }
//                int same = 0;
//                int diff = 0;
//                for (int a = i; a >= 1 && diff <= j; --a) {
//                    if (s.charAt(a - 1) == s.charAt(i - 1)) {
//                        ++same;
//                        f[i][j] = Math.min(f[i][j], f[a - 1][j - diff] + calc(same));
//                    } else {
//                        ++diff;
//                    }
//                }
//            }
//        }
//        return f[n][k];
//    }
//
//    public int calc(int x) {
//        if (x == 1) {
//            return 1;
//        }
//        if (x < 10) {
//            return 2;
//        }
//        if (x < 100) {
//            return 3;
//        }
//        return 4;
//    }

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int[] x : dp) {
            Arrays.fill(x, n + 1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i && j <= k; j++) {
                if (j < k) {
                    dp[i][j + 1] = Math.min(dp[i - 1][j], dp[i][j + 1]);
                }
                int del = 0;
                for (int l = i; l > 0; l--) {
                    if (s.charAt(l - 1) != s.charAt(i - 1)) {
                        if (++del > j) {
                            break;
                        }
                    } else {
                        dp[i][j] = Math.min(dp[l - 1][j - del] + len(i - l + 1 - del) + 1, dp[i][j]);
                    }
                }
            }
        }
        return dp[n][k];
    }

    public int len(int k) {
        if (k <= 1) {
            return 0;
        } else if (k < 10) {
            return 1;
        } else if (k < 100) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        GetLengthOfOptimalCompression getLengthOfOptimalCompression = new GetLengthOfOptimalCompression();
        System.out.println(getLengthOfOptimalCompression.getLengthOfOptimalCompression("aaabcccd", 2));
    }
}
