package code.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * <p>
 * (注：分数越高的选手，排名越靠前。)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 * <p>
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] tmp = Arrays.copyOf(nums, len);
        Arrays.sort(tmp);
        Map<Integer, String> map = new HashMap<>();
        String s;
        for (int i = len - 1, m = 0; i >= 0; i--, m++) {
            if (m == 0) {
                s = "Gold Medal";
            } else if (m == 1) {
                s = "Silver Medal";
            } else if (m == 2) {
                s = "Bronze Medal";
            } else {
                s = String.valueOf(m + 1);
            }
            map.put(tmp[i], s);
        }
        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            strings[i] = map.get(nums[i]);
        }
        return strings;
    }
}
