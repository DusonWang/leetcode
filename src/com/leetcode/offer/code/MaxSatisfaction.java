package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 一个厨师收集了他?n?道菜的满意程度?satisfaction?，这个厨师做出每道菜的时间都是 1 单位时间。
 * <p>
 * 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是?time[i]*satisfaction[i]?。
 * <p>
 * 请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
 * <p>
 * 你可以按?任意?顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：satisfaction = [-1,-8,0,5,-9]
 * 输出：14
 * 解释：去掉第二道和最后一道菜，最大的喜爱时间系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。
 * 示例 2：
 * <p>
 * 输入：satisfaction = [4,3,2]
 * 输出：20
 * 解释：按照原来顺序相反的时间做菜 (2*1 + 3*2 + 4*3 = 20)
 * 示例 3：
 * <p>
 * 输入：satisfaction = [-1,-4,-5]
 * 输出：0
 * 解释：大家都不喜欢这些菜，所以不做任何菜可以获得最大的喜爱时间系数。
 * 示例 4：
 * <p>
 * 输入：satisfaction = [-2,5,-1,0,3,-3]
 * 输出：35
 * ?
 * <p>
 * 提示：
 * <p>
 * n == satisfaction.length
 * 1 <= n <= 500
 * -10^3 <=?satisfaction[i] <= 10^3
 * 通过次数2,747提交次数3,788
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reducing-dishes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSatisfaction {

    public int maxSatisfaction(int[] s) {
        int prevCo = 0, prevSum = 0;
        Arrays.sort(s);
        for(int i = s.length - 1; i > -1; i--) {
            int temp = prevCo + prevSum + s[i];
            if(temp < prevCo) {
                break;
            }
            prevCo = temp;
            prevSum += s[i];
        }
        return prevCo;
    }
}
