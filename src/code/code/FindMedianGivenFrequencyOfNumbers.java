package code.code;

/**
 * @author duson
 * Numbers 表保存数字的值及其频率。
 * <p>
 * +----------+-------------+
 * |  Number  |  Frequency  |
 * +----------+-------------|
 * |  0       |  7          |
 * |  1       |  1          |
 * |  2       |  3          |
 * |  3       |  1          |
 * +----------+-------------+
 * 在此表中，数字为 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3，所以中位数是 (0 + 0) / 2 = 0。
 * <p>
 * +--------+
 * | median |
 * +--------|
 * | 0.0000 |
 * +--------+
 * 请编写一个查询来查找所有数字的中位数并将结果命名为 median
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-given-frequency-of-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianGivenFrequencyOfNumbers {

    //# Write your MySQL query statement below
    //select avg(Number) as median from (
    //  select Number, Frequency, AccFreq, SumFreq from
    //  (select    Number,
    //             Frequency, @curFreq := @curFreq + Frequency as AccFreq
    //   from      Numbers n, (select @curFreq := 0) r
    //   order by  Number) t1,
    //  (select sum(Frequency) as SumFreq from Numbers) t2
    //) t
    //where AccFreq between SumFreq / 2 and SumFreq / 2 + Frequency
}
