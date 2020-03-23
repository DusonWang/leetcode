package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个非负整数数组 A，如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为正方形数组。
 * <p>
 * 返回 A 的正方形排列的数目。两个排列 A1 和 A2 不同的充要条件是存在某个索引 i，使得 A1[i] != A2[i]。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,17,8]
 * 输出：2
 * 解释：
 * [1,8,17] 和 [17,8,1] 都是有效的排列。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 12
 * 0 <= A[i] <= 1e9
 * 通过次数1,355提交次数3,037
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-squareful-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSquarefulPerms {

    private int res = 0;
    private boolean[] visited;

    public int numSquarefulPerms(int[] a) {
        Arrays.sort(a);
        visited = new boolean[a.length];
        dfs(a, -1, 0);
        return res;
    }

    private void dfs(int[] a, int pre, int cnt) {
        if (cnt == a.length) {
            res++;
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (visited[i] || (i != 0 && !visited[i - 1] && a[i] == a[i - 1]) || (pre != -1 && !isSquare(pre + a[i]))) {
                continue;
            }
            visited[i] = true;
            dfs(a, a[i], cnt + 1);
            visited[i] = false;
        }
    }

    private boolean isSquare(int num) {
        int val = (int) Math.sqrt(num);
        return val * val == num;
    }
}
