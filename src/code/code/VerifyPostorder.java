package code.code;

/**
 * @author duson
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回?true，否则返回?false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * ?
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
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * ?
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 * 通过次数12,008提交次数23,737
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] nodes, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = nodes[right];
        int index = left;
        while (nodes[index] < root) {
            ++index;
        }
        for (int i = index; i < right; ++i) {
            if (nodes[i] < root) {
                return false;
            }
        }
        return helper(nodes, left, index - 1)
                && helper(nodes, index, right - 1);
    }
}
