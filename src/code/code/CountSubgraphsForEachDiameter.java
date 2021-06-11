package code.code;

import java.util.Arrays;

/**
 * 给你n个城市，编号为从1 到n。同时给你一个大小为n-1的数组edges，其中edges[i] = [ui, vi]表示城市ui和vi之间有一条双向边。题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵树。
 * <p>
 * 一棵子树是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。
 * <p>
 * 对于d从1 到n-1，请你找到城市间最大距离恰好为 d的所有子树数目。
 * <p>
 * 请你返回一个大小为n-1的数组，其中第d个元素（下标从 1 开始）是城市间 最大距离 恰好等于d的子树数目。
 * <p>
 * 请注意，两个城市间距离定义为它们之间需要经过的边的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[1,2],[2,3],[2,4]]
 * 输出：[3,4,0]
 * 解释：
 * 子树 {1,2}, {2,3} 和 {2,4} 最大距离都是 1 。
 * 子树 {1,2,3}, {1,2,4}, {2,3,4} 和 {1,2,3,4} 最大距离都为 2 。
 * 不存在城市间最大距离为 3 的子树。
 * 示例 2：
 * <p>
 * 输入：n = 2, edges = [[1,2]]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：n = 3, edges = [[1,2],[2,3]]
 * 输出：[2,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 15
 * edges.length == n-1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * 题目保证(ui, vi)所表示的边互不相同。
 * 通过次数1,593提交次数2,604
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-subtrees-with-max-distance-between-cities
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubgraphsForEachDiameter {

    /**
     * public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
     *         int[][] dist=new int[n][n]; //存储两点之间的距离
     *         for(int i=0; i<n; i++){
     *             Arrays.fill(dist[i], Integer.MAX_VALUE);
     *             //之后要求最小值 所以初始化成最大整数
     *             //其实初始化成任何一个大于等于n的数字都可以
     *             dist[i][i]=0;//本身到本身显然为0
     *         }
     *         int[] dp=new int[1<<(n)];
     *         //状态压缩存储 dp[j]表示子树j的最大距离
     *         //j表示成二进制，从右数第k位为1表示第k个节点在子集中否则不在
     *         for(int[] edge:edges){
     *             // 直接相连的两点之间距离显然为1
     *             dist[edge[0]-1][edge[1]-1]=1;
     *             dist[edge[1]-1][edge[0]-1]=1;
     *             // 直接相连的两点可以构成一棵子树 它们的最大距离为1
     *             dp[(1<<(edge[0]-1)) + (1<<(edge[1]-1))]=1;
     *         }
     *         // Floyed算法 求每两点之间的最短距离
     *         for(int k=0; k<n; k++){
     *             for(int i=0; i<n; i++){
     *                 for(int j=0; j<n; j++){
     *                     if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
     *                         dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
     *                     }
     *                 }
     *             }
     *         }
     *         // 把对j的循环放在外面
     *         // 因为显然如果子树A是子树B的一部分 jA<jB
     *         // 所以要把数字小的j全部求好了再去求数字大的j
     *         for(int j=1; j<dp.length; j++){
     *             // 以下我们从子树 j 扩展到子树 j+(1<<i)
     *             // 即把节点i加入到子树j中
     *             // 如果本身j就无法构成一棵子树（如果j表示的节点不能相互连通）
     *             // 那么也就没有必要继续了 所以continue
     *             if(dp[j]==0) continue;
     *             for(int i=0; i<n; i++){
     *                 // 如果节点i已经在子树j中 或者 j+(1<<i)已经被计算过了 就没必要算了
     *                 // 为什么它可能会已经被计算过呢？
     *                 // 因为 111=101+10=11+100 添加点的顺序不同 但是能得出同样的一棵子树
     *                 if(((1<<i)&j)!=0 || dp[j+(1<<i)]!=0) continue;
     *                 // 检查 j 子树中是否有和 i 直接相连的点
     *                 // 这其实是相对于子树（而不是某个节点的）的bfs
     *                 for(int k=0; k<n; k++){
     *                     if(((1<<k)&j)!=0 && dist[i][k]==1){
     *                         dp[j+(1<<i)]=dp[j];
     *                         break;
     *                     }
     *                 }
     *                 // 如果j 子树中没有和 i 直接相连的点
     *                 // 那么也就无法添加这个节点i了
     *                 if(dp[j+(1<<i)]==0) continue;
     *                 // 把节点i添加进来 就要更新新子树的最大距离 dp[j+(1<<i)]
     *                 // 更新的办法是 对于原子树的每一个节点和新节点求最大距离
     *                 // 因为只产生了这些新距离 做增量计算就好
     *                 for(int kk=0; kk<n; kk++){
     *                     if(((1<<kk)&j)!=0){
     *                         dp[j+(1<<i)]=Math.max(dp[j+(1<<i)], dist[i][kk]);
     *                     }
     *                 }
     *             }
     *         }
     *         // 统计结果 由于下标从1开始
     *         // ans[0]其实记录的是最大距离为1的子树有多少棵 统计时要-1
     *         int[] ans=new int[n-1];
     *         for(int j=0; j<dp.length; j++){
     *             if(dp[j]!=0) ans[dp[j]-1]++;
     *         }
     *         return ans;
     *     }
     * */
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] dp = new int[(1 << n)];
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            dist[edge[0] - 1][edge[1] - 1] = 1;
            dist[edge[1] - 1][edge[0] - 1] = 1;
            dp[(1 << (edge[0] - 1)) + (1 << (edge[1] - 1))] = 1;
        }
        // floyed
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int j = 1; j < dp.length; j++) {
            if (dp[j] == 0) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (((1 << i) & j) != 0 || dp[j + (1 << i)] != 0) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (((1 << k) & j) != 0 && dist[i][k] == 1) {
                        dp[j + (1 << i)] = dp[j];
                        break;
                    }
                }
                if (dp[j + (1 << i)] == 0) {
                    continue;
                }
                for (int kk = 0; kk < n; kk++) {
                    if (((1 << kk) & j) != 0) {
                        dp[j + (1 << i)] = Math.max(dp[j + (1 << i)], dist[i][kk]);
                    }
                }
            }
        }
        int[] ans = new int[n - 1];
        for (int j : dp) {
            if (j != 0) {
                ans[j - 1]++;
            }
        }
        return ans;
    }
}
