package code.code;

/**
 * 给你一个整数?n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 987
 * 输出："987"
 * 示例 2：
 * <p>
 * 输入：n = 1234
 * 输出："1.234"
 * 示例 3：
 * <p>
 * 输入：n = 123456789
 * 输出："123.456.789"
 * 示例 4：
 * <p>
 * 输入：n = 0
 * 输出："0"
 * ?
 * <p>
 * 提示：
 * <p>
 * 0 <= n < 2^31
 * 通过次数8,292提交次数14,133
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/thousand-separator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThousandSeparator {

    public String thousandSeparator(int n) {
        int count = 0;
        StringBuilder ans = new StringBuilder();
        do {
            int cur = n % 10;
            n /= 10;
            ans.append(cur);
            ++count;
            if (count % 3 == 0 && n != 0) {
                ans.append('.');
            }
        } while (n != 0);
        ans.reverse();
        return ans.toString();
    }
}
