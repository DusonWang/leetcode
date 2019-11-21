package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * <p>
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *  
 * <p>
 * 提示：
 * <p>
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int dayIndex = getDayIndex(day, month, year);
        return days[dayIndex];
    }

    private int getDayIndex(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int century = year / 100, year2 = year % 100;
        int index = year2 + year2 / 4 + century / 4 - 2 * century + 26 * (month + 1) / 10 + day - 1;
        index %= 7;
        if (index < 0) {
            index += 7;
        }
        return index;
    }

}
