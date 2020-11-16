package code.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * 给定一个有 n 个整数的数组，你需要找到满足以下条件的三元组 (i, j, k) ：
 * <p>
 * 0 < i, i + 1 < j, j + 1 < k < n - 1
 * 子数组 (0, i - 1)，(i + 1, j - 1)，(j + 1, k - 1)，(k + 1, n - 1) 的和应该相等。
 * 这里我们定义子数组 (L, R) 表示原数组从索引为L的元素开始至索引为R的元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,1,2,1,2,1]
 * 输出: True
 * 解释:
 * i = 1, j = 3, k = 5.
 * sum(0, i - 1) = sum(0, 0) = 1
 * sum(i + 1, j - 1) = sum(2, 2) = 1
 * sum(j + 1, k - 1) = sum(4, 4) = 1
 * sum(k + 1, n - 1) = sum(6, 6) = 1
 *  
 * <p>
 * 注意:
 * <p>
 * 1 <= n <= 2000。
 * 给定数组中的元素会在 [-1,000,000, 1,000,000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitArray2 {

    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if (n < 7) {
            return false;
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int k = 5; k < n - 1; ++k) {
            int s = sum[n] - sum[k + 1];
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(k);
        }


        for (int i = 1; i < n - 5; ++i) {
            for (int j = i + 2; j < n - 3; ++j) {
                if (sum[i] - sum[0] == sum[j] - sum[i + 1]) {
                    int target = sum[i] - sum[0];
                    List<Integer> list = map.get(target);
                    if (list != null) {
                        for (int k : list) {
                            if (k > j + 1 && sum[k] - sum[j + 1] == target) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
