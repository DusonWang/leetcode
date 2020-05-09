package com.leetcode.offer.code;

/**
 * @author duson
 * ������ת���顣����һ�����������飬����n������������������ѱ���ת���ܶ���ˣ��������ꡣ���д�����ҳ������е�ĳ��Ԫ�أ���������Ԫ��ԭ���ǰ��������еġ����ж����ͬԪ�أ���������ֵ��С��һ����
 * <p>
 * ʾ��1:
 * <p>
 * ����: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * ���: 8��Ԫ��5�ڸ������е�������
 * ʾ��2:
 * <p>
 * ���룺arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * �����-1 ��û���ҵ���
 * ��ʾ:
 * <p>
 * arr ���ȷ�Χ��[1, 1000000]֮��
 * ͨ������1,505�ύ����3,720
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-rotate-array-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
