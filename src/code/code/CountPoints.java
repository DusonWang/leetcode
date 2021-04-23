package code.code;

/**
 * 给你一个数组?points?，其中?points[i] = [xi, yi]?，表示第?i?个点在二维平面上的坐标。多个点可能会有 相同?的坐标。
 * <p>
 * 同时给你一个数组?queries?，其中?queries[j] = [xj, yj, rj]?，表示一个圆心在?(xj, yj)?且半径为?rj?的圆。
 * <p>
 * 对于每一个查询?queries[j]?，计算在第 j?个圆 内?点的数目。如果一个点在圆的 边界上?，我们同样认为它在圆?内?。
 * <p>
 * 请你返回一个数组?answer?，其中?answer[j]是第?j?个查询的答案。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * 输出：[3,2,2]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * 输出：[2,3,2,4]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 500
 * points[i].length == 2
 * 0 <= x??????i, y??????i <= 500
 * 1 <= queries.length <= 500
 * queries[j].length == 3
 * 0 <= xj, yj <= 500
 * 1 <= rj <= 500
 * 所有的坐标都是整数。
 * 通过次数3,677提交次数4,145
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPoints {

    public int[] countPoints(int[][] points, int[][] queries) {
        int n2 = queries.length;
        int[] res = new int[n2];
        for (int i = 0; i < n2; i++) {
            for (int[] point : points) {
                if (isInCircle(queries[i][2], queries[i][0], queries[i][1], point[0], point[1])) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    private boolean isInCircle(double r, double x1, double y1, double x2, double y2) {
        double dist = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return dist <= r;
    }
}
