package com.leetcode.offer.day9;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int cols = matrix[0].length;
        int[] leftLessMin = new int[cols];
        int[] rightLessMin = new int[cols];
        Arrays.fill(leftLessMin, -1);
        Arrays.fill(rightLessMin, cols);
        int[] heights = new int[cols];
        for (char[] chars : matrix) {
            for (int col = 0; col < cols; col++) {
                if (chars[col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            int boundary = -1;
            for (int col = 0; col < cols; col++) {
                if (chars[col] == '1') {
                    leftLessMin[col] = Math.max(leftLessMin[col], boundary);
                } else {
                    leftLessMin[col] = -1;
                    boundary = col;
                }
            }
            boundary = cols;
            for (int col = cols - 1; col >= 0; col--) {
                if (chars[col] == '1') {
                    rightLessMin[col] = Math.min(rightLessMin[col], boundary);
                } else {
                    rightLessMin[col] = cols;
                    boundary = col;
                }
            }
            for (int col = cols - 1; col >= 0; col--) {
                int area = (rightLessMin[col] - leftLessMin[col] - 1) * heights[col];
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int maxarea = 0;
        int[] dp = new int[matrix[0].length];
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = chars[j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, findMaxArea(dp));
        }

        return maxarea;
    }

    private int findMaxArea(int[] heights) {
        int maxarea = 0;
        int[] stack = new int[heights.length + 1];
        int top = -1;
        stack[++top] = -1;
        for (int i = 0; i < heights.length; i++) {
            while (stack[top] != -1 && heights[stack[top]] > heights[i]) {
                maxarea = Math.max(maxarea, heights[stack[top--]] * (i - stack[top] - 1));
            }
            stack[++top] = i;
        }

        while (stack[top] != -1) {
            maxarea = Math.max(maxarea, heights[stack[top--]] * (heights.length - stack[top] - 1));
        }

        return maxarea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle2(matrix));
    }
}
