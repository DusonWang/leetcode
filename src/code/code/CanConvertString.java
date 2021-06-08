package code.code;

/**
 * 给你两个字符串s和t，你的目标是在 k次操作以内把字符串s转变成t。
 * <p>
 * 在第 i次操作时（1 <= i <= k），你可以选择进行如下操作：
 * <p>
 * 选择字符串 s中满足 1 <= j <= s.length且之前未被选过的任意下标 j（下标从 1 开始），并将此位置的字符切换 i次。
 * 不进行任何操作。
 * 切换 1 次字符的意思是用字母表中该字母的下一个字母替换它（字母表环状接起来，所以 'z'切换后会变成 'a'）。
 * <p>
 * 请记住任意一个下标 j最多只能被操作1 次。
 * <p>
 * 如果在不超过 k次操作内可以把字符串 s转变成 t，那么请你返回true，否则请你返回false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "input", t = "ouput", k = 9
 * 输出：true
 * 解释：第 6 次操作时，我们将 'i' 切换 6 次得到 'o' 。第 7 次操作时，我们将 'n' 切换 7 次得到 'u' 。
 * 示例 2：
 * <p>
 * 输入：s = "abc", t = "bcd", k = 10
 * 输出：false
 * 解释：我们需要将每个字符切换 1 次才能得到 t 。我们可以在第 1 次操作时将 'a' 切换成 'b' ，但另外 2 个字母在剩余操作中无法再转变为 t 中对应字母。
 * 示例 3：
 * <p>
 * 输入：s = "aab", t = "bbb", k = 27
 * 输出：true
 * 解释：第 1 次操作时，我们将第一个 'a' 切换 1 次得到 'b' 。在第 27 次操作时，我们将第二个字母 'a' 切换 27 次得到 'b' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= k <= 10^9
 * s和t只包含小写英文字母。
 * 通过次数4,478提交次数14,311
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-convert-string-in-k-moves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanConvertString {

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff > 0 && diff + count[diff] * 26 > k) {
                return false;
            }
            ++count[diff];
        }
        return true;
    }

    public static void main(String[] args) {
        CanConvertString canConvertString = new CanConvertString();
        System.out.println(canConvertString.canConvertString("input", "ouput", 9));
    }
}
