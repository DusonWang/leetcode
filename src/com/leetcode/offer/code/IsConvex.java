package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 * 给定一个按顺序连接的多边形的顶点，判断该多边形是否为凸多边形。（凸多边形的定义）
 * <p>
 * 注：
 * <p>
 * 顶点个数至少为 3 个且不超过 10,000。
 * 坐标范围为 -10,000 到 10,000。
 * 你可以假定给定的点形成的多边形均为简单多边形（简单多边形的定义）。换句话说，保证每个顶点处恰好是两条边的汇合点，并且这些边 互不相交 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * [[0,0],[0,1],[1,1],[1,0]]
 * <p>
 * 输出： True
 * <p>
 * 解释：
 * 示例 2：
 * <p>
 * [[0,0],[0,10],[10,10],[10,0],[5,5]]
 * <p>
 * 输出： False
 * <p>
 * 解释：
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convex-polygon
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsConvex {

    public boolean isConvex(List<List<Integer>> points) {
        int len = points.size();
        long cur, pre = 0;
        for (int i = 0; i < len; i++) {
            int x1 = points.get((i + 1) % len).get(0) - points.get(i).get(0);
            int x2 = points.get((i + 2) % len).get(0) - points.get(i).get(0);
            int y1 = points.get((i + 1) % len).get(1) - points.get(i).get(1);
            int y2 = points.get((i + 2) % len).get(1) - points.get(i).get(1);
            cur = x1 * y2 - x2 * y1;
            if (cur != 0 && cur * pre < 0) {
                return false;
            }
            if (cur != 0) {
                pre = cur;
            }
        }
        return true;
    }
}
