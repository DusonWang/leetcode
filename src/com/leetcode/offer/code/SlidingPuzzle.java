package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 示例：
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 * <p>
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        Set<String> visited = new HashSet<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        StringBuilder curr = new StringBuilder();
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                curr.append(ints[j]);
            }
        }
        if ("123450".equals(curr.toString())) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(curr.toString());
        visited.add(curr.toString());
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currStr = queue.poll();
                int index = 0;
                if (currStr != null) {
                    index = currStr.indexOf('0');
                }
                for (int[] dir : dirs) {
                    int m = index / col + dir[0];
                    int n = index % col + dir[1];
                    if (m >= 0 && m < row && n >= 0 && n < col) {
                        int nextIndex = m * col + n;
                        String nextStr = null;
                        if (currStr != null) {
                            nextStr = swap(currStr, index, nextIndex);
                        }
                        if ("123450".equals(nextStr)) {
                            return minLen;
                        }
                        if (!visited.contains(nextStr)) {
                            queue.add(nextStr);
                            visited.add(nextStr);
                        }
                    }
                }
            }
            minLen++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
}
