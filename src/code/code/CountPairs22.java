package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 * <p>
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 * 通过次数5,537提交次数21,845
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPairs22 {

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int answer = 0;
        for (int num : deliciousness) {
            int powerOfTwo = 1;
            for (int i = 0; i <= 21; i++) {
                if (powerOfTwo >= num) {
                    Integer value = map.get(powerOfTwo - num);
                    if (value != null) {
                        answer += value;
                        answer %= mod;
                    }
                }
                powerOfTwo *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        CountPairs22 countPairs22 = new CountPairs22();
        System.out.println(countPairs22.countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println(countPairs22.countPairs(new int[]{1048576, 1048576}));
    }
}
