package code.code;

/**
 * @author duson
 * 给你一个 2D 矩阵 matrix，请计算出从左上角 (row1, col1) 到右下角 (row2, col2) 组成的矩形中所有元素的和。
 * <p>
 * <p>
 * 上述粉色矩形框内的，该矩形由左上角 (row1, col1) = (2, 1) 和右下角 (row2, col2) = (4, 3) 确定。其中，所包括的元素总和 sum = 8。
 * <p>
 * 示例：
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 *  
 * <p>
 * 注意:
 * <p>
 * 矩阵 matrix 的值只能通过 update 函数来进行修改
 * 你可以默认 update 函数和 sumRegion 函数的调用次数是均匀分布的
 * 你可以默认 row1 ≤ row2，col1 ≤ col2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void update(int row, int col, int val) {
        int len = matrix.length;
        if (row >= len) {
            return;
        }
        int colLen = matrix[0].length;
        if (col >= colLen) {
            return;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        //System.out.println(numMatrix.sumRegion(0,0,0,0));
        System.out.println(numMatrix.sumRegion(0, 1, 0, 1));
        System.out.println(numMatrix.sumRegion(0, 0, 0, 1));

        numMatrix.update(0, 0, 3);
        numMatrix.update(0, 1, 5);
        System.out.println(numMatrix.sumRegion(0, 1, 0, 1));


    }
}
