package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * ����һ������ nums��������г�ȡһ�������У�����������е�Ԫ��֮�� �ϸ� ����δ�����ڸ��������еĸ�Ԫ��֮�͡�
 * <p>
 * ������ڶ�����������ֻ�践�� ������С �������С������Ȼ�ж������������򷵻� Ԫ��֮����� �������С�
 * <p>
 * �������鲻ͬ�ĵط����ڣ�������������С���ǿ��Ԫ����ԭ�����е������ԣ�Ҳ����˵��������ͨ���������з���һЩ��Ҳ���ܲ����룩Ԫ�صõ���
 * <p>
 * ע�⣬��Ŀ���ݱ�֤��������Լ�������Ľ�������� Ψһ �ġ�ͬʱ�����صĴ�Ӧ���� �ǵ���˳�� ���С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [4,3,10,9,8]
 * �����[10,9]
 * ���ͣ������� [10,9] �� [10,8] ����С�ġ�����Ԫ��֮�ʹ���������Ԫ��֮�͵������С����� [10,9] ��Ԫ��֮�����?
 * ʾ�� 2��
 * <p>
 * ���룺nums = [4,4,7,6,7]
 * �����[7,7,6]
 * ���ͣ������� [7,7] �ĺ�Ϊ 14 �����ϸ����ʣ�µ�����Ԫ��֮�ͣ�14 = 4 + 4 + 6������ˣ�[7,6,7] �������������С�����С�ע�⣬Ԫ�ذ��ǵ���˳�򷵻ء�
 * ʾ�� 3��
 * <p>
 * ���룺nums = [6]
 * �����[6]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 100
 * ͨ������6,002�ύ����8,514
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0, sum1 = 0;
        for (int a : nums) {
            sum += a;
        }
        int i = nums.length - 1;
        while (i >= 0) {
            sum -= nums[i];
            sum1 += nums[i];
            list.add(nums[i]);
            if (sum1 > sum) {
                return list;
            }
            i--;
        }
        return list;
    }
}
