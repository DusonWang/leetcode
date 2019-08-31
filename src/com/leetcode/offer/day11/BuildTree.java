package com.leetcode.offer.day11;

/**
 * @author duson
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int p, int[] inorder, int i, int j) {
        if (i >= j) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p]);
        int k = 0;
        while (inorder[k] != root.val) {
            k++;
        }
        root.left = build(preorder, p + 1, inorder, i, k);
        root.right = build(preorder, p + 1 + k - i, inorder, k + 1, j);
        return root;
    }
}
