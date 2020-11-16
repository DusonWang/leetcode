package code.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * ?
 * <p>
 * 例如:
 * 给定二叉树:?[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * ?
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * 通过次数12,654提交次数21,307
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> ref;

    public List<List<Integer>> levelOrder(TreeNode root) {
        ref = new ArrayList<>();
        if (root == null) {
            return ref;
        }
        helper(root, 0);
        for (int i = 1; i < ref.size(); i += 2) {
            Collections.reverse(ref.get(i));
        }
        return ref;
    }

    private void helper(TreeNode root, int cnt) {
        if (root == null) {
            return;
        }
        if (ref.size() <= cnt) {
            ref.add(new ArrayList<>());
        }
        ref.get(cnt).add(root.val);
        helper(root.left, cnt + 1);
        helper(root.right, cnt + 1);
    }
}
