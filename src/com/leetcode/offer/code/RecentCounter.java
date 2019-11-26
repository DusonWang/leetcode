package com.leetcode.offer.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * <p>
 * 写一个 RecentCounter 类来计算最近的请求。
 * <p>
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 * <p>
 * 返回从 3000 毫秒前到现在的 ping 数。
 * <p>
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 * <p>
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * 输出：[null,1,2,3,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个测试用例最多调用 10000 次 ping。
 * 每个测试用例会使用严格递增的 t 值来调用 ping。
 * 每次调用 ping 都有 1 <= t <= 10^9。
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
