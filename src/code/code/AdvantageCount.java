package code.code;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author duson
 * <p>
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/advantage-shuffle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AdvantageCount {

    public int[] advantageCount(int[] a, int[] b) {
        Arrays.sort(a);
        int n = a.length;
        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((aa, bb) -> bb[0] - aa[0]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{b[i], i});
        }
        int lo = 0, hi = n - 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[1], val = cur[0];
            if (a[hi] > val) {
                res[idx] = a[hi--];
            } else {
                res[idx] = a[lo++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int[] b = new int[]{1, 10, 4, 11};
        AdvantageCount advantageCount = new AdvantageCount();
        System.out.println(Arrays.toString(advantageCount.advantageCount(a, b)));
    }
}
