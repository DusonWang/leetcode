package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 * <p>
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 * <p>
 * 那么数组 A 是漂亮数组。
 * <p>
 *  
 * <p>
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：4
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：5
 * 输出：[3,1,2,5,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/beautiful-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BeautifulArray {

    private Map<Integer, int[]> memo;

    public int[] beautifulArray(int n) {
        memo = new HashMap<>();
        return f(n);
    }

    public int[] f(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int[] ans = new int[n];
        if (n == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x : f((n + 1) / 2)) {
                ans[t++] = 2 * x - 1;
            }
            for (int x : f(n / 2)) {
                ans[t++] = 2 * x;
            }
        }
        memo.put(n, ans);
        return ans;
    }
}
