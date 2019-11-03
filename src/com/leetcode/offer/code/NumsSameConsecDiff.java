package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duson
 * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 * <p>
 * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 3, K = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 示例 2：
 * <p>
 * 输入：N = 2, K = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 9
 * 0 <= K <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumsSameConsecDiff {

    private Set<Integer> set = new HashSet<>();

    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        for (int i = 1; i < 10; i++) {
            dfs(n, k, i, 1, i);
        }
        int[] re = new int[set.size()];
        int m = 0;
        for (int i : set) {
            re[m++] = i;
        }
        return re;
    }

    private void dfs(int n, int k, int num, int count, int m) {
        if (count == n) {
            set.add(num);
            return;
        }
        int s = m + k;
        if (s < 10) {
            dfs(n, k, num * 10 + s, count + 1, s);
        }
        int l = m - k;
        if (l < 10 && l >= 0) {
            dfs(n, k, num * 10 + l, count + 1, l);
        }
    }

    public static void main(String[] args) {
        NumsSameConsecDiff numsSameConsecDiff = new NumsSameConsecDiff();
        System.out.println(Arrays.toString(numsSameConsecDiff.numsSameConsecDiff(3, 7)));
    }
}
