package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给你一个整数?n?，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于??n?的 最简?分数?。分数可以以 任意?顺序返回。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * 示例 4：
 * <p>
 * 输入：n = 1
 * 输出：[]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 通过次数2,089提交次数3,513
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplified-fractions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                if (!isMaxCommonDivisor(i, j) || j == 1) {
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    private boolean isMaxCommonDivisor(int i, int j) {
        if (i < j) {
            int temp = i;
            i = j;
            j = temp;
        }
        if (j == 1) {
            return false;
        }
        if (i % j == 0) {
            return true;
        } else {
            return isMaxCommonDivisor(j, i % j);
        }
    }
}
