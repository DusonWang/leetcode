package com.leetcode.offer.day11;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author duson
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RecoverTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (firstNode == null && pre.val > p.val) {
                firstNode = pre;
            }
            if (firstNode != null && pre.val > p.val) {
                secondNode = p;
            }

            pre = p;
            p = p.right;
        }
        if (firstNode != null) {
            int tmp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = tmp;
        }
    }

    public void recoverTree2(TreeNode root) {
        TreeNode cur = root;
        TreeNode first = null, second = null, preNew = null;
        while (cur != null) {
            if (cur.left == null) {
                if (preNew != null && preNew.val > cur.val) {
                    if (first == null) {
                        first = preNew;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                preNew = cur;
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right.val != cur.val) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    if (preNew != null && preNew.val > cur.val) {
                        if (first == null) {
                            first = preNew;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    preNew = cur;
                    cur = cur.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
