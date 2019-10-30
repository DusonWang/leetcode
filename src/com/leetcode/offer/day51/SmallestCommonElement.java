package com.leetcode.offer.day51;

/**
 * @author duson
 * 给你一个矩阵 mat，其中每一行的元素都已经按 递增 顺序排好了。请你帮忙找出在所有这些行中 最小的公共元素。
 * <p>
 * 如果矩阵中没有这样的公共元素，就请返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= mat.length, mat[i].length <= 500
 * 1 <= mat[i][j] <= 10^4
 * mat[i] 已按递增顺序排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-common-element-in-all-rows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestCommonElement {

    public int smallestCommonElement(int[][] mat) {
        int[] map = new int[10001];
        int line = 0;
        for (int[] m : mat) {
            for (int mm : m) {
                if (map[mm] == line) {
                    map[mm]++;
                }
            }
            line++;
        }

        int maxValue = Integer.MAX_VALUE;
        for (int m : mat[0]) {
            if (map[m] == mat.length) {
                if (m < maxValue) {
                    maxValue = m;
                }
            }
        }
        return maxValue == Integer.MAX_VALUE ? -1 : maxValue;
    }
}
