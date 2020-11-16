package code.code;

/**
 * @author duson
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的数组的大小在 [1, 1000] 之间。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructMaximumBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        int maxI = max(nums, l, r);
        TreeNode root = new TreeNode(nums[maxI]);
        root.left = construct(nums, l, maxI);
        root.right = construct(nums, maxI + 1, r);
        return root;
    }

    private int max(int[] nums, int l, int r) {
        int maxI = l;
        for (int i = l; i < r; i++) {
            if (nums[maxI] < nums[i]) {
                maxI = i;
            }
        }
        return maxI;
    }

}
