package code.code;

/**
 * @author duson
 * 一个 N?x N的 board?仅由?0?和?1?组成?。每次移动，你能任意交换两列或是两行的位置。
 * <p>
 * 输出将这个矩阵变为 “棋盘” 所需的最小移动次数。“棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。如果不存在可行的变换，输出 -1。
 * <p>
 * 示例:
 * 输入: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
 * 输出: 2
 * 解释:
 * 一种可行的变换方式如下，从左到右：
 * <p>
 * 0110     1010     1010
 * 0110 --> 1010 --> 0101
 * 1001     0101     1010
 * 1001     0101     0101
 * <p>
 * 第一次移动交换了第一列和第二列。
 * 第二次移动交换了第二行和第三行。
 * <p>
 * <p>
 * 输入: board = [[0, 1], [1, 0]]
 * 输出: 0
 * 解释:
 * 注意左上角的格值为0时也是合法的棋盘，如：
 * <p>
 * 01
 * 10
 * <p>
 * 也是合法的棋盘.
 * <p>
 * 输入: board = [[1, 0], [1, 0]]
 * 输出: -1
 * 解释:
 * 任意的变换都不能使这个输入变为合法的棋盘。
 * ?
 * <p>
 * 提示：
 * <p>
 * board?是方阵，且行列数的范围是[2, 30]。
 * board[i][j]?将只包含?0或?1。
 * 通过次数649提交次数1,587
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/transform-to-chessboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovesToChessboard {

    public int movesToChessboard(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }
        int n = board.length;
        for (int[] ints : board) {
            for (int j = 0; j < n; ++j) {
                if ((board[0][0] ^ ints[0] ^ board[0][j] ^ ints[j]) == 1) {
                    return -1;
                }
            }
        }
        int rowSum = 0;
        int colSum = 0;
        int rowSwap = 0;
        int colSwap = 0;
        for (int i = 0; i < n; ++i) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) {
                ++rowSwap;
            }
            if (board[0][i] == i % 2) {
                ++colSwap;
            }
        }
        if (n / 2 > rowSum || n / 2 > (n - rowSum) ||
                n / 2 > colSum || n / 2 > (n - colSum)) {
            return -1;
        }
        if (n % 2 == 0) {
            rowSwap = Math.min(rowSwap, n - rowSwap);
            colSwap = Math.min(colSwap, n - colSwap);
        } else {
            if (colSwap % 2 == 1) {
                colSwap = n - colSwap;
            }
            if (rowSwap % 2 == 1) {
                rowSwap = n - rowSwap;
            }
        }
        return (rowSwap + colSwap) / 2;
    }
}
