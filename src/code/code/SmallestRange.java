package code.code;

import java.util.*;

/**
 * @author duson
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * <p>
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * <p>
 * 示例 1:
 * <p>
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 * 注意:
 * <p>
 * 给定的列表可能包含重复元素，所以在这里升序表示 >= 。
 * 1 <= k <= 3500
 * -105 <= 元素的值 <= 105
 * 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestRange {

    public int[] smallestRange(List<List<Integer>> a) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> a.get(o[0]).get(o[1])));

        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            q.offer(new int[]{i, 0});
            max = Math.max(max, a.get(i).get(0));
        }

        while (q.size() == a.size()) {
            int[] e = q.poll();
            if (e == null) {
                break;
            }
            int row = e[0], col = e[1];
            if (end - start > max - a.get(row).get(col)) {
                start = a.get(row).get(col);
                end = max;
            }
            if (col + 1 < a.get(row).size()) {
                q.offer(new int[]{row, col + 1});
                max = Math.max(max, a.get(row).get(col + 1));
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        SmallestRange smallestRange = new SmallestRange();
        List<List<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(4, 10, 15, 24, 26)));
        a.add(new ArrayList<>(Arrays.asList(0, 9, 12, 20)));
        a.add(new ArrayList<>(Arrays.asList(5, 18, 22, 30)));
        System.out.println(Arrays.toString(smallestRange.smallestRange(a)));
    }
}
