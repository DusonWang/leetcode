package com.leetcode.offer.day12;

/**
 * @author duson
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return build(inorder, postorder, 0, len - 1, 0, len - 1);
    }


    private TreeNode build(int[] inorder, int[] postorder, int inl, int inr, int postl, int postr) {
        if (inl > inr || postl > postr) {
            return null;
        }

        int val = postorder[postr];
        int k = 0;
        for (int i = inl; i < inr + 1; i++) {
            if (inorder[i] == val) {
                k = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        root.left = build(inorder, postorder, inl, k - 1, postl, k - 1 - inl + postl);
        root.right = build(inorder, postorder, k + 1, inr, postr + k - inr, postr - 1);
        return root;
    }
}
