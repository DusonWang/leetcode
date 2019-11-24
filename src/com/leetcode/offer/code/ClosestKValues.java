package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。
 * <p>
 * 注意：
 * <p>
 * 给定的目标值 target 是一个浮点数
 * 你可以默认 k 值永远是有效的，即 k ≤ 总结点数
 * 题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值
 * 示例：
 * <p>
 * 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * 输出: [4,3]
 * 拓展：
 * 假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-binary-search-tree-value-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClosestKValues {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int index = 0;
    private List<Integer> result = new ArrayList<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null) {
            return result;
        }
        closestKValues(root.left, target, k);
        if (result.size() < k) {
            result.add(root.val);
        } else if (Math.abs(target - result.get(index)) > Math.abs(target - root.val)) {
            result.set(index++, root.val);
            if (index == k) {
                index = 0;
            }
        } else {
            return result;
        }
        closestKValues(root.right, target, k);
        return result;
    }
}
