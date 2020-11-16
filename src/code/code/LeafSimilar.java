package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * <p>
 * <p>
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的两颗树可能会有 1 到 100 个结点。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeafSimilar {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode node, List<Integer> leafValues) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
        }
        dfs(node.left, leafValues);
        dfs(node.right, leafValues);
    }

}
