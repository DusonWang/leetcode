package code.code;

/**
 * 给你一个二进制字符串s。你可以按任意顺序执行以下两种操作任意次：
 * <p>
 * 类型 1 ：删除 字符串s的第一个字符并将它 添加到字符串结尾。
 * 类型 2 ：选择 字符串s中任意一个字符并将该字符反转，也就是如果值为'0'，则反转得到'1'，反之亦然。
 * 请你返回使 s变成 交替 字符串的前提下，类型 2的 最少操作次数。
 * <p>
 * 我们称一个字符串是 交替的，需要满足任意相邻字符都不同。
 * <p>
 * 比方说，字符串"010" 和"1010"都是交替的，但是字符串"0100"不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "111000"
 * 输出：2
 * 解释：执行第一种操作两次，得到 s = "100011" 。
 * 然后对第三个和第六个字符执行第二种操作，得到 s = "101010" 。
 * 示例 2：
 * <p>
 * 输入：s = "010"
 * 输出：0
 * 解释：字符串已经是交替的。
 * 示例 3：
 * <p>
 * 输入：s = "1110"
 * 输出：1
 * 解释：对第二个字符执行第二种操作，得到 s = "1010" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i]要么是'0'，要么是'1'。
 * 通过次数2,437提交次数7,915
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinFlips7 {

    public int minFlips(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count += (s.charAt(i) - '0' + (i & 1)) & 1;
        }
        int ans = Math.min(count, len - count);
        if ((len & 1) == 0) {
            return ans;
        }
        for (int i = 0; i < len; i++) {
            int n = (s.charAt(i) - '0' + (i & 1)) & 1;
            count -= n;
            count += 1 - n;
            ans = Math.min(ans, Math.min(count, len - count));
        }
        return ans;
    }

    public static void main(String[] args) {
        MinFlips7 minFlips7 = new MinFlips7();
        //System.out.println(minFlips7.minFlips("010"));
        //System.out.println(minFlips7.minFlips("1110"));
        System.out.println(minFlips7.minFlips("111000"));
    }
}
