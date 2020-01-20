package com.leetcode.offer.code;

/**
 * @author duson
 * 为了更好地评估这份计划，对于卡路里表中的每一天，你都需要计算他 「这一天以及之后的连续几天」 （共 k 天）内消耗的总卡路里 T：
 * <p>
 * 如果 T < lower，那么这份计划相对糟糕，并失去 1 分； 
 * 如果 T > upper，那么这份计划相对优秀，并获得 1 分；
 * 否则，这份计划普普通通，分值不做变动。
 * 请返回统计完所有 calories.length 天后得到的总分作为评估结果。
 * <p>
 * 注意：总分可能是负数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
 * 输出：0
 * 解释：calories[0], calories[1] < lower 而 calories[3], calories[4] > upper, 总分 = 0.
 * 示例 2：
 * <p>
 * 输入：calories = [3,2], k = 2, lower = 0, upper = 1
 * 输出：1
 * 解释：calories[0] + calories[1] > upper, 总分 = 1.
 * 示例 3：
 * <p>
 * 输入：calories = [6,5,0,0], k = 2, lower = 1, upper = 5
 * 输出：0
 * 解释：calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, 总分 = 0.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= calories.length <= 10^5
 * 0 <= calories[i] <= 20000
 * 0 <= lower <= upper
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diet-plan-performance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DietPlanPerformance {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int index = 0;
        int totalScore = 0;
        int sumCalorie = 0;
        int caloriesSize = calories.length;
        while (index < k) {
            sumCalorie += calories[index++];
        }
        while (index <= caloriesSize) {
            if (sumCalorie < lower) {
                totalScore--;
            } else if (sumCalorie > upper) {
                totalScore++;
            }
            if (index == caloriesSize) {
                break;
            }
            sumCalorie -= calories[index - k];
            sumCalorie += calories[index];
            index++;
        }
        return totalScore;
    }
}
