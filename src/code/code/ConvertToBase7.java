package code.code;

/**
 * @author duson
 * <p>
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertToBase7 {

    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        int flag = num >= 0 ? 1 : -1;
        num = Math.abs(num);

        if (num == 0) {
            sb.append(0);
        }
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (flag < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

}
