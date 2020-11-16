package code.code;

import java.util.Stack;

/**
 * @author duson
 * 给定一棵有 n 个结点的二叉树，你的任务是检查是否可以通过去掉树上的一条边将树分成两棵，且这两棵树结点之和相等。
 * <p>
 * 样例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 10 10
 * /  \
 * 2   3
 * <p>
 * 输出: True
 * 解释:
 * 5
 * /
 * 10
 * <p>
 * 和: 15
 * <p>
 * 10
 * /  \
 * 2    3
 * <p>
 * 和: 15
 *  
 * <p>
 * 样例 2:
 * <p>
 * 输入:
 * 1
 * / \
 * 2  10
 * /  \
 * 2   20
 * <p>
 * 输出: False
 * 解释: 无法通过移除一条树边将这棵树划分成结点之和相等的两棵子树。
 *  
 * <p>
 * 注释 :
 * <p>
 * 树上结点的权值范围 [-100000, 100000]。
 * 1 <= n <= 10000
 *  
 * <p>
 * 通过次数453提交次数1,069
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/equal-tree-partition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckEqualTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<Integer> seen;

    public boolean checkEqualTree(TreeNode root) {
        seen = new Stack<>();
        int total = sum(root);
        seen.pop();
        if (total % 2 == 0) {
            for (int s : seen) {
                if (s == total / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        seen.push(sum(node.left) + sum(node.right) + node.val);
        return seen.peek();
    }
}
