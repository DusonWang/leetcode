package code.code;

/**
 * @author duson
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDifference {

    public char findTheDifference2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        int ans = 0;
        int i = 0;
        for (; i < chars.length; i++) {
            ans += chars1[i];
            ans -= chars[i];
        }
        ans += chars1[i];
        return (char) ans;
    }

    public char findTheDifference(String s, String t) {
        final int[] sArray = new int[26];
        final int[] tArray = new int[26];
        for (char sChar : s.toCharArray()) {
            sArray[sChar - 'a']++;
        }
        for (char tChar : t.toCharArray()) {
            tArray[tChar - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sArray[i] != tArray[i]) {
                return (char) ('a' + i);
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        FindTheDifference findTheDifference = new FindTheDifference();

        System.out.println(findTheDifference.findTheDifference("abcd", "abcde"));
    }
}
