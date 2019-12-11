package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * <p>
 * 有 N 个网络节点，标记为 1 到 N。
 * <p>
 * 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * <p>
 * 注意:
 * <p>
 * N 的范围在 [1, 100] 之间。
 * K 的范围在 [1, N] 之间。
 * times 的长度在 [1, 6000] 之间。
 * 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] leastTimes = new int[n + 1];
        Arrays.fill(leastTimes, Integer.MAX_VALUE);
        leastTimes[k] = 0;

        for (int i = 0; i < n; i++) {
            for (int[] time : times) {
                int u = time[0], v = time[1], t = time[2];
                if (leastTimes[u] != Integer.MAX_VALUE && leastTimes[v] > leastTimes[u] + t) {
                    leastTimes[v] = leastTimes[u] + t;
                }
            }
        }

        int delay = 0;
        for (int i = 1; i <= n; i++) {
            if (leastTimes[i] == Integer.MAX_VALUE) {
                return -1;
            }
            if (delay < leastTimes[i]) {
                delay = leastTimes[i];
            }
        }
        return delay;
    }
}
