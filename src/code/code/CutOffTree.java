package code.code;

import java.util.*;

/**
 * @author duson
 * 你被请来给一个要举办高尔夫比赛的树林砍树. 树林由一个非负的二维数组表示， 在这个数组中：
 * <p>
 * 0 表示障碍，无法触碰到.
 * 1 表示可以行走的地面.
 * 比1大的数 表示一颗允许走过的树的高度.
 * 你被要求按照树的高度从低向高砍掉所有的树，每砍过一颗树，树的高度变为1。
 * <p>
 * 你将从（0，0）点开始工作，你应该返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
 * <p>
 * 可以保证的是，没有两棵树的高度是相同的，并且至少有一颗树需要你砍。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,2,3],
 * [0,0,4],
 * [7,6,5]
 * ]
 * 输出: 6
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1,2,3],
 * [0,0,0],
 * [7,6,5]
 * ]
 * 输出: -1
 *  
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * [
 * [2,3,4],
 * [0,0,5],
 * [8,7,6]
 * ]
 * 输出: 6
 * <p>
 * 解释: (0,0) 位置的树，你可以直接砍去，不用算步数
 *  
 * <p>
 * 提示: 矩阵大小不会超过 50x50 。
 * <p>
 * 通过次数625提交次数1,868
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cut-off-trees-for-golf-event
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CutOffTree {

    private List<List<Integer>> forest;
    private int m;
    private int n;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int cutOffTree(List<List<Integer>> forest) {
        this.forest = forest;
        this.m = forest.size();
        this.n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int value = forest.get(r).get(c);
                if (value > 1) {
                    trees.add(new int[]{r, c, value});
                }
            }
        }
        trees.sort((a, b) -> a[2] - b[2]);
        int res = 0, sr = 0, sc = 0;
        for (int[] tree : trees) {
            int tr = tree[0], tc = tree[1];
            int d = dist(sr, sc, tr, tc);
            if (d < 0) {
                return -1;
            }
            res += d;
            sr = tree[0];
            sc = tree[1];
        }
        return res;
    }

    private int dist(int sr, int sc, int tr, int tc) {
        boolean[] seen = new boolean[m * n];
        Deque<int[]> deque = new LinkedList<>();
        deque.offerFirst(new int[]{sr, sc, 0});
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int count = curr[2], r = curr[0], c = curr[1];
            if (seen[r * n + c]) {
                continue;
            }
            seen[r * n + c] = true;
            if (r == tr && c == tc) {
                return Math.abs(sr - tr) + Math.abs(sc - tc) + 2 * count;
            }
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                boolean flag;
                if (k <= 1) {
                    flag = k == 0 ? r > tr : r < tr;
                } else {
                    flag = k == 2 ? c > tc : c < tc;
                }
                if (0 <= nr && nr < m && 0 <= nc && nc < n && forest.get(nr).get(nc) > 0) {
                    if (flag) {
                        deque.offerFirst(new int[]{nr, nc, count});
                    } else {
                        deque.offerLast(new int[]{nr, nc, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}
