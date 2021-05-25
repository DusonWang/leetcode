package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 这里有?d?个一样的骰子，每个骰子上都有?f?个面，分别标号为?1, 2, ..., f。
 * <p>
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 * <p>
 * 如果需要掷出的总点数为?target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模?10^9 + 7?后返回。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：d = 1, f = 6, target = 3
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：d = 2, f = 6, target = 7
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：d = 2, f = 5, target = 10
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：d = 1, f = 2, target = 3
 * 输出：0
 * 示例 5：
 * <p>
 * 输入：d = 30, f = 30, target = 500
 * 输出：222616187
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 * 通过次数7,441提交次数15,610
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumRollsToTarget {

    private int MOD = 1000000000 + 7;
    private Map<String, Integer> memo = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {
        if (d == 0 && target == 0) {
            return 1;
        }
        if (d == 0 || target == 0) {
            return 0;
        }
        String str = d + " " + target;
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (target >= i) {
                res = (res + numRollsToTarget(d - 1, f, target - i)) % MOD;
            } else {
                break;
            }
        }
        memo.put(str, res);
        return res;
    }
}
