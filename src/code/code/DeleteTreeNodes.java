package code.code;

/**
 * 给你一棵以节点 0 为根节点的树，定义如下：
 * <p>
 * 节点的总数为?nodes?个；
 * 第?i 个节点的值为?value[i]?；
 * 第?i 个节点的父节点是?parent[i]?。
 * 请你删除节点值之和为 0 的每一棵子树。
 * <p>
 * 在完成所有删除之后，返回树中剩余节点的数目。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
 * 输出：2
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nodes <= 10^4
 * -10^5 <= value[i] <= 10^5
 * parent.length == nodes
 * parent[0] == -1?表示节点 0 是树的根。
 * 通过次数904提交次数1,712
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author duson
 */
public class DeleteTreeNodes {

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        for (int i = nodes - 1; i > 0; i--) {
            value[parent[i]] += value[i];
        }
        int count = 0;
        if (value[0] != 0) {
            count++;
        }
        for (int i = 1; i < nodes; i++) {
            if (value[i] != 0) {
                if (value[parent[i]] == 0) {
                    value[i] = 0;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
