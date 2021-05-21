package code.code;

import java.util.Arrays;

/**
 * ����һ�� ����?����?nums?������?n?���Ǹ�������ɣ�ͬʱ����һ������?maximumBit?������Ҫִ�����²�ѯ n?�Σ�
 * <p>
 * �ҵ�һ���Ǹ�����?k < 2maximumBit?��ʹ��?nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k?�Ľ�� ���?��k?�ǵ� i?����ѯ�Ĵ𰸡�
 * �ӵ�ǰ����?nums?ɾ��?���?һ��Ԫ�ء�
 * ���㷵��һ������?answer?������?answer[i]�ǵ�?i?����ѯ�Ľ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [0,1,1,3], maximumBit = 2
 * �����[0,3,2,3]
 * ���ͣ���ѯ�Ĵ����£�
 * ��һ����ѯ��nums = [0,1,1,3]��k = 0����Ϊ 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3 ��
 * �ڶ�����ѯ��nums = [0,1,1]��k = 3����Ϊ 0 XOR 1 XOR 1 XOR 3 = 3 ��
 * ��������ѯ��nums = [0,1]��k = 2����Ϊ 0 XOR 1 XOR 2 = 3 ��
 * ���ĸ���ѯ��nums = [0]��k = 3����Ϊ 0 XOR 3 = 3 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [2,3,4,7], maximumBit = 3
 * �����[5,2,6,5]
 * ���ͣ���ѯ�Ĵ����£�
 * ��һ����ѯ��nums = [2,3,4,7]��k = 5����Ϊ 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7��
 * �ڶ�����ѯ��nums = [2,3,4]��k = 2����Ϊ 2 XOR 3 XOR 4 XOR 2 = 7 ��
 * ��������ѯ��nums = [2,3]��k = 6����Ϊ 2 XOR 3 XOR 6 = 7 ��
 * ���ĸ���ѯ��nums = [2]��k = 5����Ϊ 2 XOR 5 = 7 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [0,1,2,2,5,7], maximumBit = 3
 * �����[4,3,6,4,6,7]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * nums.length == n
 * 1 <= n <= 105
 * 1 <= maximumBit <= 20
 * 0 <= nums[i] < 2maximumBit
 * nums??? �е������Ѿ���?����?�ź���
 * ͨ������3,312�ύ����4,988
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-xor-for-each-query
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetMaximumXor {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int max = (1 << (maximumBit)) - 1;
        int[] ks = new int[nums.length];
        int n = nums.length;
        int s = 0;
        for (int i = 0; i < n; i++) {
            s ^= nums[i];
            ks[n - 1 - i] = max ^ s;
        }
        return ks;
    }

    public static void main(String[] args) {
        GetMaximumXor getMaximumXor = new GetMaximumXor();
        System.out.println(Arrays.toString(getMaximumXor.getMaximumXor(new int[]{0, 1, 1, 3}, 2)));
        System.out.println(Arrays.toString(getMaximumXor.getMaximumXor(new int[]{2, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(getMaximumXor.getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3)));

    }
}
