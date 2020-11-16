package code.code;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author duson
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,1,3,6]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[2,1,2,6]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 示例 4：
 * <p>
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 30000
 * A.length 为偶数
 * -100000 <= A[i] <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanReorderDoubled {

    public boolean canReorderDoubled(int[] aa) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : aa) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        for (int x : count.keySet()) {
            if (count.get(x) == 0) {
                continue;
            }
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0)) {
                return false;
            }
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }
}
