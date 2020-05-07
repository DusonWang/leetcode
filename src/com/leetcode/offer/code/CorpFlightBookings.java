package com.leetcode.offer.code;

/**
 * @author duson
 * 这里有?n?个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 我们这儿有一份航班预订表，表中第?i?条预订记录?bookings[i] = [i, j, k]?意味着我们在从?i?到?j?的每个航班上预订了 k 个座位。
 * <p>
 * 请你返回一个长度为 n 的数组?answer，按航班编号顺序返回每个航班上预订的座位数。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 * 通过次数8,886提交次数20,355
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            counters[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                counters[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; ++i) {
            counters[i] += counters[i - 1];
        }
        return counters;
    }
}
