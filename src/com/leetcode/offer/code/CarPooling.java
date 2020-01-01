package com.leetcode.offer.code;

/**
 * @author duson
 * 假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
 * <p>
 * 这儿有一份行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了你的第 i 次行程信息：
 * <p>
 * 必须接送的乘客数量；
 * 乘客的上车地点；
 * 以及乘客的下车地点。
 * 这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
 * <p>
 * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所用乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：trips = [[2,1,5],[3,5,7]], capacity = 3
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设乘客会自觉遵守 “先下后上” 的良好素质
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/car-pooling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] cnt = new int[1001];
        for (int[] trip : trips) {
            cnt[trip[1]] += trip[0];
            cnt[trip[2]] -= trip[0];
        }
        if (cnt[0] > capacity) {
            return false;
        }
        for (int i = 1; i < 1001; ++i) {
            cnt[i] += cnt[i - 1];
            if (cnt[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
