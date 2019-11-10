package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
 * <p>
 * 如果不存在这个只出现一次的整数，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,7,3,9,4,9,8,3,1]
 * 输出：8
 * 解释：
 * 数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
 * 示例 2：
 * <p>
 * 输入：[9,9,8,8]
 * 输出：-1
 * 解释：
 * 数组中不存在仅出现一次的整数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 2000
 * 0 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-unique-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestUniqueNumber {

    public int largestUniqueNumber(int[] a) {
        int[] count = new int[1001];
        for (int aa : a) {
            count[aa]++;
        }
        int min = -1;
        for (int i = 0; i < count.length; i++) {
            if (i > min && count[i] == 1) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        //[5,7,3,9,4,9,8,3,1]
        int[] a = new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1};
        LargestUniqueNumber largestUniqueNumber = new LargestUniqueNumber();
        System.out.println(largestUniqueNumber.largestUniqueNumber(a));
    }
}
