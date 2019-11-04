package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * 输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * 解释:
 * <p>
 * 示例 2:
 * <p>
 * 输入: [[1,2],[2,2],[4,2]]
 * 输出: [[1,2],[2,2],[4,2]]
 * 解释:
 * <p>
 * 即使树都在一条直线上，你也需要先用绳子包围它们。
 *  
 * <p>
 * 注意:
 * <p>
 * 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。
 * 输入的整数在 0 到 100 之间。
 * 花园至少有一棵树。
 * 所有树的坐标都是不同的。
 * 输入的点没有顺序。输出顺序也没有要求。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/erect-the-fence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OuterTrees {

    public int[][] outerTrees(int[][] points) {
        if (points == null || points.length <= 3) {
            return points;
        }
        int len = points.length;
        int p, q, l = 0;
        int[][] res;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (points[i][0] < points[l][0]) {
                l = i;
            }
        }
        p = l;
        do {
            list.add(points[p]);
            q = (p + 1) % len;
            for (int i = 0; i < len; i++) {
                if (orient(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }
            for (int i = 0; i < len; i++) {
                if (i != p && i != q && orient(points[p], points[i], points[q]) == 0 && onSeg(points[p], points[q], points[i])) {
                    list.add(points[i]);
                }
            }
            p = q;

        } while (p != l);

        res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private boolean onSeg(int[] p, int[] q, int[] r) {
        return r[0] >= Math.min(p[0], q[0]) && r[0] <= Math.max(p[0], q[0]) && r[1] >= Math.min(p[1], q[1]) && r[1] <= Math.max(p[1], q[1]);
    }

    private int orient(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (r[1] - q[1]) * (q[0] - p[0]);
    }
}
