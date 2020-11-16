package code.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * 508. 出现次数最多的子树元素和
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 * <p>
 * <p>
 * <p>
 * 示例 1
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * <p>
 * 示例 2
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * <p>
 * <p>
 * <p>
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 * <p>
 * 通过次数3,635提交次数5,874
 * 在真实的面试中遇到过这道题？
 */
public class FindFrequentTreeSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftV = helper(root.left);
        int rightV = helper(root.right);
        int sum = root.val + leftV + rightV;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        if (count > max) {
            list = new ArrayList<>();
            list.add(sum);
            max = count;
        } else if (count == max) {
            list.add(sum);
        }
        return sum;
    }

}
