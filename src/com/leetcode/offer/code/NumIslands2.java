package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 假设你设计一个游戏，用一个 m 行 n 列的 2D 网格来存储你的游戏地图。
 * <p>
 * 起始的时候，每个格子的地形都被默认标记为「水」。我们可以通过使用 addLand 进行操作，将位置 (row, col) 的「水」变成「陆地」。
 * <p>
 * 你将会被给定一个列表，来记录所有需要被操作的位置，然后你需要返回计算出来 每次 addLand 操作后岛屿的数量。
 * <p>
 * 注意：一个岛的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。
 * <p>
 * 请仔细阅读下方示例与解析，更加深入了解岛屿的判定。
 * <p>
 * 示例:
 * <p>
 * 输入: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * 输出: [1,1,2,3]
 * 解析:
 * <p>
 * 起初，二维网格 grid 被全部注入「水」。（0 代表「水」，1 代表「陆地」）
 * <p>
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * 操作 #1：addLand(0, 0) 将 grid[0][0] 的水变为陆地。
 * <p>
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * 操作 #2：addLand(0, 1) 将 grid[0][1] 的水变为陆地。
 * <p>
 * 1 1 0
 * 0 0 0   岛屿的数量为 1
 * 0 0 0
 * 操作 #3：addLand(1, 2) 将 grid[1][2] 的水变为陆地。
 * <p>
 * 1 1 0
 * 0 0 1   岛屿的数量为 2
 * 0 0 0
 * 操作 #4：addLand(2, 1) 将 grid[2][1] 的水变为陆地。
 * <p>
 * 1 1 0
 * 0 0 1   岛屿的数量为 3
 * 0 1 0
 * 拓展：
 * <p>
 * 你是否能在 O(k log mn) 的时间复杂度程度内完成每次的计算？（k 表示 positions 的长度）
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands2 {

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] arr = new int[m * n];
        int cur = 0;
        List<Integer> res = new ArrayList<>();
        Arrays.fill(arr, -1);
        for (int[] p : positions) {
            int sum = valid(p[0], p[1], m, n, arr);
            cur += sum;
            res.add(cur);
        }
        return res;
    }

    private int valid(int x, int y, int m, int n, int[] arr) {
        int idx = x * n + y;
        if (x < 0 || y < 0 || x >= m || y >= n || arr[idx] != -1) {
            return 0;
        }
        arr[idx] = idx;
        int sum = 1;
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                continue;
            }
            int idxx = xx * n + yy;
            if (arr[idxx] != -1) {
                if (union(arr, idx, idxx)) {
                    sum--;
                }
            }
        }
        return sum;
    }

    private int find(int[] arr, int a) {
        while (a != arr[a]) {
            arr[a] = arr[arr[a]];
            a = arr[a];
        }
        return a;

    }

    private boolean union(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        if (a > b) {
            arr[a] = b;
        } else {
            arr[b] = a;
        }
        return a != b;
    }
}
