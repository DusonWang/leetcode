package code.code;

/**
 * @author duson
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * <p>
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        int i = 0, end = s.length() - 1, j = end;
        char[] chs = s.toCharArray();
        while (i < j) {
            if (chs[i] == chs[j]) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
