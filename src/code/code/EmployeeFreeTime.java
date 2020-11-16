package code.code;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author duson
 * 给定员工的 schedule 列表，表示每个员工的工作时间。
 * <p>
 * 每个员工都有一个非重叠的时间段  Intervals 列表，这些时间段已经排好序。
 * <p>
 * 返回表示 所有 员工的 共同，正数长度的空闲时间 的有限时间段的列表，同样需要排好序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * 输出：[[3,4]]
 * 解释：
 * 共有 3 个员工，并且所有共同的
 * 空间时间段是 [-inf, 1], [3, 4], [10, inf]。
 * 我们去除所有包含 inf 的时间段，因为它们不是有限的时间段。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * 输出：[[5,6],[7,9]]
 *  
 * <p>
 * （尽管我们用 [x, y] 的形式表示 Intervals ，内部的对象是 Intervals 而不是列表或数组。例如，schedule[0][0].start = 1, schedule[0][0].end = 2，并且 schedule[0][0][0] 是未定义的）
 * <p>
 * 而且，答案中不包含 [5, 5] ，因为长度为 0。
 * <p>
 *  
 * <p>
 * 注：
 * <p>
 * schedule 和 schedule[i] 为长度范围在 [1, 50]的列表。
 * 0 <= schedule[i].start < schedule[i].end <= 10^8。
 * 注：输入类型于 2019 年 4 月 15 日 改变。请重置为默认代码的定义以获取新方法。
 * <p>
 *  
 * <p>
 * 通过次数305提交次数525
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-free-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EmployeeFreeTime {

    static class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
//        List<int[]> events = new ArrayList<>();
//        for (List<Interval> employee : avails) {
//            for (Interval iv : employee) {
//                events.add(new int[]{iv.start, 0});
//                events.add(new int[]{iv.end, 1});
//            }
//        }
//        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
//        List<Interval> ans = new ArrayList<>();
//        int prev = -1, bal = 0;
//        for (int[] event : events) {
//            if (bal == 0 && prev >= 0) {
//                ans.add(new Interval(prev, event[0]));
//            }
//            bal += event[1] == 0 ? 1 : -1;
//            prev = event[0];
//        }
//        return ans;
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        avails.forEach(pq::addAll);
        Interval temp = pq.poll();
        while (!pq.isEmpty()) {
            if (temp == null) {
                break;
            }
            if (temp.end < pq.peek().start) {
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll();
            } else {
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return result;
    }
}
