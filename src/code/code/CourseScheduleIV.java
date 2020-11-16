package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 你总共需要上 n?门课，课程编号依次为 0?到 n-1?。
 * <p>
 * 有的课会有直接的先修课程，比如如果想上课程?0 ，你必须先上课程 1 ，那么会以 [1,0]?数对的形式给出先修课程数对。
 * <p>
 * 给你课程总数 n?和一个直接先修课程数对列表?prerequisite 和一个查询对列表?queries?。
 * <p>
 * 对于每个查询对 queries[i]?，请判断?queries[i][0]?是否是?queries[i][1]?的先修课程。
 * <p>
 * 请返回一个布尔值列表，列表中每个元素依次分别对应 queries?每个查询对的判断结果。
 * <p>
 * 注意：如果课程?a?是课程?b?的先修课程且课程?b?是课程?c?的先修课程，那么课程?a?也是课程?c?的先修课程。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * 输出：[false,true]
 * 解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。
 * 示例 2：
 * <p>
 * 输入：n = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * 输出：[false,false]
 * 解释：没有先修课程对，所以每门课程之间是独立的。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * 输出：[true,true]
 * 示例 4：
 * <p>
 * 输入：n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
 * 输出：[false,true]
 * 示例 5：
 * <p>
 * 输入：n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
 * 输出：[true,false,true,false]
 * ?
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 0 <= prerequisite.length <= (n * (n - 1) / 2)
 * 0 <= prerequisite[i][0], prerequisite[i][1] < n
 * prerequisite[i][0] != prerequisite[i][1]
 * 先修课程图中没有环。
 * 先修课程图中没有重复的边。
 * 1 <= queries.length <= 10^4
 * queries[i][0] != queries[i][1]
 * 通过次数1,422提交次数4,036
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        for (int[] p : prerequisites) {
            connected[p[0]][p[1]] = true;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    connected[i][j] = connected[i][j] || connected[i][k] && connected[k][j];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(connected[q[0]][q[1]]);
        }
        return ans;
    }
}
