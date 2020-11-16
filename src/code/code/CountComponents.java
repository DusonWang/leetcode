package code.code;

/**
 * @author duson
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * <p>
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * <p>
 * 输出:  1
 * 注意:
 * 你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountComponents {

    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1];
            union(arr, v1, v2);
        }
        for (int v = 0; v < n; v++) {
            if (find(arr, v) == v) {
                ans++;
            }
        }
        return ans;
    }

    private void union(int[] arr, int i, int j) {
        int f1 = find(arr, i);
        int f2 = find(arr, j);
        if (f1 < f2) {
            arr[f2] = f1;
        } else {
            arr[f1] = f2;
        }
    }

    private int find(int[] arr, int i) {
        if (i == arr[i]) {
            return i;
        }
        return arr[i] = find(arr, arr[i]);
    }
}
