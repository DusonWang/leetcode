package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：20
 * 输出：1
 * 解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
 * 示例 2：
 * <p>
 * 输入：100
 * 输出：10
 * 解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
 * 示例 3：
 * <p>
 * 输入：1000
 * 输出：262
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/numbers-with-repeated-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDupDigitsAtMostN {

    public int numDupDigitsAtMostN(int n) {
        List<Integer> nums = new ArrayList<>();
        int temp = n + 1;
        while (temp != 0) {
            nums.add(0, temp % 10);
            temp /= 10;
        }
        int countInvalid = 0, size = nums.size();
        for (int i = 0; i < size - 1; i++) {
            countInvalid += 9 * permutation(9, i);
        }

        int[] isOccupied = new int[10];
        Arrays.fill(isOccupied, -1);
        for (int i = 0; i < nums.size(); i++) {
            int digit = nums.get(i);
            for (int j = i == 0 ? 1 : 0; j < digit; j++) {
                if (isOccupied[j] == -1) {
                    countInvalid += permutation(9 - i, size - i - 1);
                }
            }
            if (isOccupied[digit] != -1) {
                break;
            }
            isOccupied[digit] = 1;
        }
        return n - countInvalid;
    }

    private int permutation(int n, int c) {
        int ans = 1;
        for (int i = 0; i < c; i++, n--) {
            ans *= n;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumDupDigitsAtMostN n = new NumDupDigitsAtMostN();
        System.out.println(n.numDupDigitsAtMostN(20));
    }
}
