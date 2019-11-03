package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个升序整数数组，写一个函数搜索 nums 中数字 target。如果 target 存在，返回它的下标，否则返回 -1。注意，这个数组的大小是未知的。你只可以通过 ArrayReader 接口访问这个数组，ArrayReader.get(k) 返回数组中第 k 个元素（下标从 0 开始）。
 * <p>
 * 你可以认为数组中所有的整数都小于 10000。如果你访问数组越界，ArrayReader.get 会返回 2147483647。
 * <p>
 *  
 * <p>
 * 样例 1：
 * <p>
 * 输入: array = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 存在在 nums 中，下标为 4
 * 样例 2：
 * <p>
 * 输入: array = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不在数组中所以返回 -1
 *  
 * <p>
 * 注释 ：
 * <p>
 * 你可以认为数组中所有元素的值互不相同。
 * 数组元素的值域是 [-9999, 9999]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-a-sorted-array-of-unknown-size
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {

    public static class ArrayReader {

        public int get(int k) {
            return 0;
        }
    }

    public int search(ArrayReader reader, int target) {
        int of = 2147483647;
        int i = 0;
        int j = 1;
        if (reader.get(0) == of) {
            return -1;
        }
        while (reader.get(j) != of) {
            j <<= 1;
        }
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int midValue = reader.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
