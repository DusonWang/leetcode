package code.code;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxPoints {

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Map<Pair, Integer> map = new HashMap<>();
        int mx = 1;
        for (int i = 0; i < points.length; i++) {
            int rep = 1;
            int norep = 0;
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                if (xi == xj && yi == yj) {
                    rep++;
                    continue;
                }
                int nx = xj - xi, ny = yj - yi, gcdn = gcd(nx, ny);
                nx /= gcdn;
                ny /= gcdn;
                Pair pair = new Pair<>(nx, ny);
                if (map.containsKey(pair)) {
                    map.put(pair, map.get(pair) + 1);
                } else {
                    map.put(pair, 1);
                }
                norep = Math.max(norep, map.get(pair));
            }
            mx = Math.max(mx, norep + rep);
        }
        return mx;
    }

    public int maxPoints2(int[][] points) {
        int n = points.length;
        if (points.length <= 2) {
            return n;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int same = 1;
            for (int j = i + 1; j < n; j++) {
                int cnt = 0;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    same++;
                } else {
                    cnt++;
                    long xDiff = points[i][0] - points[j][0];
                    long yDiff =  points[i][1] - points[j][1];
                    for (int k = j + 1; k < n; k++) {
                        if (xDiff * (points[i][1] - points[k][1]) == yDiff * (points[i][0] - points[k][0])) {
                            cnt++;
                        }
                    }
                }
                max = Math.max(max, cnt + same);
            }
        }
        return max;
    }
}
