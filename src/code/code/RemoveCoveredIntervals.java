package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * <p>
 * 只有当?c <= a?且?b <= d?时，我们才认为区间?[a,b) 被区间?[c,d) 覆盖。
 * <p>
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * ?
 * <p>
 * 提示：??????
 * <p>
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] <?intervals[i][1] <= 10^5
 * 对于所有的?i != j：intervals[i] != intervals[j]
 * 通过次数2,444提交次数4,355
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-covered-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 1;
        int r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (r < intervals[i][1]) {
                r = intervals[i][1];
                count++;
            }
        }
        return count;
    }
}
