package code.code;

/**
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与target 一致，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * 示例 3：
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] 和 target[i][j] 不是 0 就是 1
 * 通过次数4,210提交次数7,502
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/determine-whether-matrix-can-be-obtained-by-rotation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
        boolean b4 = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[n - j - 1][i] != target[i][j]) {
                    b1 = false;
                }
                if (mat[n - i - 1][n - j - 1] != target[i][j]) {
                    b2 = false;
                }
                if (mat[j][n - i - 1] != target[i][j]) {
                    b3 = false;
                }
                if (mat[i][j] != target[i][j]) {
                    b4 = false;
                }
            }
        }
        return b1 || b2 || b3 || b4;
    }

}
