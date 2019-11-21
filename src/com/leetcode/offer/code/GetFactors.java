package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 整数可以被看作是其因子的乘积。
 * <p>
 * 例如：
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 * <p>
 * 注意：
 * <p>
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 * <p>
 * 输入: 1
 * 输出: []
 * 示例 2：
 * <p>
 * 输入: 37
 * 输出: []
 * 示例 3：
 * <p>
 * 输入: 12
 * 输出:
 * [
 * [2, 6],
 * [2, 2, 3],
 * [3, 4]
 * ]
 * 示例 4:
 * <p>
 * 输入: 32
 * 输出:
 * [
 * [2, 16],
 * [2, 2, 8],
 * [2, 2, 2, 4],
 * [2, 2, 2, 2, 2],
 * [2, 4, 4],
 * [4, 8]
 * ]
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factor-combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetFactors {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        trace(n, list, tmp);
        return list;
    }

    private void trace(int n, List<List<Integer>> list, List<Integer> tmp) {
        if (n == 1 && tmp.size() > 1) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                if (tmp.size() == 0 || i >= tmp.get(tmp.size() - 1)) {
                    tmp.add(i);
                    trace(n / i, list, tmp);
                    tmp.remove(tmp.size() - 1);

                }
            }
        }
    }
}
