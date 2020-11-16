package code.code;

/**
 * @author duson
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * <p>
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 * 通过次数2,104提交次数4,862
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-days-between-two-dates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DaysBetweenDates {

    private final int[][] Month = {{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    private final int[] Day = {365, 366};

    public int daysBetweenDates(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        int year1 = Integer.parseInt(d1[0]), year2 = Integer.parseInt(d2[0]);
        int month1 = Integer.parseInt(d1[1]), month2 = Integer.parseInt(d2[1]);
        int day1 = Integer.parseInt(d1[2]), day2 = Integer.parseInt(d2[2]);
        int s1 = gap(year1, month1, day1);
        int s2 = gap(year2, month2, day2);
        return Math.abs(s1 - s2);
    }

    private int gap(int year, int month, int day) {
        int sum = 0;
        int flag = isleap(year);
        for (int i = 1971; i < year; i++) {
            sum += Day[isleap(i)];
        }
        for (int i = 1; i < month; i++) {
            sum += Month[flag][i];
        }
        sum += day;
        return sum;
    }

    private int isleap(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return 1;
        }
        return 0;
    }
}
