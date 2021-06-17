package code.code;

/**
 * 给你一个二进制串s （一个只包含 0 和 1 的字符串），我们可以将 s分割成 3 个 非空字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
 * <p>
 * 请你返回分割s的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
 * <p>
 * 由于答案可能很大，请将它对 10^9 + 7 取余后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10101"
 * 输出：4
 * 解释：总共有 4 种方法将 s 分割成含有 '1' 数目相同的三个子字符串。
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * 示例 2：
 * <p>
 * 输入：s = "1001"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "0000"
 * 输出：3
 * 解释：总共有 3 种分割 s 的方法。
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * 示例 4：
 * <p>
 * 输入：s = "100100010100110"
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * s[i] == '0'或者s[i] == '1'
 * 3 <= s.length <= 10^5
 * 通过次数4,043提交次数13,820
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-split-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumWays {

    public int numWays(String s) {
        char[] sChar = s.toCharArray();
        int[] index = new int[sChar.length];
        int k = 0;
        int len = sChar.length;
        int oneNum = 0;
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == '1') {
                oneNum++;
                index[k++] = i;
            }
        }
        if (oneNum == 0) {
            return (int) ((long) (len - 1) * (len - 2) / 2 % (1000000007));
        }
        if (oneNum % 3 != 0) {
            return 0;
        }
        int partOneNum = oneNum / 3;
        return (int) ((long) (index[partOneNum] - index[partOneNum - 1]) * (index[2 * partOneNum] - index[2 * partOneNum - 1]) % (1000000007));
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays("10101"));
        System.out.println(numWays.numWays("100100010100110"));
    }
}
