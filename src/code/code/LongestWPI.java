package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWPI {

    public int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                ans = i + 1;
            } else {
                map.putIfAbsent(sum, i);
                if (map.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - map.get(sum - 1));
                }
            }
        }
        return ans;
    }
}
