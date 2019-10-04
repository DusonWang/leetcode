package com.leetcode.offer.day40;

/**
 * @author duson
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * <p>
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * <p>
 * 返回 A 中好子数组的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：A = [1,2,1,2,3], K = 2
 * 输入：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 * <p>
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] a, int k) {
        int[] count = new int[a.length + 1];
        int distinct = 0, start = 0, minEnd = 0, total = 0;
        while (distinct == k || minEnd < a.length) {
            while (distinct < k && minEnd < a.length) {
                if (count[a[minEnd++]]++ == 0) {
                    distinct++;
                }
            }
            int maxEnd = minEnd;
            while (maxEnd < a.length && count[a[maxEnd]] > 0) {
                maxEnd++;
            }
            while (distinct == k) {
                if (count[a[start++]]-- == 1) {
                    distinct--;
                }
                total += (maxEnd - minEnd + 1);
            }
        }
        return total;
    }

    public int subarraysWithKDistinct2(int[] a, int k) {
        int[] counts = new int[a.length + 1];
        int goodCount = 0;
        int l = 0;
        int countDistinct = 0;
        int mult = 1;

        for (int i : a) {
            if (counts[i]++ == 0) {
                countDistinct++;
            }
            while (countDistinct > k) {
                if (--counts[a[l]] == 0) {
                    countDistinct--;
                }
                l++;
                mult = 1;
            }
            if (countDistinct == k) {
                while (counts[a[l]] > 1) {
                    mult++;
                    counts[a[l]]--;
                    l++;
                }
                goodCount += mult;
            }
        }
        return goodCount;
    }
}
