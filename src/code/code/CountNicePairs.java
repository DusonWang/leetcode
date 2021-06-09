package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ������nums��������ֻ�����Ǹ�����������rev(x)��ֵΪ������x��������λ��ת�õ��Ľ�����ȷ�˵rev(123) = 321��rev(120) = 21�����ǳ����������������±��(i, j) �Ǻõģ�
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * ���㷵�غ��±�Ե���Ŀ�����ڽ�����ܻ�ܴ��뽫�����109 + 7ȡ��󷵻ء�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [42,11,1,97]
 * �����2
 * ���ͣ����������Ϊ��
 * - (0,3)��42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 ��
 * - (1,2)��11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [13,10,35,24,76]
 * �����4
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * ͨ������3,077�ύ����9,176
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-nice-pairs-in-an-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountNicePairs {

    public int rev(int num) {
        int res = 0;
        while (num > 0) {
            int mod = num % 10;
            num /= 10;
            res = res * 10 + mod;
        }
        return res;
    }

    public int countNicePairs(int[] nums) {
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int key = num - rev(num);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        long result = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            long times = entry.getValue();
            result = (result + times * (times - 1) / 2) % mod;
        }
        return (int) (result % mod);
    }

    public static void main(String[] args) {
        CountNicePairs countNicePairs = new CountNicePairs();
        System.out.println(countNicePairs.countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println(countNicePairs.countNicePairs(new int[]{13, 10, 35, 24, 76}));

    }
}
