package code.code;

/**
 * A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
 * <p>
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
 * <p>
 * You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
 * <p>
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[1,4],[3,2]]
 * Output: [0,1]
 * Explanation:Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * Output: [1,1]
 * Explanation:Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 500
 * 1 <= mat[i][j] <= 105
 * No two adjacent cells are equal.
 * 通过次数34提交次数54
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-a-peak-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPeakGrid {

    public int[] findPeakGrid(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[]{};
        }
        int i = 0;
        int j = 0;
        while (i < mat.length && j < mat[0].length) {
            if (i < mat.length - 1 && mat[i + 1][j] > mat[i][j]) {
                i++;
            } else if (j < mat[0].length - 1 && mat[i][j + 1] > mat[i][j]) {
                j++;
            } else if (i >= 1 && mat[i - 1][j] > mat[i][j]) {
                i--;
            } else if (j >= 1 && mat[i][j - 1] > mat[i][j]) {
                j--;
            } else {
                return new int[]{i, j};
            }
        }
        return new int[]{i, j};
    }

}
