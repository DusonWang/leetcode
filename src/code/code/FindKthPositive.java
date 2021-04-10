package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * ����һ�� �ϸ���������?������������ arr?��һ������?k?��
 * <p>
 * �����ҵ�����������?k?��ȱʧ����������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [2,3,4,7,11], k = 5
 * �����9
 * ���ͣ�ȱʧ������������ [1,5,6,8,9,10,12,13,...] ���� 5 ��ȱʧ��������Ϊ 9 ��
 * ʾ�� 2��
 * <p>
 * ���룺arr = [1,2,3,4], k = 2
 * �����6
 * ���ͣ�ȱʧ������������ [5,6,7,...] ���� 2 ��ȱʧ��������Ϊ 6 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * ��������?1 <= i < j <= arr.length?�� i?�� j ����?arr[i] < arr[j]?
 * ͨ������12,283�ύ����22,874
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/kth-missing-positive-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindKthPositive {

    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) return k;
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return k + left;
    }

}
