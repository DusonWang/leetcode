package code.code;

/**
 * @author duson
 * 给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,1,0,1]
 * 输出：1
 * 解释：
 * 有三种可能的方法可以把所有的 1 组合在一起：
 * [1,1,1,0,0]，交换 1 次；
 * [0,1,1,1,0]，交换 2 次；
 * [0,0,1,1,1]，交换 1 次。
 * 所以最少的交换次数为 1。
 * 示例 2：
 * <p>
 * 输入：[0,0,0,1,0]
 * 输出：0
 * 解释：
 * 由于数组中只有一个 1，所以不需要交换。
 * 示例 3：
 * <p>
 * 输入：[1,0,1,0,1,0,0,1,1,0,1]
 * 输出：3
 * 解释：
 * 交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= data.length <= 10^5
 * 0 <= data[i] <= 1
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSwaps {

    public int minSwaps(int[] data) {
        int len = data.length;
        int[] sums = new int[len + 1];
        sums[0] = 0;
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + data[i - 1];
        }
        int k = sums[len];
        int maxOnes = 0;
        for (int i = 1, j = i + k - 1; i <= len && j <= len; i++, j++) {
            int ones = sums[j] - sums[i - 1];
            if (ones > maxOnes) {
                maxOnes = ones;
            }
        }
        return k - maxOnes;
    }
}
