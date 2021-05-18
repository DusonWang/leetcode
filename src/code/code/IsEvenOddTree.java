package code.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <p>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,2,3,3,7]
 * 输出：false
 * 解释：每一层的节点值分别是：
 * 0 层：[5]
 * 1 层：[4,2]
 * 2 层：[3,3,7]
 * 2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,9,1,3,5,7]
 * 输出：false
 * 解释：1 层上的节点值应为偶数。
 * 示例 4：
 * <p>
 * 输入：root = [1]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * 输出：true
 * ?
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 105] 内
 * 1 <= Node.val <= 106
 * 通过次数6,071提交次数11,756
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/even-odd-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsEvenOddTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEvenOddTree(TreeNode root) {
        List<LinkedList<Integer>> levList = new ArrayList<>();
        return levelOrder(root, levList, 0);
    }

    private boolean levelOrder(TreeNode root, List<LinkedList<Integer>> levList, int level) {
        if (root == null) {
            return true;
        }
        if (levList.size() < level + 1) {
            levList.add(new LinkedList<>());
        }
        if (level % 2 == 0) {
            if (root.val % 2 == 0 || !levList.get(level).isEmpty() && root.val <= levList.get(level).getLast()) {
                return false;
            }
        } else {
            if (root.val % 2 == 1 || !levList.get(level).isEmpty() && root.val >= levList.get(level).getLast()) {
                return false;
            }
        }
        levList.get(level).add(root.val);
        return levelOrder(root.left, levList, level + 1)
                && levelOrder(root.right, levList, level + 1);
    }

    public boolean isEvenOddTree2(TreeNode root) {
        boolean flag = false;
        int top = -1;
        int index = -1;
        TreeNode[] queue = new TreeNode[100001];
        queue[++top] = root;
        while (index != top) {
            int max = flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int len = top - index;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue[++index];
                if (node.left != null) {
                    queue[++top] = node.left;
                }
                if (node.right != null) {
                    queue[++top] = node.right;
                }
                if (flag) {
                    if ((node.val & 1) == 1) {
                        return false;
                    } else if (node.val < max) {
                        max = node.val;
                    } else {
                        return false;
                    }
                } else {
                    if ((node.val & 1) == 0) {
                        return false;
                    } else if (node.val > max) {
                        max = node.val;
                    } else {
                        return false;
                    }
                }
            }
            flag = !flag;
        }
        return true;
    }
}
