package code.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 示例 3：
 * <p>
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 示例 4：
 * <p>
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * 示例 5：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *  
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 5000 个节点。
 * 每个节点的值在 [-10^5, 10^5] 之间。
 * 通过次数3,692提交次数5,057
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetAllElements {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        inorder(root1, ans);
        inorder(root2, ans);
        Collections.sort(ans);
        return ans;
    }

    private void inorder(TreeNode n, List<Integer> ans) {
        if (n == null) {
            return;
        }
        inorder(n.left, ans);
        ans.add(n.val);
        inorder(n.right, ans);
    }
}
