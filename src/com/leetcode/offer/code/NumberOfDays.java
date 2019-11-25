package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：Y = 1992, M = 7
 * 输出：31
 * 示例 2：
 * <p>
 * 输入：Y = 2000, M = 2
 * 输出：29
 * 示例 3：
 * <p>
 * 输入：Y = 1900, M = 2
 * 输出：28
 *  
 * <p>
 * 提示：
 * <p>
 * 1583 <= Y <= 2100
 * 1 <= M <= 12
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-days-in-a-month
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfDays {

    public int numberOfDays(int y, int m) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((y % 100 != 0 && y % 4 == 0) || (y % 400 == 0)) {
            days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }
        return days[m - 1];
    }
}
