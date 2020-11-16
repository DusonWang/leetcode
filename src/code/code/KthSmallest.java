package code.code;

/**
 * @author duson
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int val = 0;

    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        middle(root, k);
        return val;
    }

    private void middle(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        middle(root.left, k);
        count++;
        if (k == count) {
            val = root.val;
        }
        middle(root.right, k);

    }

    /**
     * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
     * <p>
     * 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：mat = [[1,3,11],[2,4,6]], k = 5
     * 输出：7
     * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
     * [1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。
     * 示例 2：
     * <p>
     * 输入：mat = [[1,3,11],[2,4,6]], k = 9
     * 输出：17
     * 示例 3：
     * <p>
     * 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
     * 输出：9
     * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
     * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。
     * 示例 4：
     * <p>
     * 输入：mat = [[1,1,10],[2,2,9]], k = 7
     * 输出：12
     *  
     * <p>
     * 提示：
     * <p>
     * m == mat.length
     * n == mat.length[i]
     * 1 <= m, n <= 40
     * 1 <= k <= min(200, n ^ m)
     * 1 <= mat[i][j] <= 5000
     * mat[i] 是一个非递减数组
     * 通过次数1,679提交次数3,160
     * 在真实的面试中遇到过这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int lo = 0;
        int hi = 0;
        for (int[] a : mat) {
            lo += a[0];
            hi += a[m - 1];
        }
        int init = lo;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            count = 1;
            dfs(mat, k, mid, init, 0);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private void dfs(int[][] mat, int k, int mid, int sum, int index) {
        int n = mat.length;
        int m = mat[0].length;
        if (count > k || sum > mid || index == n) {
            return;
        }
        dfs(mat, k, mid, sum, index + 1);
        for (int i = 1; i < m; i++) {
            if (sum - mat[index][0] + mat[index][i] <= mid) {
                count++;
                dfs(mat, k, mid, sum - mat[index][0] + mat[index][i], index + 1);
            } else {
                break;
            }
        }
    }
}
