package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixii {

    public int[][] generateMatrix(int n) {
        final int[][] matrix = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                matrix[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                matrix[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        return matrix;
    }

    public int[][] generateMatrixReverse(int n) {
        if (n < 2) {
            return new int[][]{};
        }
        final int[][] matrix = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = t; i <= b; i++) {
                matrix[i][l] = num++;
            }
            l++;
            for (int i = l; i <= r; i++) {
                matrix[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                matrix[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                matrix[t][i] = num++;
            }
            t++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixii spiralMatrixii = new SpiralMatrixii();
        for (int[] matrix : spiralMatrixii.generateMatrixReverse(4)) {
            System.out.println(Arrays.toString(matrix));
        }
    }
}
