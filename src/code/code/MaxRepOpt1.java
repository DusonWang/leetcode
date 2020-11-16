package code.code;

/**
 * @author duson
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-for-longest-repeated-character-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxRepOpt1 {

    public int maxRepOpt1(String text) {
        int[] hash = new int[26];
        int max = 0;
        for (char c : text.toCharArray()) {
            hash[c - 'a']++;
            max = Math.max(max, hash[c - 'a']);
        }
        if (max <= 1) {
            return max;
        }
        max = 1;
        int i = 0, n = text.length();
        while (i < n) {
            int j = i;
            char cur = text.charAt(i);
            while (j < n && text.charAt(j) == cur) {
                j++;
            }
            int k = j + 1;
            while (k < n && text.charAt(k) == cur) {
                k++;
            }
            max = Math.max(max, (k - i - 1 == hash[cur - 'a']) ? k - i - 1 : k - i);
            i = j;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxRepOpt1 a = new MaxRepOpt1();
        System.out.println(a.maxRepOpt1("aabcde"));
    }
}
