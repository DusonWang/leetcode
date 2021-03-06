package code.code;

/**
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * <p>
 * 最开始，他在周一的时候存入 1?块钱。从周二到周日，他每天都比前一天多存入 1?块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1?块钱。
 * <p>
 * 给你?n?，请你返回在第 n?天结束的时候他在力扣银行总共存了多少块钱。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * 示例 3：
 * <p>
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 通过次数5,740提交次数8,418
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalMoney {

    public int totalMoney(int n) {
        int result = 0;
        int count = 0;
        while (n / 7 != 0) {
            count++;
            result += 7 * count + 21;
            n = n - 7;
        }
        if (n % 7 != 0) {
            count++;
            for (int i = 0; i < n % 7; i++) {
                result += count;
                count++;
            }
        }
        return result;
    }
}
