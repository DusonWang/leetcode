package code.code;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * 示例2:
 * <p>
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * 提示：
 * <p>
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 * 通过次数2,996提交次数5,602
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/route-between-nodes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWhetherExistsPath {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] dp = new boolean[n];
        for(int[] i : graph){
            if(i[0] == start){
                dp[i[1]] = true;
            }
        }
        for(int[] i : graph){
            if(dp[i[0]]){
                dp[i[1]] = true;
            }
        }
        return dp[target];
    }
}
