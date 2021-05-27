package code.code;

import java.util.Arrays;

/**
 * 给定一个正整数、负整数和 0 组成的 N × M?矩阵，编写代码找出元素总和最大的子矩阵。
 * <p>
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * ?  [-1,0],
 * ?  [0,-1]
 * ]
 * 输出：[0,1,0,1]
 * 解释：输入中标粗的元素即为输出所表示的矩阵
 * ?
 * <p>
 * 说明：
 * <p>
 * 1 <= matrix.length, matrix[0].length <= 200
 * 通过次数6,435提交次数12,537
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-submatrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetMaxMatrix {

    public int[] getSubArrayMaxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int x1 = 0;
        int x2 = 0;
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur == 0) {
                begin = i;
            }
            cur += nums[i];
            if (cur > max) {
                x2 = i;
                x1 = begin;
                max = cur;
            }
            cur = Math.max(cur, 0);
        }
        return new int[]{max, x1, x2};
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] sum = new int[cols];
        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        int x1 = 0;
        int x2 = 0;
        for (int i = 0; i < rows; i++) {
            Arrays.fill(sum, 0);
            for (int j = i; j < rows; j++) {
                for (int col = 0; col < cols; col++) {
                    sum[col] += matrix[j][col];
                }
                int[] flags = getSubArrayMaxSum(sum);
                if (max < flags[0]) {
                    x = i;
                    x1 = j;
                    y = flags[1];
                    x2 = flags[2];
                    max = flags[0];
                }
            }
        }
        return new int[]{x, y, x1, x2};
    }

    public static void main(String[] args) {
        GetMaxMatrix getMaxMatrix = new GetMaxMatrix();
        System.out.println(Arrays.toString(getMaxMatrix.getMaxMatrix(new int[][]{{-1, 0}, {0, -1}})));
    }
}
