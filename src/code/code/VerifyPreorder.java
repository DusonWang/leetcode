package code.code;

/**
 * @author duson
 * <p>
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
 * <p>
 * 你可以假定该序列中的数都是不相同的。
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [5,2,6,1,3]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [5,2,1,3,6]
 * 输出: true
 * 进阶挑战：
 * <p>
 * 您能否使用恒定的空间复杂度来完成此题？
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VerifyPreorder {

    public boolean verifyPreorder(int[] preorder) {
        //Stack<Integer> stack = new Stack<>();
        //        int min = Integer.MIN_VALUE;
        //        for (int value : preorder) {
        //            if (value < min) {
        //                return false;
        //            }
        //            while (!stack.isEmpty() && value > stack.peek()) {
        //                min = stack.pop();
        //            }
        //            stack.push(value);
        //        }
        //        return true;
        int index = -1;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < min) {
                return false;
            }
            while (index >= 0 && preorder[i] > preorder[index]) {
                min = preorder[index--];
            }
            preorder[++index] = preorder[i];
        }
        return true;
    }
}
