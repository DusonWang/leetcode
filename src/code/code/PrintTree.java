package code.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author duson
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * <p>
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 * <p>
 * 输入:
 * 1
 * /
 * 2
 * 输出:
 * [["", "1", ""],
 * ["2", "", ""]]
 * 示例 2:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 * 示例 3:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 * <p>
 * 通过次数2,436提交次数4,496
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(1);
        }
        int depth = getDepth(root);
        int width = (int) (Math.pow(2, depth) - 1);
        width = width > 0 ? width : 1;
        String[][] result = new String[depth][width];
        List<List<String>> res = new LinkedList<>();
        fill(result, 0, 0, width - 1, root);
        for (String[] strings : result) {
            LinkedList<String> linkedList = new LinkedList<>();
            for (String string : strings) {
                if (string == null) {
                    linkedList.add("");
                } else {
                    linkedList.add(string);
                }
            }
            res.add(linkedList);
        }
        return res;
    }

    private void fill(String[][] ints, int depth, int start, int end, TreeNode node) {
        if (node == null) {
            return;
        }
        int mid = (start + end) / 2;
        ints[depth][mid] = String.valueOf(node.val);
        fill(ints, depth + 1, start, mid - 1, node.left);
        fill(ints, depth + 1, mid + 1, end, node.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;
        return Math.max(right, left);
    }
}
