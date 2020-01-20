package com.leetcode.offer.code;

/**
 * @author duson
 * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 * <p>
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 * <p>
 * 示例1:
 * <p>
 * 输入: 2
 * 输出: 2
 * 解释:
 * <p>
 * 第 1 个优美的排列是 [1, 2]:
 * 第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
 * 第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
 * <p>
 * 第 2 个优美的排列是 [2, 1]:
 * 第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
 * 第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
 * 说明:
 * <p>
 * N 是一个正整数，并且不会超过15。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/beautiful-arrangement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountArrangement {

    public int countArrangement(int n) {
        dfs(n, n, new boolean[n + 1]);
        return count;
    }

    private int count = 0;

    private void dfs(int n, int k, boolean[] visited) {
        if (k == 0) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] || k % i != 0 && i % k != 0) {
                continue;
            }
            visited[i] = true;
            dfs(n, k - 1, visited);
            visited[i] = false;
        }
    }
}
