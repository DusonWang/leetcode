package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * <p>
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,2,2]
 * 输出: true
 * <p>
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 * <p>
 * 输入: [3,3,3,3,4]
 * 输出: false
 * <p>
 * 解释: 不能用所有火柴拼成一个正方形。
 * 注意:
 * <p>
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Makesquare {

    public boolean makesquare(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[4];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0 || sum == 0) {
            return false;
        }
        int tar = sum / 4;
        Arrays.sort(nums);
        return dfs(nums, cnt, tar, n - 1);
    }

    private boolean dfs(int[] nums, int[] cnt, int tar, int id) {
        if (id == -1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (cnt[i] + nums[id] > tar) {
                continue;
            }
            cnt[i] += nums[id];
            if (dfs(nums, cnt, tar, id - 1)) {
                return true;
            }
            cnt[i] -= nums[id];
        }
        return false;
    }
}
