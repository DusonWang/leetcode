package com.leetcode.offer.code;

import java.util.HashSet;

/**
 * @author duson
 * 我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
 * <p>
 * 每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [3,2,4,4],
 * [1,3,2,4],
 * [2,3,3,4]
 * ]
 * <p>
 * 返回 true。5个矩形一起可以精确地覆盖一个矩形区域。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * rectangles = [
 * [1,1,2,3],
 * [1,3,2,4],
 * [3,1,4,2],
 * [3,2,4,4]
 * ]
 * <p>
 * 返回 false。两个矩形之间有间隔，无法覆盖成一个矩形。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [3,2,4,4]
 * ]
 * <p>
 * 返回 false。图形顶端留有间隔，无法覆盖成一个矩形。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [2,2,4,4]
 * ]
 * <p>
 * 返回 false。因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsRectangleCover {

    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        HashSet<String> set = new HashSet<>();
        int area = 0;

        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];
            if (!set.add(s1)) {
                set.remove(s1);
            }
            if (!set.add(s2)) {
                set.remove(s2);
            }
            if (!set.add(s3)) {
                set.remove(s3);
            }
            if (!set.add(s4)) {
                set.remove(s4);
            }
        }
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) {
            return false;
        }
        return area == (x2 - x1) * (y2 - y1);
    }
}
