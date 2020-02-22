package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个形如 “HH:MM” 表示的时刻，利用当前出现过的数字构造下一个距离当前时间最近的时刻。每个出现数字都可以被无限次使用。
 * <p>
 * 你可以认为给定的字符串一定是合法的。例如，“01:34” 和 “12:09” 是合法的，“1:34” 和 “12:9” 是不合法的。
 * <p>
 *  
 * <p>
 * 样例 1:
 * <p>
 * 输入: "19:34"
 * 输出: "19:39"
 * 解释: 利用数字 1, 9, 3, 4 构造出来的最近时刻是 19:39，是 5 分钟之后。结果不是 19:33 因为这个时刻是 23 小时 59 分钟之后。
 *  
 * <p>
 * 样例 2:
 * <p>
 * 输入: "23:59"
 * 输出: "22:22"
 * 解释: 利用数字 2, 3, 5, 9 构造出来的最近时刻是 22:22。 答案一定是第二天的某一时刻，所以选择可构造的最小时刻。
 *  
 * <p>
 * 通过次数582提交次数1,241
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-closest-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextClosestTime {

    public String nextClosestTime(String time) {
        int[] times = new int[4];
        times[0] = time.charAt(0) - '0';
        times[1] = time.charAt(1) - '0';
        times[2] = time.charAt(3) - '0';
        times[3] = time.charAt(4) - '0';
        String result = time;
        int currMin = Integer.MAX_VALUE;
        int startHour = Integer.parseInt(time.substring(0, 2));
        int startMin = Integer.parseInt(time.substring(3, 5));
        int startTime = startHour * 60 + startMin;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int m = 0; m < 4; m++) {
                    for (int n = 0; n < 4; n++) {
                        int hour = times[i] * 10 + times[j];
                        int min = times[m] * 10 + times[n];
                        if (hour == startHour && min == startMin) {
                            continue;
                        }
                        if (hour < 24 && min < 60) {
                            int currTime = hour * 60 + min;
                            if (currTime > startTime && currTime - startTime < currMin || (currTime < startTime && currTime + 2400 - startTime < currMin)) {
                                String reHour = (hour < 10) ? "0" + hour : String.valueOf(hour);
                                String reMin = (min < 10) ? "0" + min : String.valueOf(min);
                                result = reHour + ":" + reMin;
                                currMin = (currTime > startTime) ? currTime - startTime : currTime + 2400 - startTime;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
