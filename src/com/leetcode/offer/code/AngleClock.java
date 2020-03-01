package com.leetcode.offer.code;

/**
 * @author duson
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：hour = 12, minutes = 30
 * 输出：165
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：hour = 3, minutes = 30
 * 输出；75
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：hour = 3, minutes = 15
 * 输出：7.5
 * 示例 4：
 * <p>
 * 输入：hour = 4, minutes = 50
 * 输出：155
 * 示例 5：
 * <p>
 * 输入：hour = 12, minutes = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 与标准答案误差在 10^-5 以内的结果都被视为正确结果。
 * 通过次数1,418提交次数2,392
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/angle-between-hands-of-a-clock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AngleClock {

    public double angleClock(int hour, int minutes) {
        double h = hour % 12 * 30 + ((double) minutes / 60 * 30);
        double m = minutes * 6;
        double angle = Math.abs(m - h);
        if (angle > 180) {
            angle = 360.0 - angle;
        }
        return angle;
    }
}
