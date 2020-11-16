package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 给定一个数组 A（下标从 1 开始）包含 N 个整数：A1，A2，……，AN 和一个整数 B。你可以从数组 A 中的任何一个位置（下标为 i）跳到下标 i+1，i+2，……，i+B 的任意一个可以跳到的位置上。如果你在下标为 i 的位置上，你需要支付 Ai 个金币。如果 Ai 是 -1，意味着下标为 i 的位置是不可以跳到的。
 * <p>
 * 现在，你希望花费最少的金币从数组 A 的 1 位置跳到 N 位置，你需要输出花费最少的路径，依次输出所有经过的下标（从 1 到 N）。
 * <p>
 * 如果有多种花费最少的方案，输出字典顺序最小的路径。
 * <p>
 * 如果无法到达 N 位置，请返回一个空数组。
 * <p>
 *  
 * <p>
 * 样例 1 :
 * <p>
 * 输入: [1,2,4,-1,2], 2
 * 输出: [1,3,5]
 *  
 * <p>
 * 样例 2 :
 * <p>
 * 输入: [1,2,4,-1,2], 1
 * 输出: []
 *  
 * <p>
 * 注释 :
 * <p>
 * 路径 Pa1，Pa2，……，Pan 是字典序小于 Pb1，Pb2，……，Pbm 的，当且仅当第一个 Pai 和 Pbi 不同的 i 满足 Pai < Pbi，如果不存在这样的 i 那么满足 n < m。
 * A1 >= 0。 A2, ..., AN （如果存在） 的范围是 [-1, 100]。
 * A 数组的长度范围 [1, 1000].
 * B 的范围 [1, 100].
 *  
 * <p>
 * 通过次数250提交次数952
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheapestJump {

    public List<Integer> cheapestJump(int[] a, int b) {
        int[] next = new int[a.length];
        long[] dp = new long[a.length];
        Arrays.fill(next, -1);
        List<Integer> res = new ArrayList<>();
        for (int i = a.length - 2; i >= 0; i--) {
            long minCost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + b && j < a.length; j++) {
                if (a[j] >= 0) {
                    long cost = a[i] + dp[j];
                    if (cost < minCost) {
                        minCost = cost;
                        next[i] = j;
                    }
                }
            }
            dp[i] = minCost;
        }
        int i = 0;
        while (i < a.length && next[i] > 0) {
            res.add(i + 1);
            i = next[i];
        }
        if (i == a.length - 1 && a[i] >= 0) {
            res.add(a.length);
        }
        return res;
    }
}
