package code.code;

/**
 * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
 * <p>
 * 返回所有字符都为 1 的子字符串的数目。
 * <p>
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0110111"
 * 输出：9
 * 解释：共有 9 个子字符串仅由 '1' 组成
 * "1" -> 5 次
 * "11" -> 3 次
 * "111" -> 1 次
 * 示例 2：
 * <p>
 * 输入：s = "101"
 * 输出：2
 * 解释：子字符串 "1" 在 s 中共出现 2 次
 * 示例 3：
 * <p>
 * 输入：s = "111111"
 * 输出：21
 * 解释：每个子字符串都仅由 '1' 组成
 * 示例 4：
 * <p>
 * 输入：s = "000"
 * 输出：0
 * ?
 * <p>
 * 提示：
 * <p>
 * s[i] == '0' 或 s[i] == '1'
 * 1 <= s.length <= 10^5
 * 通过次数10,141提交次数27,093
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-substrings-with-only-1s
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSub {

    public int numSub(String s) {
        long count = 0;
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                ones = 0;
            } else {
                count += ++ones;
            }
        }
        return (int) (count % 1_000_000_007);
    }

    public static void main(String[] args) {
        NumSub numSub = new NumSub();
        System.out.println(numSub.numSub("0110111"));
    }
}
