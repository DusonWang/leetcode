package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个2行 n 列的二进制数组：
 * <p>
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是0就是1。
 * 第 0 行的元素之和为upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为colsum[i]，colsum是一个长度为n的整数数组。
 * 你需要利用upper，lower和colsum来重构这个矩阵，并以二维整数数组的形式返回它。
 * <p>
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 * <p>
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 * 解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
 * 示例 2：
 * <p>
 * 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * 输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 * 通过次数4,863提交次数12,360
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReconstructMatrix {

    public List<List<Integer>> reconstructMatrix(int u, int l, int[] cs) {
        boolean[][] res = new boolean[2][cs.length];
        for (int i = 0; i < cs.length; ++i) {
            res[0][i] = cs[i] == 2 || (cs[i] == 1 && l < u);
            res[1][i] = cs[i] == 2 || (cs[i] == 1 && !res[0][i]);
            u -= res[0][i] ? 1 : 0;
            l -= res[1][i] ? 1 : 0;
        }
        return l == 0 && u == 0 ? new ArrayList(Arrays.asList(res[0], res[1])) : new ArrayList<>();
    }
}
