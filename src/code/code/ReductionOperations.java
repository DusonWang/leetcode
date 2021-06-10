package code.code;

import java.util.Arrays;

/**
 * ����һ���������� nums �����Ŀ������ nums �е�����Ԫ����ȡ����һ�μ��ٲ�����Ҫ��������ļ������裺
 * <p>
 * �ҳ� nums �е� ��� ֵ�������ֵΪ largest ��ȡ���±� i ���±�� 0 ��ʼ������������ж��Ԫ�ض������ֵ����ȡ��С�� i ��
 * �ҳ� nums �е� ��һ����� ֵ�����ֵ �ϸ�С�� largest ����Ϊ nextLargest ��
 * �� nums[i] ���ٵ� nextLargest ��
 * ����ʹ nums �е�����Ԫ����ȵĲ���������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [5,1,3]
 * �����3
 * ���ͣ���Ҫ 3 �β���ʹ nums �е�����Ԫ����ȣ�
 * 1. largest = 5 �±�Ϊ 0 ��nextLargest = 3 ���� nums[0] ���ٵ� 3 ��nums = [3,1,3] ��
 * 2. largest = 3 �±�Ϊ 0 ��nextLargest = 1 ���� nums[0] ���ٵ� 1 ��nums = [1,1,3] ��
 * 3. largest = 3 �±�Ϊ 2 ��nextLargest = 1 ���� nums[2] ���ٵ� 1 ��nums = [1,1,1] ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,1,1]
 * �����0
 * ���ͣ�nums �е�����Ԫ���Ѿ�����ȵġ�
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,1,2,2,3]
 * �����4
 * ���ͣ���Ҫ 4 �β���ʹ nums �е�����Ԫ����ȣ�
 * 1. largest = 3 �±�Ϊ 4 ��nextLargest = 2 ���� nums[4] ���ٵ� 2 ��nums = [1,1,2,2,2] ��
 * 2. largest = 2 �±�Ϊ 2 ��nextLargest = 1 ���� nums[2] ���ٵ� 1 ��nums = [1,1,1,2,2] ��
 * 3. largest = 2 �±�Ϊ 3 ��nextLargest = 1 ���� nums[3] ���ٵ� 1 ��nums = [1,1,1,1,2] ��
 * 4. largest = 2 �±�Ϊ 4 ��nextLargest = 1 ���� nums[4] ���ٵ� 1 ��nums = [1,1,1,1,1] ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 5 * 104
 * 1 <= nums[i] <= 5 * 104
 * ͨ������4,066�ύ����6,401
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reduction-operations-to-make-the-array-elements-equal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ReductionOperations {

    public int reductionOperations2(int[] nums) { // Jay
        int[] cache = new int[50001];
        for (int num : nums) {
            cache[num]++;
        }
        int ans = 0;
        int count = 0;
        for (int i = cache.length - 1; i >= 0; i--) {
            if (cache[i] > 0) {
                ans += count;
                count += cache[i];
            }
        }
        return ans;
    }

    public int reductionOperations(int[] nums) {
        int res = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int j = len - 1; j > 0; --j) {
            if (nums[j - 1] != nums[j]) {
                res += len - j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReductionOperations reductionOperations = new ReductionOperations();
        System.out.println(reductionOperations.reductionOperations(new int[]{5, 1, 3}));
        System.out.println(reductionOperations.reductionOperations(new int[]{1, 2, 3}));
        System.out.println(reductionOperations.reductionOperations(new int[]{1, 1, 1}));
        System.out.println(reductionOperations.reductionOperations(new int[]{1, 1, 2, 2, 3}));
    }
}
