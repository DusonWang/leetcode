package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * 给定一个有 N 个节点的二叉树，每个节点都有一个不同于其他节点且处于 {1, ..., N} 中的值。
 * <p>
 * 通过交换节点的左子节点和右子节点，可以翻转该二叉树中的节点。
 * <p>
 * 考虑从根节点开始的先序遍历报告的 N 值序列。将这一 N 值序列称为树的行程。
 * <p>
 * （回想一下，节点的先序遍历意味着我们报告当前节点的值，然后先序遍历左子节点，再先序遍历右子节点。）
 * <p>
 * 我们的目标是翻转最少的树中节点，以便树的行程与给定的行程 voyage 相匹配。 
 * <p>
 * 如果可以，则返回翻转的所有节点的值的列表。你可以按任何顺序返回答案。
 * <p>
 * 如果不能，则返回列表 [-1]。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2], voyage = [2,1]
 * 输出：[-1]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3], voyage = [1,3,2]
 * 输出：[1]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3], voyage = [1,2,3]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 100
 * 通过次数1,431提交次数3,333
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FlipMatchVoyage {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> res = new ArrayList<>();
    private int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
        return dfs(root, v) ? res : Collections.singletonList(-1);
    }

    private boolean dfs(TreeNode node, int[] v) {
        if (node == null) {
            return true;
        }
        if (node.val != v[i++]) {
            return false;
        }
        if (node.left != null && node.left.val != v[i]) {
            res.add(node.val);
            return dfs(node.right, v) && dfs(node.left, v);
        }
        return dfs(node.left, v) && dfs(node.right, v);
    }
}
