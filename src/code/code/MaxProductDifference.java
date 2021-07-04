package code.code;

/**
 * ��������?(a, b) �� (c, d) ֮��� �˻��� ����Ϊ (a * b) - (c * d) ��
 * <p>
 * ���磬(5, 6) �� (2, 7) ֮��ĳ˻����� (5 * 6) - (2 * 7) = 16 ��
 * ����һ���������� nums ��ѡ���ĸ� ��ͬ�� �±� w��x��y �� z ��ʹ���� (nums[w], nums[x]) �� (nums[y], nums[z]) ֮��� �˻��� ȡ�� ���ֵ ��
 * <p>
 * ���������ַ�ʽȡ�õĳ˻����е� ���ֵ ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [5,6,2,7,4]
 * �����34
 * ���ͣ�����ѡ���±�Ϊ 1 �� 3 ��Ԫ�ع��ɵ�һ������ (6, 7) �Լ��±� 2 �� 4 ���ɵڶ������� (2, 4)
 * �˻����� (6 * 7) - (2 * 4) = 34
 * ʾ�� 2��
 * <p>
 * ���룺nums = [4,2,5,9,7,4,8]
 * �����64
 * ���ͣ�����ѡ���±�Ϊ 3 �� 6 ��Ԫ�ع��ɵ�һ������ (9, 8) �Լ��±� 1 �� 5 ���ɵڶ������� (2, 4)
 * �˻����� (9 * 8) - (2 * 4) = 64
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 4 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 * ͨ������5,231�ύ����6,088
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-product-difference-between-two-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxProductDifference {

    public int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return max1 * max2 - min1 * min2;
    }
}
