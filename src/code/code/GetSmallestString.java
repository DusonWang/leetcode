package code.code;

/**
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 * <p>
 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 * <p>
 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 * <p>
 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 * <p>
 * x 是 y 的一个前缀；
 * 如果 i 是x[i] != y[i] 的第一个位置，且 x[i]在字母表中的位置比y[i]靠前。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 27
 * 输出："aay"
 * 解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
 * 示例 2：
 * <p>
 * 输入：n = 5, k = 73
 * 输出："aaszz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * n <= k <= 26 * n
 * 通过次数6,917提交次数12,138
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetSmallestString {

    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = 'a';
        }
        k -= n;
        int i = n - 1;
        while (k > 0) {
            int min = Math.min(k, 25);
            result[i--] += min;
            k -= min;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        GetSmallestString getSmallestString = new GetSmallestString();
        System.out.println(getSmallestString.getSmallestString(3, 27));
    }
}
