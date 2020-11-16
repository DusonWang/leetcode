package code.code;

/**
 * @author duson
 * 你需要从一个包括括号和整数的字符串构建一棵二叉树。
 * <p>
 * 输入的字符串代表一棵二叉树。它包括整数和随后的0，1或2对括号。整数代表根的值，一对括号内表示同样结构的子树。
 * <p>
 * 若存在左子结点，则从左子结点开始构建。
 * <p>
 * 示例:
 * <p>
 * 输入: "4(2(3)(1))(6(5))"
 * 输出: 返回代表下列二叉树的根节点:
 * <p>
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 *  
 * <p>
 * 注意:
 * <p>
 * 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9' 
 * 空树由 "" 而非"()"表示。
 *  
 * <p>
 * 通过次数829提交次数1,657
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Str2tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int idx = 0;

    public TreeNode str2tree(String s) {
        int len = s.length();
        if (len == 0 || idx >= len) {
            return null;
        }
        int sig = 1, k = 0;
        if (s.charAt(idx) == '-') {
            sig = -1;
            ++idx;
        }
        while (idx < len && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            k = k * 10 + s.charAt(idx) - '0';
            ++idx;
        }
        TreeNode root = new TreeNode(sig * k);
        if (idx >= len || s.charAt(idx) == ')') {
            ++idx;
            return root;
        }
        ++idx;
        root.left = str2tree(s);
        if (idx >= len || s.charAt(idx) == ')') {
            ++idx;
            return root;
        }
        ++idx;
        root.right = str2tree(s);
        if (idx >= len || s.charAt(idx) == ')') {
            ++idx;
            return root;
        }
        return root;
    }
}
