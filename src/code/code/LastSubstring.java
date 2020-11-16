package code.code;

/**
 * @author duson
 * 给你一个字符串?s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入："abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例?2：
 * <p>
 * 输入："leetcode"
 * 输出："tcode"
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 4 * 10^5
 * s 仅含有小写英文字符。
 * 通过次数2,789提交次数11,953
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-substring-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LastSubstring {

    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        char[] ss = s.toCharArray();
        while (j < n) {
            if (ss[j] < ss[i]) {
                j++;
            } else {
                int k = 0;
                while (j + k < n && ss[i + k] == ss[j + k]) {
                    k++;
                }
                if (j + k == n) {
                    break;
                }
                if (ss[j + k] < ss[i + k]) {
                    j = j + k + 1;
                } else {
                    i = j;
                    j = i + 1;
                }
            }
        }
        return s.substring(i);
    }
}
