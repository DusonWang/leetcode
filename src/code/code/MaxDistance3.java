package code.code;

/**
 * �������� �ǵ��� ���������� nums1?????? �� nums2?????? �������±�� �� 0 ��ʼ ������
 * <p>
 * �±�� (i, j) �� 0 <= i < nums1.length �� 0 <= j < nums2.length ��������±��ͬʱ���� i <= j �� nums1[i] <= nums2[j] �����֮Ϊ ��Ч �±�ԣ����±�Ե� ���� Ϊ j - i?? ��??
 * <p>
 * �������� ��Ч �±�� (i, j) �е� ������ �������������Ч�±�ԣ����� 0 ��
 * <p>
 * һ������ arr �����ÿ�� 1 <= i < arr.length ���� arr[i-1] >= arr[i] ��������ô��������һ�� �ǵ��� ���顣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
 * �����2
 * ���ͣ���Ч�±���� (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) �� (4,4) ��
 * �������� 2 ����Ӧ�±�� (2,4) ��
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [2,2,2], nums2 = [10,10,1]
 * �����1
 * ���ͣ���Ч�±���� (0,0), (0,1) �� (1,1) ��
 * �������� 1 ����Ӧ�±�� (0,1) ��
 * ʾ�� 3��
 * <p>
 * ���룺nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
 * �����2
 * ���ͣ���Ч�±���� (2,2), (2,3), (2,4), (3,3) �� (3,4) ��
 * �������� 2 ����Ӧ�±�� (2,4) ��
 * ʾ�� 4��
 * <p>
 * ���룺nums1 = [5,4], nums2 = [3,2]
 * �����0
 * ���ͣ���������Ч�±�ԣ����Է��� 0 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums1.length <= 105
 * 1 <= nums2.length <= 105
 * 1 <= nums1[i], nums2[j] <= 105
 * nums1 �� nums2 ���� �ǵ��� ����
 * ͨ������9,145�ύ����12,537
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-distance-between-a-pair-of-values
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxDistance3 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                p1++;
            }
            p2++;
        }
        return Math.max(p2 - p1 - 1, 0);
    }

    public static void main(String[] args) {
        MaxDistance3 maxDistance3 = new MaxDistance3();
        System.out.println(maxDistance3.maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));
    }
}
