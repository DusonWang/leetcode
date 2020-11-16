package code.code;

/**
 * @author duson
 * <p>
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        serialize(root.left, sb);
        serialize(root.right, sb);
        sb.append(Integer.valueOf(root.val)).append(" ");
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(" ");
        int[] index = new int[]{nodes.length - 1};
        return deserialize(nodes, index, Integer.MIN_VALUE);
    }

    private TreeNode deserialize(String[] nodes, int[] index, int min) {
        if (index[0] < 0 || Integer.parseInt(nodes[index[0]]) <= min) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]--]));
        root.right = deserialize(nodes, index, root.val);
        root.left = deserialize(nodes, index, min);
        return root;
    }
}
