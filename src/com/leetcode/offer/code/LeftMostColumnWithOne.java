package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 * （这是一个交互题）
 * <p>
 * 我们称只包含元素?0?或?1?的矩阵为二进制矩阵。矩阵中每个单独的行都按非递减顺序排序。
 * <p>
 * 给定一个这样的二进制矩阵，返回至少包含一个?1?的最左端列的索引（从 0 开始）。如果这样的列不存在，返回?-1。
 * <p>
 * 您不能直接访问该二进制矩阵。你只可以通过?BinaryMatrix?接口来访问。
 * <p>
 * BinaryMatrix.get(row, col)?返回位于索引?(row, col)?（从 0 开始）的元素。
 * BinaryMatrix.dimensions()?返回含有 2 个元素的列表?[rows, cols]，表示这是一个?rows *?cols的矩阵。
 * 如果提交的答案调用?BinaryMatrix.get?超过 1000 次，则该答案会被判定为错误答案。提交任何试图规避判定机制的答案将会被取消资格。
 * <p>
 * 下列示例中，?mat?为给定的二进制矩阵。您不能直接访问该矩阵。
 * <p>
 * ?
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[0,0],[1,1]]
 * 输出: 0
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[0,0],[0,1]]
 * 输出: 1
 * 示例 3:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[0,0],[0,0]]
 * 输出: -1
 * 示例 4:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * 输出: 1
 * ?
 * <p>
 * 提示:
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols?<= 100
 * mat[i][j]?只会是?0?或?1。
 * mat[i]?已按非递减顺序排序。
 * 通过次数95提交次数129
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leftmost-column-with-at-least-a-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeftMostColumnWithOne {

    static class BinaryMatrix {
        public int get(int row, int col) {
            return 0;
        }

        public List<Integer> dimensions() {
            return null;
        }
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int n = dimension.get(0);
        int m = dimension.get(1);
        int i = n - 1, j = m - 1, res = -1;
        while (i >= 0 && j >= 0) {
            int cur = binaryMatrix.get(i, j);
            if (cur == 0) {
                i--;
            } else {
                res = j;
                j--;
            }
        }
        return res;
    }
}
