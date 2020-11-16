package code.code;

/**
 * @author duson
 * ����һ����Сд��ĸ��ɵ��ַ���?s����һ������?k��
 * <p>
 * ���㰴�����Ҫ��ָ��ַ�����
 * <p>
 * ���ȣ�����Խ�?s?�еĲ����ַ��޸�Ϊ������СдӢ����ĸ��
 * ���ţ�����Ҫ��?s?�ָ��?k?���ǿ��Ҳ��ཻ���Ӵ�������ÿ���Ӵ����ǻ��Ĵ���
 * �뷵�������ַ�ʽ�ָ��ַ��������޸ĵ������ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "abc", k = 2
 * �����1
 * ���ͣ�����԰��ַ����ָ�� "ab" �� "c"�����޸� "ab" �е� 1 ���ַ���������ɻ��Ĵ���
 * ʾ�� 2��
 * <p>
 * ���룺s = "aabbc", k = 3
 * �����0
 * ���ͣ�����԰��ַ����ָ�� "aa"��"bb" �� "c"�����Ƕ��ǻ��Ĵ���
 * ʾ�� 3��
 * <p>
 * ���룺s = "leetcode", k = 8
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= k <= s.length <= 100
 * s?��ֻ����СдӢ����ĸ��
 * ͨ������1,544�ύ����2,695
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/palindrome-partitioning-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PalindromePartition {

    public int palindromePartition(String s, int k) {
        int len = s.length();
        int[][] times = new int[len][len];
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int end = i + l - 1;
                times[i][end] = times[i + 1][end - 1] + (s.charAt(i) == s.charAt(end) ? 0 : 1);
            }
        }
        int[][] dp = new int[len + 1][k + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                if (j == 1) {
                    dp[i][j] = times[0][i - 1];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int start = j - 1; start < i; start++) {
                        dp[i][j] = Math.min(dp[i][j], dp[start][j - 1] + times[start][i - 1]);
                    }
                }
            }
        }
        return dp[len][k];
    }
}
