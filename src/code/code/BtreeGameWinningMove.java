package code.code;

/**
 * @author duson
 * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点?root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从?1 到?n?各不相同。
 *
 * ?
 *
 * 游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，
 *
 * 「一号」玩家从 [1, n]?中取一个值?x（1 <= x <= n）；
 *
 * 「二号」玩家也从?[1, n]?中取一个值?y（1 <= y <= n）且?y != x。
 *
 * 「一号」玩家给值为?x?的节点染上红色，而「二号」玩家给值为?y?的节点染上蓝色。
 *
 * ?
 *
 * 之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色。
 *
 * 如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。
 *
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ??。
 *
 * ?
 *
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个?y?值可以确保你赢得这场游戏，则返回?true；若无法获胜，就请返回 false。
 *
 * ?
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * 输出：True
 * 解释：第二个玩家可以选择值为 2 的节点。
 * ?
 *
 * 提示：
 *
 * 二叉树的根节点为?root，树上由 n 个节点，节点上的值从 1 到 n 各不相同。
 * n 为奇数。
 * 1 <= x <= n?<= 100
 * 通过次数3,105提交次数7,445
 * 在真实的面试中遇到过这道题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-coloring-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BtreeGameWinningMove {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int left;

    private int right;

    private int num;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        num = x;
        dfs(root);
        int half = n / 2;
        return left > half || right > half || (left + right) < half;
    }

    private int dfs(TreeNode node) {
        int leftNum = 0;
        int rightNum = 0;
        if (node.left != null) {
            leftNum = dfs(node.left);
        }
        if (node.right != null) {
            rightNum = dfs(node.right);
        }
        if (node.val == num) {
            left = leftNum;
            right = rightNum;
        }
        return leftNum + rightNum + 1;
    }
}
