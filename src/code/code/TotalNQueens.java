package code.code;

import java.util.Arrays;

/**
 * @author duson
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalNQueens {

    private boolean[] col = null;

    private boolean[] left = null;

    private boolean[] right = null;

    private int count = 0;

    public int totalNQueens(int n) {
        col = new boolean[n];
        left = new boolean[2 * n - 1];
        right = new boolean[2 * n - 1];
        count = 0;
        char[][] board = new char[n][n];
        backTrack(board, 0, n);
        return count;
    }

    private void backTrack(char[][] board, int r, int n) {
        if (r >= n) {
            count++;
            return;
        }
        Arrays.fill(board[r], '.');
        for (int i = 0; i < n; i++) {
            if (!col[i] && !left[r + i] && !right[r - i + n - 1]) {
                col[i] = true;
                left[r + i] = true;
                right[r - i + n - 1] = true;
                board[r][i] = 'Q';
                backTrack(board, r + 1, n);
                col[i] = false;
                board[r][i] = '.';
                left[r + i] = false;
                right[r - i + n - 1] = false;
            }
        }
    }

//    private int count2;
//
//    public int totalNQueens2(int n) {
//        count2 = 0;
//        dfs(n, 0, 0, 0, 0);
//        return count2;
//    }
//
//    private void dfs(int n, int row, int col, int pie, int na) {
//        if (row >= n) {
//            count2 += 1;
//            return;
//        }
//        int bits = (~(col | pie | na)) & ((1 << n) - 1);
//        while (bits > 0) {
//            int p = bits & -bits;
//            dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
//            bits = bits & (bits - 1);
//        }
//    }

    public static void main(String[] args) {
        TotalNQueens solveNQueens = new TotalNQueens();
        System.out.println(solveNQueens.totalNQueens(4));
    }
}
