package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 * <p>
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举（A[i]，A[j]，A[k]）：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * 示例 2：
 * <p>
 * 输入：A = [1,1,2,2,2,2], target = 5
 * 输出：12
 * 解释：
 * A[i] = 1，A[j] = A[k] = 2 出现 12 次：
 * 我们从 [1,1] 中选择一个 1，有 2 种情况，
 * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 3000
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-with-multiplicity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumMulti {

    public int threeSumMulti(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < a.length; i++) {
            res = (res + map.getOrDefault(target - a[i], 0)) % mod;
            for (int j = 0; j < i; j++) {
                int temp = a[i] + a[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }

    public int threeSumMulti2(int[] a, int target) {
        int n = 1000000007;
        long ans = 0;
        long[] cnt = new long[101];
        for (int aa : a) {
            cnt[aa]++;
        }
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int t = target - i - j;
                if (t < 0 || t > 100) {
                    continue;
                }
                if (i == j && j == t) {
                    ans += ((cnt[i] * (cnt[i] - 1)) % n * (cnt[i] - 2) / 6) % n;
                } else if (i == j) {
                    ans += ((cnt[i] * (cnt[i] - 1) / 2) % n * cnt[t]) % n;
                } else if (j < t) {
                    ans += ((cnt[i] * cnt[j]) % n * cnt[t]) % n;
                }
            }
        }
        return (int) (ans % n);
    }
}
