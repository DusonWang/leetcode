package code.code;

/**
 * ���������ַ���?s ��?t?�������ҳ� s?�еķǿ��Ӵ�����Ŀ����Щ�Ӵ������滻 һ����ͬ�ַ�?�Ժ��� t?�����Ӵ�������֮�������ҵ� s?�� t?���� ǡ��?ֻ��һ���ַ���ͬ�����ַ����Ե���Ŀ��
 * <p>
 * �ȷ�˵��?"computer" ��?"computation" �Ӵֲ���ֻ��һ���ַ���ͬ��?'e'/'a'?��������һ�����ַ�������𰸼� 1 ��
 * <p>
 * ���㷵���������������Ĳ�ͬ���ַ�������Ŀ��
 * <p>
 * һ�� ���ַ���?��һ���ַ������������ַ���
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aba", t = "baba"
 * �����6
 * ���ͣ�����Ϊֻ��� 1 ���ַ��� s �� t �������ַ����ԣ�
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * �Ӵֲ��ֱַ��ʾ s �� t ��ѡ���������ַ�����
 * ʾ�� 2��
 * ���룺s = "ab", t = "bb"
 * �����3
 * ���ͣ�����Ϊֻ��� 1 ���ַ��� s �� t �������ַ����ԣ�
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")
 * �Ӵֲ��ֱַ��ʾ s �� t ��ѡ���������ַ�����
 * ʾ�� 3��
 * ���룺s = "a", t = "a"
 * �����0
 * ʾ�� 4��
 * <p>
 * ���룺s = "abe", t = "bbc"
 * �����10
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length, t.length <= 100
 * s ��?t?��ֻ����СдӢ����ĸ��
 * ͨ������2,350�ύ����3,327
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-substrings-that-differ-by-one-character
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountSubstrings3 {

    public int countSubstrings(String s, String t) {
//        int m = s.length();
//        int n = t.length();
//        int res = 0;
//        int[][][] dp = new int[m + 1][n + 1][2];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                boolean flag = s.charAt(i) == t.charAt(j);
//                dp[i + 1][j + 1][0] = flag ? dp[i][j][0] + 1 : 0;
//                dp[i + 1][j + 1][1] = flag ? dp[i][j][1] : dp[i][j][0] + 1;
//                res += dp[i + 1][j + 1][1];
//            }
//        }
//        return res;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int ans = 0;
        int sLen = ss.length;
        int tLen = tt.length;
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                int diff = 0;
                for (int k = 0; i + k < sLen && j + k < sLen; k++) {
                    if (ss[i + k] != tt[j + k]) {
                        diff++;
                    }
                    if (diff == 1) {
                        ans++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
