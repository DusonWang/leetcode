package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 你将获得多条日志，每条日志都有唯一的 id 和 timestamp，timestamp 是形如 Year:Month:Day:Hour:Minute:Second 的字符串，例如 2017:01:01:23:59:59，所有值域都是零填充的十进制数。
 * <p>
 * 设计一个日志存储系统实现如下功能：
 * <p>
 * void Put(int id, string timestamp)：给定日志的 id 和 timestamp，将这个日志存入你的存储系统中。
 * <p>
 *  
 * <p>
 * int[] Retrieve(String start, String end, String granularity)：返回在给定时间区间内的所有日志的 id。start 、 end 和 timestamp 的格式相同，granularity 表示考虑的时间级。比如，start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day" 代表区间 2017 年 1 月 1 日到 2017 年 1 月 2 日。
 * <p>
 *  
 * <p>
 *  
 * <p>
 * 样例 1 ：
 * <p>
 * put(1, "2017:01:01:23:59:59");
 * put(2, "2017:01:01:22:59:59");
 * put(3, "2016:01:01:00:00:00");
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // 返回值 [1,2,3]，返回从 2016 年到 2017 年所有的日志。
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // 返回值 [1,2], 返回从 2016:01:01:01 到 2017:01:01:23 区间内的日志，日志 3 不在区间内。
 *  
 * <p>
 * 注释 ：
 * <p>
 * Put 和 Retrieve 的指令总数不超过 300。
 * 年份的区间是 [2000,2017]，小时的区间是 [00,23]。
 * Retrieve 的输出顺序不作要求。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-log-storage-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LogSystem {

    private List<String[]> list;

    private final List<String> unit = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");

    private final int[] sub = new int[]{4, 7, 10, 13, 16, 19};

    public LogSystem() {
        list = new ArrayList<>();
    }

    public void put(int id, String timestamp) {
        list.add(new String[]{String.valueOf(id), timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        int subUnit = sub[unit.indexOf(gra)];
        String s1 = s.substring(0, subUnit);
        String e1 = e.substring(0, subUnit);
        for (String[] l : list) {
            String l1 = l[1].substring(0, subUnit);
            if (l1.compareTo(s1) >= 0 && l1.compareTo(e1) <= 0) {
                res.add(Integer.parseInt(l[0]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        System.out.println(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));

    }
}
