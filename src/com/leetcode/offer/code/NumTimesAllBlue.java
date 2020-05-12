package com.leetcode.offer.code;

/**
 * @author duson
 * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
 * <p>
 * 在 k? 时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
 * <p>
 * 灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
 * <p>
 * 灯处于打开状态。
 * 排在它之前（左侧）的所有灯也都处于打开状态。
 * 请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：light = [2,1,3,5,4]
 * 输出：3
 * 解释：所有开着的灯都变蓝的时刻分别是 1，2 和 4 。
 * 示例 2：
 * <p>
 * 输入：light = [3,2,4,1,5]
 * 输出：2
 * 解释：所有开着的灯都变蓝的时刻分别是 3 和 4（index-0）。
 * 示例 3：
 * <p>
 * 输入：light = [4,1,2,3]
 * 输出：1
 * 解释：所有开着的灯都变蓝的时刻是 3（index-0）。
 * 第 4 个灯在时刻 3 变蓝。
 * 示例 4：
 * <p>
 * 输入：light = [2,1,4,3,6,5]
 * 输出：3
 * 示例 5：
 * <p>
 * 输入：light = [1,2,3,4,5,6]
 * 输出：6
 * ?
 * <p>
 * 提示：
 * <p>
 * n ==?light.length
 * 1 <= n <= 5 * 10^4
 * light 是 [1, 2, ..., n] 的一个排列。
 * 通过次数4,677提交次数9,332
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulb-switcher-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumTimesAllBlue {

    public int numTimesAllBlue(int[] light) {
        int i = 1;
        int expectedSum = 0;
        int actualSum = 0;
        int ans = 0;
        for (int num : light) {
            actualSum += num;
            expectedSum += i;
            if (actualSum == expectedSum) {
                ans++;
            }
            i++;
        }
        return ans;
    }
}
