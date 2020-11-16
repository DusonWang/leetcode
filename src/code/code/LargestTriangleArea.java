package code.code;

/**
 * @author duson
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * <p>
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 * <p>
 * <p>
 * 注意:
 * <p>
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 *  -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-triangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i <= points.length - 1; i++) {
            for (int j = i + 1; j <= points.length - 1; j++) {
                for (int k = j + 1; k <= points.length - 1; k++) {
                    //S = |(x1 · y2 - x2 · y1) + (x2 · y3 - x3 · y2) + (x3 · y1 - x1 · y3)| / 2
                    double temp = (points[i][0] * points[j][1] - points[j][0] * points[i][1])
                            + (points[j][0] * points[k][0] - points[k][0] * points[j][1])
                            + (points[k][0] * points[i][1] - points[i][0] * points[k][1]);
                    temp = Math.abs(temp);
                    if (0.5 * temp > ans) {
                        ans = 0.5 * temp;
                    }
                }
            }
        }
        return ans;
    }
}
