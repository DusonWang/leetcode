package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * <p>
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * <p>
 * 答案中每个树的每个结点都必须有 node.val=0。
 * <p>
 * 你可以按任何顺序返回树的最终列表。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 20
 * 通过次数4,872提交次数6,677
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllPossibleFBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        n--;
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
