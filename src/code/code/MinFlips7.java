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

    /**
     * 1. 滑动窗口
     * （1）思路
     * 对操作 1，将第一个字符移动到字符串结尾，等效于先将 s 首尾相接构造一个长度为 2 * len 的字符串，再通过长度为 len 的滑动窗口取最小值。
     * 因为最终得到的交替字符串只可能是 “0101010…” 或 “1010101…” 2 种情况，对这 2 种状态分别求解所需的操作次数即可。
     *
     *
     * public int minFlips(String s) {
     *         String ss = s + s;//先将s首尾相接构造一个长度为2*len的字符串，再通过长度为len的滑动窗口取最小值
     *         char[] str = ss.toCharArray();
     *         int len = s.length(), n = str.length, ans = Integer.MAX_VALUE;
     *         int[] op1 = new int[n + 1], op2 = new int[n + 1];//op1[i]、op2[i]表示构造得到"01010..."和"10101..."前i位的操作次数
     *         op1[0] = 0;
     *         op2[0] = 0;
     *         for (int i = 0; i < n; i++) {
     *             if ((i & 1) == (int)(str[i] - '0')) {//奇数位为1或偶数位为0
     *                 op1[i + 1] = op1[i];
     *                 op2[i + 1] = op2[i] + 1;
     *             } else {//奇数位为0或偶数位为1
     *                 op1[i + 1] = op1[i] + 1;
     *                 op2[i + 1] = op2[i];
     *             }
     *         }
     *         for (int i = len; i <= n; i++) {//移动长度为len的滑动窗口，取最小操作次数
     *             ans = Math.min(ans, op1[i] - op1[i - len]);
     *             ans = Math.min(ans, op2[i] - op2[i - len]);
     *         }
     *         return ans;
     *     }
     *
     * */


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
        System.out.println(minFlips7.minFlips("010"));
        System.out.println(minFlips7.minFlips("1110"));
        System.out.println(minFlips7.minFlips("111000"));
    }
}
