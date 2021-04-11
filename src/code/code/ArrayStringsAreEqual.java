package code.code;

/**
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * <p>
 * 数组表示的字符串?是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 * <p>
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] 和 word2[i] 由小写字母组成
 * 通过次数15,888提交次数19,379
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int len1 = word1.length;
        int len2 = word2.length;
        int i = 0;
        int j = 0;
        int p1 = 0;
        int p2 = 0;
        while (i < len1 && j < len2) {
            String str = word1[i];
            String str2 = word2[j];
            while (p1 < str.length() && p2 < str2.length()) {
                if (str.charAt(p1) != str2.charAt(p2)) {
                    return false;
                }
                p1++;
                p2++;
            }
            if (p1 == str.length()) {
                p1 = 0;
                i++;
            }
            if (p2 == str2.length()) {
                p2 = 0;
                j++;
            }
        }
        return p1 == 0 && p2 == 0;
    }
}
