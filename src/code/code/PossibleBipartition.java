package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定一组?N?人（编号为?1, 2, ..., N），?我们想把每个人分进任意大小的两组。
 * <p>
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 * <p>
 * 当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * <p>
 * 输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * 对于?dislikes[i] == dislikes[j]?不存在?i != j?
 * 通过次数2,193提交次数6,082
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/possible-bipartition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            g[d[0]].add(d[1]);
            g[d[1]].add(d[0]);
        }
        int[] cl = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (cl[i] == 0 && !dfs(g, cl, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] g, int[] cl, int i, int c) {
        cl[i] = c;
        for (int j : g[i]) {
            if (cl[j] == c) {
                return false;
            }
            if (cl[j] == 0 && !dfs(g, cl, j, -c)) {
                return false;
            }
        }
        return true;
    }
}
