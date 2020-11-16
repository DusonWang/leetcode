package code.code;

/**
 * @author duson
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 * <p>
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 
 * <p>
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "a"
 * 输出: 1
 * 解释: 字符串 S 中只有一个"a"子字符。
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: "cac"
 * 输出: 2
 * 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 *  
 * <p>
 * 示例 3:
 * <p>
 * 输入: "zab"
 * 输出: 6
 * 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstringInWraproundString {

    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        int[] count = new int[26];
        int cur = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                cur++;
            } else {
                cur = 1;
            }
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], cur);
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }

}
