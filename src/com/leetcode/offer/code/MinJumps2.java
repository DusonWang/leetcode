package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author duson
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * <p>
 * 每一步，你可以从下标 i 跳到下标：
 * <p>
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * <p>
 * 注意：任何时候你都不能跳到数组外面。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 * <p>
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 * <p>
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * 示例 4：
 * <p>
 * 输入：arr = [6,1,9]
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * 通过次数1,265提交次数4,393
 * 在真实的面试中遇到过这道题？
 */
public class MinJumps2 {

    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indicesOfValue.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int i = q.poll();
                if (i == n - 1) {
                    return step;
                }
                List<Integer> next = indicesOfValue.get(arr[i]);
                next.add(i - 1);
                next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                next.clear();
            }
            step++;
        }
        return 0;
    }

    /**
     * 为了给刷题的同学一些奖励，力扣团队引入了一个弹簧游戏机。游戏机由 N 个特殊弹簧排成一排，编号为 0 到 N-1。初始有一个小球在编号 0 的弹簧处。若小球在编号为 i 的弹簧处，通过按动弹簧，可以选择把小球向右弹射 jump[i] 的距离，或者向左弹射到任意左侧弹簧的位置。也就是说，在编号为 i 弹簧处按动弹簧，小球可以弹向 0 到 i-1 中任意弹簧或者 i+jump[i] 的弹簧（若 i+jump[i]>=N ，则表示小球弹出了机器）。小球位于编号 0 处的弹簧时不能再向左弹。
     * <p>
     * 为了获得奖励，你需要将小球弹出机器。请求出最少需要按动多少次弹簧，可以将小球从编号 0 弹簧弹出整个机器，即向右越过编号 N-1 的弹簧。
     * <p>
     * 示例 1：
     * <p>
     * 输入：jump = [2, 5, 1, 1, 1, 1]
     * <p>
     * 输出：3
     * <p>
     * 解释：小 Z 最少需要按动 3 次弹簧，小球依次到达的顺序为 0 -> 2 -> 1 -> 6，最终小球弹出了机器。
     * <p>
     * 限制：
     * <p>
     * 1 <= jump.length <= 10^6
     * 1 <= jump[i] <= 10000
     * 通过次数2,314提交次数12,641
     * 在真实的面试中遇到过这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-xiao-tiao-yue-ci-shu
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minJump(int[] jump) {
        int[] dp = new int[jump.length];
        dp[jump.length - 1] = 1;
        for (int i = jump.length - 2; i >= 0; i--) {
            dp[i] = jump[i] + i >= jump.length ? 1 : dp[jump[i] + i] + 1;
            for (int j = i + 1; j < dp.length && dp[j] >= dp[i] + 1; j++) {
                dp[j] = dp[i] + 1;
            }
        }
        return dp[0];
    }
}
