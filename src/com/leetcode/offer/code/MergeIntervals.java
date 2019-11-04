package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeIntervals {

    public class Interval {
        int start;
        int end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        final int len = intervals.length;
        final boolean[] merged = new boolean[len];
        int mergedCount = 0;

        for (int i = 0; i < len; i++) {
            int[] a = intervals[i];
            for (int j = i + 1; j < len; j++) {
                int[] b = intervals[j];
                if (a[1] >= b[0] && a[0] <= b[1]) {
                    merged[i] = true;
                    mergedCount++;

                    b[0] = Math.min(a[0], b[0]);
                    b[1] = Math.max(a[1], b[1]);
                    break;
                }
            }
        }
        int[][] result = new int[len - mergedCount][];
        for (int i = 0, pos = 0; i < len; i++) {
            if (!merged[i]) {
                result[pos++] = intervals[i];
            }
        }
        return result;
    }
//
//    public int[][] mergeTmp(int[][] intervals) {
//        if (intervals == null || intervals.length == 0) {
//            return intervals;
//        }
//        Interval[] intervals1 = new Interval[intervals.length];
//        for (int i = 0; i < intervals.length; i++) {
//            intervals1[i] = new Interval(intervals[i][0], intervals[i][1]);
//        }
//        Arrays.sort(intervals1, Comparator.comparingInt(a -> a.start));
//
//        List<Interval> merged = new ArrayList<>();
//        for (Interval interval : intervals1) {
//            if (merged.isEmpty() || merged.get(merged.size() - 1).end < interval.start) {
//                merged.add(interval);
//            } else {
//                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, interval.end);
//            }
//        }
//        int[][] results = new int[merged.size()][2];
//        int i = 0;
//        for (Interval interval : merged) {
//            results[i] = new int[]{interval.start, interval.end};
//            i++;
//        }
//        return results;
//    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = new int[][]{
                {1, 3}, {1, 2}, {2, 6}, {8, 10}, {15, 18}
        };

        System.out.println(Arrays.deepToString(mergeIntervals.merge(intervals)));
    }
}
