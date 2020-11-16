package code.code;

/**
 * @author duson
 * <p>
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 * <p>
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出："110"
 * 解释：(-2) ^ 2 + (-2) ^ 1 = 2
 * 示例 2：
 * <p>
 * 输入：3
 * 输出："111"
 * 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * 示例 3：
 * <p>
 * 输入：4
 * 输出："100"
 * 解释：(-2) ^ 2 = 4
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= N <= 10^9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-to-base-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BaseNeg2 {

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        String result = "";
        while (n != 0) {
            if (n % 2 == 0) {
                result = "0" + result;
                n = n / (-2);
            } else {
                result = "1" + result;
                n = (n - 1) / (-2);
            }
        }
        return result;
    }
}
