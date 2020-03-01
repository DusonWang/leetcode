package com.leetcode.offer.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * <p>
 * 百度百科中对完全二叉树的定义如下：
 * <p>
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中将会有 1 到 100 个结点。
 * 通过次数3,311提交次数7,157
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsCompleteTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean end = false;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return true;
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null) {
            bfs.poll();
        }
        return bfs.isEmpty();
    }
}
