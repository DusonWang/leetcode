package code.code;

/**
 * @author duson
 * <p>
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * 输出: false
 * 注意：你可以假定边列表 edges 中不会出现重复的边。由于所有的边是无向边，边 [0,1] 和边 [1,0] 是相同的，因此不会同时出现在边列表 edges 中。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/graph-valid-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length + 1 != n) {
            return false;
        }
        int[] par = new int[n];
        int par1, par2;
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        for (int[] edge : edges) {
            par1 = edge[0];
            par2 = edge[1];
            while (par1 != par[par1]) {
                par1 = par[par1];
            }
            while (par2 != par[par2]) {
                par2 = par[par2];
            }
            if (par1 != par2) {
                par[par2] = par1;
                n--;
            }
        }
        return n == 1;
    }
}
