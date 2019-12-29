package com.leetcode.offer.code;

import java.util.PriorityQueue;

/**
 * @author duson
 * 为了装修新房，你需要加工一些长度为正整数的棒材 sticks。
 * <p>
 * 如果要将长度分别为 X 和 Y 的两根棒材连接在一起，你需要支付 X + Y 的费用。 由于施工需要，你必须将所有棒材连接成一根。
 * <p>
 * 返回你把所有棒材 sticks 连成一根所需要的最低费用。注意你可以任意选择棒材连接的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：sticks = [2,4,3]
 * 输出：14
 * 解释：先将 2 和 3 连接成 5，花费 5；再将 5 和 4 连接成 9；总花费为 14。
 * 示例 2：
 * <p>
 * 输入：sticks = [1,8,3,5]
 * 输出：30
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= sticks.length <= 10^4
 * 1 <= sticks[i] <= 10^4
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-to-connect-sticks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConnectSticks {

    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.add(stick);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            Integer first = queue.poll();
            if (queue.isEmpty()) {
                break;
            }
            int second = queue.poll();
            int sum = first + second;
            ans += sum;
            queue.add(sum);
        }
        return ans;
    }
}
