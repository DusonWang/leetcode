package code.code;

/**
 * @author duson
 * 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。 
 * <p>
 * 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。 
 * <p>
 * 如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
 * <p>
 * 求移动结束后，“马” 仍留在棋盘上的概率。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: 3, 2, 0, 0
 * 输出: 0.0625
 * 解释:
 * 输入的数据依次为 N, K, r, c
 * 第 1 步时，有且只有 2 种走法令 “马” 可以留在棋盘上（跳到（1,2）或（2,1））。对于以上的两种情况，各自在第2步均有且只有2种走法令 “马” 仍然留在棋盘上。
 * 所以 “马” 在结束后仍在棋盘上的概率为 0.0625。
 *  
 * <p>
 * 注意：
 * <p>
 * N 的取值范围为 [1, 25]
 * K 的取值范围为 [0, 100]
 * 开始时，“马” 总是位于棋盘上
 * 通过次数2,233提交次数4,879
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KnightProbability {

    private int[][] dir = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    private double[][][] dp;

    public double knightProbability(int n, int k, int r, int c) {
        dp = new double[n][n][k + 1];
        return find(n, k, r, c);
    }

    public double find(int n, int k, int r, int c) {
        if (r < 0 || r > n - 1 || c < 0 || c > n - 1) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[r][c][k] != 0) {
            return dp[r][c][k];
        }
        double rate = 0;
        for (int[] ints : dir) {
            rate += 0.125 * find(n, k - 1, r + ints[0], c + ints[1]);
        }
        dp[r][c][k] = rate;
        return rate;
    }
}
