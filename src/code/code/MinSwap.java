package code.code;

/**
 * @author duson
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。
 * <p>
 * 我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 * <p>
 * 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 * <p>
 * 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 * <p>
 * 示例:
 * 输入: A = [1,3,5,4], B = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 * 注意:
 * <p>
 * A, B 两个数组的长度总是相等的，且长度的范围为 [1, 1000]。
 * A[i], B[i] 均为 [0, 2000]区间内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSwap {

    public int minSwap(int[] a, int[] b) {
        int p = 1, q = 0;
        int len = a.length;
        for (int i = 1; i < len; i++) {
            if (a[i - 1] >= b[i] || b[i - 1] >= a[i]) {
                p++;
            } else if (a[i - 1] >= a[i] || b[i - 1] >= b[i]) {
                int temp = p;
                p = q + 1;
                q = temp;
            } else {
                int min = Math.min(q, p);
                p = min + 1;
                q = min;
            }
        }
        return Math.min(p, q);
    }
}
