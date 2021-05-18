package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ���������������� nums1 �� nums2 �����㷵�ظ������¹����γɵ���Ԫ�����Ŀ������ 1 ������ 2 ����
 * <p>
 * ���� 1����Ԫ�� (i, j, k) ����� nums1[i]2?== nums2[j] * nums2[k] ���� 0 <= i < nums1.length �� 0 <= j < k < nums2.length
 * ���� 2����Ԫ�� (i, j, k) ����� nums2[i]2?== nums1[j] * nums1[k] ���� 0 <= i < nums2.length �� 0 <= j < k < nums1.length
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [7,4], nums2 = [5,2,8,9]
 * �����1
 * ���ͣ����� 1��(1,1,2), nums1[1]^2 = nums2[1] * nums2[2] (4^2 = 2 * 8)
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [1,1], nums2 = [1,1,1]
 * �����9
 * ���ͣ�������Ԫ�鶼������ĿҪ����Ϊ 1^2 = 1 * 1
 * ���� 1��(0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2), nums1[i]^2 = nums2[j] * nums2[k]
 * ���� 2��(0,0,1), (1,0,1), (2,0,1), nums2[i]^2 = nums1[j] * nums1[k]
 * ʾ�� 3��
 * <p>
 * ���룺nums1 = [7,7,8,3], nums2 = [1,2,9,7]
 * �����2
 * ���ͣ�������������ĿҪ�����Ԫ��
 * ���� 1��(3,0,2), nums1[3]^2 = nums2[0] * nums2[2]
 * ���� 2��(3,0,1), nums2[3]^2 = nums1[0] * nums1[1]
 * ʾ�� 4��
 * <p>
 * ���룺nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
 * �����0
 * ���ͣ������ڷ�����ĿҪ�����Ԫ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 1 <= nums1[i], nums2[i] <= 10^5
 * ͨ������4,702�ύ����14,767
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumTriplets {

    public int numTriplets(int[] a, int[] b) {
        return res(a, b) + res(b, a);
    }

    private int res(int[] a, int[] b) {
        int count = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (long i : a) {
            map.put(i * i, map.getOrDefault(i * i, 0) + 1);
        }
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = i + 1; j < b.length; j++) {
                long prod = (long) b[i] * b[j];
                if (map.containsKey(prod)) {
                    count += map.get(prod);
                }
            }
        }
        return count;
    }
}
