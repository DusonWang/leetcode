package code.code;

/**
 * @author duson
 * 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 *
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,1,2,3,4,3,4]
 * 输出："dba"
 * 示例 2：
 *
 *
 *
 * 输入：[25,1,3,1,3,0,2]
 * 输出："adz"
 * 示例 3：
 *
 *
 *
 * 输入：[2,2,1,null,1,0,null,0]
 * 输出："abc"
 *  
 *
 * 提示：
 *
 * 给定树的结点数介于 1 和 8500 之间。
 * 树中的每个结点都有一个介于 0 和 25 之间的值。
 * 通过次数2,517提交次数5,813
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-starting-from-leaf
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestFromLeaf {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private String s = "~";

    public String smallestFromLeaf(TreeNode root) {
        depthFirst(root, new StringBuilder());
        return s;
    }

    private void depthFirst(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            String str = sb.reverse().toString();
            sb.reverse();
            if (str.compareTo(s) < 0) {
                s = str;
            }
        }
        depthFirst(root.left, sb);
        depthFirst(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
