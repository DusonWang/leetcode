package code.code;

/**
 * @author duson
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string?is a valid sequence in such binary tree.?
 * <p>
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all?values of the nodes along a path results in a sequence in the given binary tree.
 * <p>
 * ?
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 * ?
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
 * 通过次数55提交次数86
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidSequence {

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

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }

    private boolean isValid(TreeNode root, int[] arr, int index) {
        if (root == null || index == arr.length || root.val != arr[index]) {
            return false;
        }

        if (root.left == null && root.right == null && index == arr.length - 1) {
            return true;
        }
        return isValid(root.left, arr, index + 1) || isValid(root.right, arr, index + 1);
    }

}
