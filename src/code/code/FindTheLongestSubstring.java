package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 示例 2：
 * <p>
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 示例 3：
 * <p>
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 * 通过次数1,054提交次数2,579
 * 在真实的面试中遇到过这道题？
 *
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 */
public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        int[] prev = new int[32];
        Arrays.fill(prev, Integer.MAX_VALUE);
        int n = s.length(), state = 0, result = 0;
        prev[0] = -1;
        for (int i = 0; i < n; ++i) {
            switch (s.charAt(i)) {
                case 'a':
                    state ^= 1;
                    break;
                case 'e':
                    state ^= 2;
                    break;
                case 'i':
                    state ^= 4;
                    break;
                case 'o':
                    state ^= 8;
                    break;
                case 'u':
                    state ^= 16;
                    break;
                default:
                    break;
            }
            if (prev[state] == Integer.MAX_VALUE) {
                prev[state] = i;
            } else {
                result = Math.max(result, i - prev[state]);
            }
        }
        return result;
    }
}
