package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给你一棵完全二叉树，请按以下要求的顺序收集它的全部节点：
 * <p>
 * 依次从左到右，每次收集并删除所有的叶子节点
 * 重复如上过程直到整棵树为空
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 *  
 *           1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 输出: [[4,5,3],[2],[1]]
 *  
 * <p>
 * 解释:
 * <p>
 * 1. 删除叶子节点 [4,5,3] ，得到如下树结构：
 * <p>
 * 1
 * /
 * 2
 *  
 * <p>
 * 2. 现在删去叶子节点 [2] ，得到如下树结构：
 * <p>
 * 1
 *  
 * <p>
 * 3. 现在删去叶子节点 [1] ，得到空树：
 * <p>
 * []
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-leaves-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int d = Math.max(left, right);
        if (d >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(d).add(root.val);
        return d + 1;
    }
}
