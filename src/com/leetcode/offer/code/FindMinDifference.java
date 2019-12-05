package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["23:59","00:00"]
 * 输出: 1
 * <p>
 * 备注:
 * <p>
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinDifference {

    public int findMinDifference(List<String> timePoints) {
        int mm = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<>();

        for (String timePoint : timePoints) {
            int h = Integer.parseInt(timePoint.substring(0, 2));
            time.add(60 * h + Integer.parseInt(timePoint.substring(3, 5)));
        }

        time.sort(Integer::compareTo);

        for (int i = 1; i < time.size(); i++) {
            mm = Math.min(mm, time.get(i) - time.get(i - 1));
        }

        int corner = time.get(0) + (1440 - time.get(time.size() - 1));
        return Math.min(mm, corner);
    }
}
