package code.code;

import java.util.TreeSet;

/**
 * ������������������ nums1 �� nums2 ������ĳ��ȶ��� n ��
 * <p>
 * ���� nums1 �� nums2 �� ���Բ�ֵ�� ����Ϊ���� |nums1[i] - nums2[i]|��0 <= i < n���� �ܺͣ��±�� 0 ��ʼ����
 * <p>
 * �����ѡ�� nums1 �е� ����һ�� Ԫ�����滻 nums1 �е� ���� һ��Ԫ�أ��� ��С�� ���Բ�ֵ�͡�
 * <p>
 * ���滻���� nums1 �����һ��Ԫ�� ֮�� ��������С���Բ�ֵ�͡���Ϊ�𰸿��ܴܺ�������Ҫ�� 109 + 7 ȡ�� �󷵻ء�
 * <p>
 * |x| ����Ϊ��
 * <p>
 * ��� x >= 0 ��ֵΪ x ������
 * ��� x <= 0 ��ֵΪ -x
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [1,7,5], nums2 = [2,3,5]
 * �����3
 * ���ͣ������ֿ��ܵ����ŷ�����
 * - ���ڶ���Ԫ���滻Ϊ��һ��Ԫ�أ�[1,7,5] => [1,1,5] ������
 * - ���ڶ���Ԫ���滻Ϊ������Ԫ�أ�[1,7,5] => [1,5,5]
 * ���ַ����ľ��Բ�ֵ�Ͷ��� |1-2| + (|1-3| ���� |5-3|) + |5-5| = 3
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * �����0
 * ���ͣ�nums1 �� nums2 ��ȣ����Բ����滻Ԫ�ء����Բ�ֵ��Ϊ 0
 * ʾ�� 3��
 * <p>
 * ���룺nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * �����20
 * ���ͣ�����һ��Ԫ���滻Ϊ�ڶ���Ԫ�أ�[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * ���Բ�ֵ��Ϊ |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 * ͨ������5,383�ύ����13,729
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-absolute-sum-difference
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinAbsoluteSumDiff {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        int inf = (int) 1e9;
        set.add(-inf);
        set.add(inf);
        for (int x : nums1) {
            set.add(x);
        }
        long sum = 0;
        int diff = 0;
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            int y = nums2[i];
            int cost = Math.abs(x - y);
            diff = Math.max(diff, Math.max(cost - (y - set.floor(y)), cost - (set.ceiling(y) - y)));
            sum += cost;
        }
        sum -= diff;
        int mod = (int) 1e9 + 7;
        return (int) (sum % mod);
    }

    public static void main(String[] args) {
        MinAbsoluteSumDiff minAbsoluteSumDiff = new MinAbsoluteSumDiff();
        System.out.println(minAbsoluteSumDiff.minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));

        System.out.println(minAbsoluteSumDiff.minAbsoluteSumDiff(new int[]{1, 28, 21}, new int[]{9, 21, 20}));
    }
}
