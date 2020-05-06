package com.leetcode.offer.code;

/**
 * 给你一个整数数组?arr， 对于元素 x ，只有当 x + 1 也在数组?arr 里时，才能记为 1 个数。
 * <p>
 * 如果数组?arr 里有重复的数，每个重复的数单独计算。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3]
 * 输出：2
 * 解释：1 和 2 被计算次数因为 2 和 3 在数组 arr 里。
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,3,3,5,5,7,7]
 * 输出：0
 * 解释：所有的数都不算, 因为数组里没有 2、4、6、8。
 * 示例 3：
 * <p>
 * 输入：arr = [1,3,2,3,5,0]
 * 输出：3
 * 解释：0、1、2 被计算了因为 1、2、3 在数组里。
 * 示例 4：
 * <p>
 * 输入：arr = [1,1,2,2]
 * 输出：2
 * 解释：两个 1 被计算了因为有 2 在数组里。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 0 <= arr[i] <= 1000
 * 通过次数30提交次数67
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountElements {

    public int countElements(int[] arr) {
        int[] count = new int[1002];
        int result = 0;
        for (int a : arr) {
            count[a]++;
        }

        for (int a : arr) {
            if (count[a + 1] > 0) {
                result++;
            }
        }
        return result;
    }
}
