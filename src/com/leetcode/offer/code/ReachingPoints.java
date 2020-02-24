package com.leetcode.offer.code;

/**
 * @author duson
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 * <p>
 * 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
 * <p>
 * 示例:
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: True
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * <p>
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: False
 * <p>
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: True
 * <p>
 * 注意:
 * <p>
 * sx, sy, tx, ty 是范围在 [1, 10^9] 的整数。
 * 通过次数981提交次数3,585
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reaching-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx < ty) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }
        return sx == tx && sy <= ty && (ty - sy) % sx == 0 ||
                sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}
