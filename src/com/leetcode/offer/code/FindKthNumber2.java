package com.leetcode.offer.code;

/**
 * @author duson
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * <p>
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 * <p>
 * 例 1：
 * <p>
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 * <p>
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * <p>
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * 注意：
 * <p>
 * m 和 n 的范围在 [1, 30000] 之间。
 * k 的范围在 [1, m * n] 之间。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthNumber2 {

    public int findKthNumber(int m, int n, int k) {
        int start = 1;
        int end = m * n;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            int count = counter(m, n, mid);
            if (count >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int counter(int m, int n, int mid) {
        int x = m;
        int y = 1;
        int counter = 0;
        while (x >= 1 && y <= n) {
            if (x * y <= mid) {
                counter += x;
                y++;
            } else {
                x--;
            }
        }
        return counter;
    }
}
