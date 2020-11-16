package code.code;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author duson
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 * <p>
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 *  
 * <p>
 * 进阶：
 * 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 * <p>
 * 提示：
 * 特别感谢 @yunhong 提供了本问题和其测试用例。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SummaryRanges2 {

    private TreeMap<Integer, Integer> intervals;

    public SummaryRanges2() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> lowerBound = intervals.floorEntry(val);
        if (lowerBound != null && lowerBound.getKey() <= val && lowerBound.getValue() >= val) {
            return;
        }

        Map.Entry<Integer, Integer> upperBound = intervals.floorEntry(val + 1);
        int newValue = val;

        boolean replaceLower = false;
        boolean deleteUpper = false;

        if (lowerBound != null && lowerBound.getValue() == val - 1) {
            replaceLower = true;
        }

        if (upperBound != null && upperBound.getKey() == val + 1) {
            deleteUpper = true;
            newValue = upperBound.getValue();
        }

        if (deleteUpper) {
            intervals.remove(upperBound.getKey());
        }
        if (replaceLower) {
            intervals.replace(lowerBound.getKey(), newValue);
        } else {
            intervals.put(val, newValue);
        }

    }

    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }
        return result;
    }
}
