package com.leetcode.offer.code;

import javafx.util.Pair;

/**
 * @author duson
 * 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 * <p>
 * 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 * <p>
 * 一个结点的子树是该结点加上它的所有后代的集合。
 * <p>
 * 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * <p>
 * 我们返回值为 2 的结点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的结点。
 * 输入 "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" 是对给定的树的序列化表述。
 * 输出 "[2, 7, 4]" 是对根结点的值为 2 的子树的序列化表述。
 * 输入和输出都具有 TreeNode 类型。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中结点的数量介于 1 和 500 之间。
 * 每个结点的值都是独一无二的。
 * 通过次数1,942提交次数3,733
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubtreeWithAllDeepest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    public Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, null);
        }
        Pair<Integer, TreeNode> l = deep(root.left);
        Pair<Integer, TreeNode> r = deep(root.right);
        int d1 = l.getKey();
        int d2 = r.getKey();
        return new Pair<>(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}
