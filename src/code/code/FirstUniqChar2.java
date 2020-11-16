package code.code;

/**
 * @author duson
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * 通过次数1,562提交次数2,613
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar2 {

    public char firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return ' ';
        }
        final int[] array = new int[26];
        final char[] ca = s.toCharArray();
        for (char c : ca) {
            array[c - 'a'] += 1;
        }
        for (char c : ca) {
            if (array[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
