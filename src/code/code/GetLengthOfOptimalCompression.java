package code.code;

import java.util.Arrays;

/**
 * 行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。
 * <p>
 * 注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
 * <p>
 * 给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。
 * <p>
 * 请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabcccd", k = 2
 * 输出：4
 * 解释：在不删除任何内容的情况下，压缩后的字符串是 "a3bc3d" ，长度为 6 。最优的方案是删除 'b' 和 'd'，这样一来，压缩后的字符串为 "a3c3" ，长度是 4 。
 * 示例 2：
 * <p>
 * 输入：s = "aabbaa", k = 2
 * 输出：2
 * 解释：如果删去两个 'b' 字符，那么压缩后的字符串是长度为 2 的 "a4" 。
 * 示例 3：
 * <p>
 * 输入：s = "aaaaaaaaaaa", k = 0
 * 输出：3
 * 解释：由于 k 等于 0 ，不能删去任何字符。压缩后的字符串是 "a11" ，长度为 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 0 <= k <= s.length
 * s 仅包含小写英文字母
 * 通过次数1,665提交次数5,275
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
