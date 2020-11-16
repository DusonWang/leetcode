package code.code;

import java.util.HashMap;

/**
 * @author duson
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，以下数列为等差数列:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 * <p>
 * 1, 1, 2, 5, 7
 *  
 * <p>
 * 数组 A 包含 N 个数，且索引从 0 开始。该数组子序列将划分为整数序列 (P0, P1, ..., Pk)，P 与 Q 是整数且满足 0 ≤ P0 < P1 < ... < Pk < N。
 * <p>
 *  
 * <p>
 * 如果序列 A[P0]，A[P1]，...，A[Pk-1]，A[Pk] 是等差的，那么数组 A 的子序列 (P0，P1，…，PK) 称为等差序列。值得注意的是，这意味着 k ≥ 2。
 * <p>
 * 函数要返回数组 A 中所有等差子序列的个数。
 * <p>
 * 输入包含 N 个整数。每个整数都在 -231 和 231-1 之间，另外 0 ≤ N ≤ 1000。保证输出小于 231-1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 *  
 * <p>
 * 输入：[2, 4, 6, 8, 10]
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * 所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfArithmeticSlices2 {

    public int numberOfArithmeticSlices(int[] a) {
        int len = a.length;
        long result = 0;
        HashMap[] map = new HashMap[len];
        for (int i = 0; i < len; i++) {
            map[i] = new HashMap();
            for (int j = 0; j < i; j++) {
                long diff = (long)a[i] - (long)a[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int df = (int) diff;
                int sum = (int) map[j].getOrDefault(df, 0);
                int orig = (int) map[i].getOrDefault(df, 0);
                map[i].put(df, 1 + sum + orig);
                result += sum;
            }
        }
        return (int) result;
    }
}
