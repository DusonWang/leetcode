package code.code;

/**
 * @author duson
 * 给你两个字符串?s1?和?s2?，它们长度相等，请你检查是否存在一个?s1? 的排列可以打破 s2?的一个排列，或者是否存在一个?s2?的排列可以打破 s1 的一个排列。
 * <p>
 * 字符串?x?可以打破字符串?y?（两者长度都为?n?）需满足对于所有?i（在?0?到?n - 1?之间）都有?x[i] >= y[i]（字典序意义下的顺序）。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "abc", s2 = "xya"
 * 输出：true
 * 解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
 * 示例 2：
 * <p>
 * 输入：s1 = "abe", s2 = "acd"
 * 输出：false
 * 解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括："acd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排列。
 * 示例 3：
 * <p>
 * 输入：s1 = "leetcodee", s2 = "interview"
 * 输出：true
 * ?
 * <p>
 * 提示：
 * <p>
 * s1.length == n
 * s2.length == n
 * 1 <= n <= 10^5
 * 所有字符串都只包含小写英文字母。
 * 通过次数2,300提交次数3,709
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-a-string-can-break-another-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckIfCanBreak {

    public boolean checkIfCanBreak(String s1, String s2) {
        int[] res1 = new int[26];
        int[] res2 = new int[26];
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            res1[c - 'a']++;
        }
        chars = s2.toCharArray();
        for (char c : chars) {
            res2[c - 'a']++;
        }
        for (int i = 1; i < 26; i++) {
            res1[i] += res1[i - 1];
            res2[i] += res2[i - 1];
        }
        return f(res1, res2) || f(res2, res1);
    }

    private boolean f(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }
}
