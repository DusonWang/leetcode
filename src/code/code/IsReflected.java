package code.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author duson
 * 在一个二维平面空间中，给你 n 个点的坐标。问，是否能找出一条平行于 y 轴的直线，让这些点关于这条直线成镜像排布？
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1,1],[-1,1]]
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: [[1,1],[-1,-1]]
 * 输出: false
 * 拓展：
 * 你能找到比 O(n2) 更优的解法吗?
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/line-reflection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsReflected {

    public boolean isReflected(int[][] points) {
        if (points == null || points.length < 2) {
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] arr : points) {
            min = Math.min(min, arr[0]);
            max = Math.max(max, arr[0]);
            Set<Integer> set = map.computeIfAbsent(arr[0], k -> new HashSet<>());
            set.add(arr[1]);
        }
        int y = min + max;
        for (int[] arr : points) {
            int left = arr[0];
            int right = y - left;
            if (map.get(right) == null || !map.get(right).contains(arr[1])) {
                return false;
            }
        }
        return true;
    }
}
