package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * 如果一个整数上的每一位数字与其相邻位上的数字的绝对差都是 1，那么这个数就是一个「步进数」。
 * <p>
 * 例如，321 是一个步进数，而 421 不是。
 * <p>
 * 给你两个整数，low 和 high，请你找出在 [low, high] 范围内的所有步进数，并返回 排序后 的结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：low = 0, high = 21
 * 输出：[0,1,2,3,4,5,6,7,8,9,10,12,21]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= low <= high <= 2 * 10^9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stepping-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSteppingNumbers {

    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= 9; i++) {
            dfs(list, i);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : list) {
            if (num >= low && num <= high) {
                result.add(num);
            }
        }
        Collections.sort(result);
        return result;
    }

    public void dfs(List<Integer> list, int cur) {
        list.add(cur);
        if (cur > Integer.MAX_VALUE / 10) {
            return;
        }
        int r = cur % 10;
        if (r != 9) {
            dfs(list, cur * 10 + r + 1);
        }
        if (r != 0) {
            dfs(list, cur * 10 + r - 1);
        }
    }
}
