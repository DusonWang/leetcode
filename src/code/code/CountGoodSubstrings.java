package code.code;

/**
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好?字符串。
 * <p>
 * 给你一个字符串 s?，请你返回 s?中长度为 3?的 好子字符串 的数量。
 * <p>
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * <p>
 * 子字符串 是一个字符串中连续的字符序列。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。
 * 示例 2：
 * <p>
 * 输入：s = "aababcabc"
 * 输出：4
 * 解释：总共有 7 个长度为 3 的子字符串："aab"，"aba"，"bab"，"abc"，"bca"，"cab" 和 "abc" 。
 * 好子字符串包括 "abc"，"bca"，"cab" 和 "abc" 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s?????? 只包含小写英文字母。
 * 通过次数3,079提交次数4,232
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountGoodSubstrings {

    public int countGoodSubstrings(String str) {
        int res = 0;
        int n = str.length();
        char[] s = str.toCharArray();
        for (int i = 0; i < n - 2; ++i) {
            if (s[i] != s[i + 1] && s[i] != s[i + 2] && s[i + 1] != s[i + 2]) {
                ++res;
            }
        }
        return res;
    }
}
