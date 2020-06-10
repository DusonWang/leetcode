package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * 给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。
 * <p>
 * 如果没有任何矩形，就返回 0。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,2],[2,1],[1,0],[0,1]]
 * 输出：2.00000
 * 解释：最小面积的矩形出现在 [1,2],[2,1],[1,0],[0,1] 处，面积为 2。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[[0,1],[2,1],[1,1],[1,0],[2,0]]
 * 输出：1.00000
 * 解释：最小面积的矩形出现在 [1,0],[1,1],[2,1],[2,0] 处，面积为 1。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：[[0,3],[1,2],[3,1],[1,3],[2,1]]
 * 输出：0
 * 解释：没法从这些点中组成任何矩形。
 * 示例 4：
 * <p>
 * <p>
 * <p>
 * 输入：[[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
 * 输出：2.00000
 * 解释：最小面积的矩形出现在 [2,1],[2,3],[3,3],[3,1] 处，面积为 2。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 50
 * 0 <=?points[i][0] <=?40000
 * 0 <=?points[i][1] <=?40000
 * 所有的点都是不同的。
 * 与真实值误差不超过 10^-5?的答案将视为正确结果。
 * 通过次数1,396提交次数2,946
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-area-rectangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinAreaFreeRect {

    public double minAreaFreeRect(int[][] p) {
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                double x = (p[i][0] + p[j][0]) / 2.0;
                double y = (p[i][1] + p[j][1]) / 2.0;
                String key = x + "," + y + "," + getDist(p, i, j);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[]{i, j});
            }
        }
        double res = Double.MAX_VALUE;
        for (List<int[]> l : map.values()) {
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    res = Math.min(res, getArea(p, l.get(i), l.get(j)));
                }
            }
        }
        return res == Double.MAX_VALUE ? 0 : res;
    }

    private int getDist(int[][] p, int i, int j) {
        return (p[i][0] - p[j][0]) * (p[i][0] - p[j][0]) + (p[i][1] - p[j][1]) * (p[i][1] - p[j][1]);
    }

    private double getArea(int[][] p, int[] a, int[] b) {
        int dis1 = getDist(p, a[0], b[0]);
        int dis2 = getDist(p, a[0], b[1]);
        return Math.sqrt(dis1) * Math.sqrt(dis2);
    }
}
