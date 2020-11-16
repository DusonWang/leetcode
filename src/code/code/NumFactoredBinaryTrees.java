package code.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 给出一个含有不重复整数元素的数组，每个整数均大于 1。
 * <p>
 * 我们用这些整数来构建二叉树，每个整数可以使用任意次数。
 * <p>
 * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * <p>
 * 满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: A = [2, 4]
 * 输出: 3
 * 解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 * <p>
 * 输入: A = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= A.length <= 1000.
 * 2 <= A[i] <= 10 ^ 9.
 * 通过次数1,020提交次数2,631
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-trees-with-factors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumFactoredBinaryTrees {

    public int numFactoredBinaryTrees(int[] aa) {
        Arrays.sort(aa);
        Map<Integer, Long> ways = new HashMap<>();
        long total = 0;
        for (int a : aa) {
            long current = 1;
            for (int d : aa) {
                int dd = a / d;
                if (dd < d) {
                    break;
                }
                if (d * dd == a) {
                    if (!ways.containsKey(dd)) {
                        continue;
                    }
                    long w = ways.get(d) * ways.get(dd);
                    if (d != dd) {
                        w *= 2;
                    }
                    current += w;
                    current %= 1000000007;
                }
            }
            ways.put(a, current);
            total += current;
        }
        return (int) (total % 1000000007);
    }
}
