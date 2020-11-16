package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 对于一棵深度小于 5 的树，可以用一组三位十进制整数来表示。
 * <p>
 * 对于每个整数：
 * <p>
 * 百位上的数字表示这个节点的深度 D，1 <= D <= 4。
 * 十位上的数字表示这个节点在当前层所在的位置 P， 1 <= P <= 8。位置编号与一棵满二叉树的位置编号相同。
 * 个位上的数字表示这个节点的权值 V，0 <= V <= 9。
 * 给定一个包含三位整数的升序数组，表示一棵深度小于 5 的二叉树，请你返回从根到所有叶子结点的路径之和。
 * <p>
 * 样例 1:
 * <p>
 * 输入: [113, 215, 221]
 * 输出: 12
 * 解释:
 * 这棵树形状如下:
 * 3
 * / \
 * 5   1
 * <p>
 * 路径和 = (3 + 5) + (3 + 1) = 12.
 *  
 * <p>
 * 样例 2:
 * <p>
 * 输入: [113, 221]
 * 输出: 4
 * 解释:
 * 这棵树形状如下:
 * 3
 * \
 * 1
 * <p>
 * 路径和 = (3 + 1) = 4.
 *  
 * <p>
 * 通过次数400提交次数677
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum4 {

    private int ans = 0;
    private Map<Integer, Integer> values;

    public int pathSum(int[] nums) {
        values = new HashMap<>();
        for (int num : nums) {
            values.put(num / 10, num % 10);
        }
        dfs(nums[0] / 10, 0);
        return ans;
    }

    private void dfs(int node, int sum) {
        if (!values.containsKey(node)) {
            return;
        }
        sum += values.get(node);
        int depth = node / 10, pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;
        if (!values.containsKey(left) && !values.containsKey(right)) {
            ans += sum;
        } else {
            dfs(left, sum);
            dfs(right, sum);
        }
    }
}
