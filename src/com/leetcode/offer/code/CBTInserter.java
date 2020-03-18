package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，结点数达到最大）的，并且所有的结点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root) 使用头结点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 将 TreeNode 插入到存在值为 node.val = v  的树中以使其保持完全二叉树的状态，并返回插入的 TreeNode 的父结点的值；
 * CBTInserter.get_root() 将返回树的头结点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * 示例 2：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 最初给定的树是完全二叉树，且包含 1 到 1000 个结点。
 * 每个测试用例最多调用 CBTInserter.insert  操作 10000 次。
 * 给定结点或插入结点的每个值都在 0 到 5000 之间。
 * 通过次数1,647提交次数2,796
 * 在真实的面试中遇到过这道题？
 */
public class CBTInserter {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<TreeNode> tree;

    public CBTInserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0; i < tree.size(); ++i) {
            if (tree.get(i).left != null) {
                tree.add(tree.get(i).left);
            }
            if (tree.get(i).right != null) {
                tree.add(tree.get(i).right);
            }
        }
    }

    public int insert(int v) {
        int n = tree.size();
        TreeNode node = new TreeNode(v);
        tree.add(node);
        if (n % 2 == 1) {
            tree.get((n - 1) / 2).left = node;
        } else {
            tree.get((n - 1) / 2).right = node;
        }
        return tree.get((n - 1) / 2).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }
}
