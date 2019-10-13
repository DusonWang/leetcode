package com.leetcode.offer.day46;

/**
 * @author duson
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 3
 * <p>
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinMoves {

    public int minMoves(int[] nums) {
        int moves = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            moves += num;
        }
        return moves - min * nums.length;
    }
}
