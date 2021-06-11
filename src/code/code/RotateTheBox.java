package code.code;

import java.util.Arrays;

/**
 * 给你一个m x n的字符矩阵box，它表示一个箱子的侧视图。箱子的每一个格子可能为：
 * <p>
 * '#'表示石头
 * '*'表示固定的障碍物
 * '.'表示空位置
 * 这个箱子被 顺时针旋转 90 度，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会影响障碍物的位置，同时箱子旋转不会产生惯性，也就是说石头的水平位置不会发生改变。
 * <p>
 * 题目保证初始时box中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
 * <p>
 * 请你返回一个n x m的矩阵，表示按照上述旋转后，箱子内的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：box = [["#",".","#"]]
 * 输出：[["."],
 * ["#"],
 * ["#"]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：box = [["#",".","*","."],
 * ["#","#","*","."]]
 * 输出：[["#","."],
 * ["#","#"],
 * ["*","*"],
 * [".","."]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：box = [["#","#","*",".","*","."],
 * ["#","#","#","*",".","."],
 * ["#","#","#",".","#","."]]
 * 输出：[[".","#","#"],
 * [".","#","#"],
 * ["#","#","*"],
 * ["#","*","."],
 * ["#",".","*"],
 * ["#",".","."]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == box.length
 * n == box[i].length
 * 1 <= m, n <= 500
 * box[i][j]只可能是'#'，'*'或者'.'。
 * 通过次数2,729提交次数4,453
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotating-the-box
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateTheBox {

    public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;
        char[][] rtn = new char[col][row];
        for (int m = 0; m < col; m++) {
            Arrays.fill(rtn[m], '.');
        }
        int last;
        for (int i = 0; i < row; ++i) {
            last = col - 1;
            for (int j = col - 1; j >= 0; --j) {
                if (box[i][j] == '*') {
                    last = j - 1;
                    rtn[j][row - 1 - i] = '*';
                } else if (box[i][j] == '#') {
                    rtn[last][row - 1 - i] = '#';
                    --last;
                }
            }
        }
        return rtn;
    }
}
