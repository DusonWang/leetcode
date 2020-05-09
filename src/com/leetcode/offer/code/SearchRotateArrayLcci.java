package com.leetcode.offer.code;

/**
 * @author duson
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * 示例2:
 * <p>
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 * 提示:
 * <p>
 * arr 长度范围在[1, 1000000]之间
 * 通过次数1,505提交次数3,720
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRotateArrayLcci {

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (left != right && arr[left] == arr[right]) {
                right--;
                continue;
            }
            int mid = (right + left) / 2;
            if (target == arr[mid] && (mid == 0 || target != arr[mid - 1])) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= arr[mid] && target <= arr[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
