package com.leetcode.offer.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        final int row = matrix.length;
        final int col = matrix[0].length;
        final List<Integer> list = new ArrayList<>(row * col);
        int start = 0;
        while (col > start * 2 && row > start * 2) {
            int endX = col - 1 - start;
            int endY = row - 1 - start;
            for (int i = start; i <= endX; i++) {
                list.add(matrix[start][i]);
            }
            if (start < endY) {
                for (int i = start + 1; i <= endY; i++) {
                    list.add(matrix[i][endX]);
                }
            }
            if (start < endX && start < endY) {
                for (int i = endX - 1; i >= start; --i) {
                    list.add(matrix[endY][i]);
                }
            }
            if (start < endX && start < endY - 1) {
                for (int i = endY - 1; i >= start + 1; --i) {
                    list.add(matrix[i][start]);
                }
            }
            start++;
        }
        return list;
    }


    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        int[][] matrix2 = new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };
        System.out.println(spiralOrder.spiralOrder(matrix2));
    }
}
