package code.code;

/**
 * @author duson
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * <p>
 * 示例:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallestInMatrix {

    public int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            int count = 0, j = matrix[0].length - 1;
            for (int[] ints : matrix) {
                while (j >= 0 && ints[j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        final int len = matrix.length;
        int high = matrix[len - 1][len - 1];
        int mid, count;
        while (low < high) {
            mid = (high + low) >> 1;
            count = 0;
            for (int[] ints : matrix) {
                count += count(ints, mid);
            }
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int count(int[] row, int target) {
        int low = 0, high = row.length;
        int mid;
        while (low < high) {
            mid = (high + low) >> 1;
            if (row[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
