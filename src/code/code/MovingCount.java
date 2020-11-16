package code.code;

/**
 * @author duson
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k?<= 20
 * 通过次数35,124提交次数72,938
 * 在真实的面试中遇到过这道题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount {

    private int counts = 0;

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        helper(visited, 0, 0, m - 1, n - 1, k);
        return counts;
    }

    private void helper(int[][] visited, int i, int j, int m, int n, int k) {
        if (i <= m && j <= n && visited[i][j] != 1 && indexSum(i) + indexSum(j) <= k) {
            counts++;
            visited[i][j] = 1;
            helper(visited, i + 1, j, m, n, k);
            helper(visited, i, j + 1, m, n, k);
        }
    }

    private int indexSum(int index) {
        int sum = index % 10;
        int tmp = index / 10;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }

}
