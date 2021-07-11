package code.code;

/**
 * 一个字符串的所有字符都是一样的，被称作等值字符串。
 * <p>
 * 举例，"1111" 和"33"就是等值字符串。
 * 相比之下，"123"就不是等值字符串。
 * 规则：给出一个数字字符串s，将字符串分解成一些等值字符串，如果有且仅有一个等值子字符串长度为2，其他的等值子字符串的长度都是3.
 * <p>
 * 如果能够按照上面的规则分解字符串s，就返回真，否则返回假。
 * <p>
 * 子串就是原字符串中连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "000111000"
 * 输出: false
 * 解释:  s只能被分解长度为3的等值子字符串。
 * 示例 2：
 * <p>
 * 输入: s = "00011111222"
 * 输出: true
 * 解释: s 能被分解为 ["000","111","11","222"].
 * 示例 3：
 * <p>
 * 输入: s = "01110002223300"
 * 输出: false
 * 解释: 一个不能被分解的原因是在开头有一个0.
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 1000
 * s仅包含数字。
 * 通过次数210提交次数363
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-a-string-is-decomposble-to-value-equal-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsDecomposable {

    public boolean isDecomposable(String s) {
        int i = 0;
        int two = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if ((j - i) % 3 == 1) {
                return false;
            }
            if ((j - i) % 3 == 2) {
                two++;
            }
            i = j;
        }
        return two == 1;
    }
}
