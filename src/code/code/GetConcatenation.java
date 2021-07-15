package code.code;

/**
 * ����һ������Ϊ n ���������� nums �����㹹��һ������Ϊ 2n �Ĵ����� ans �������±� �� 0 ��ʼ���� ����������0 <= i < n �� i ��������������Ҫ��
 * <p>
 * ans[i] == nums[i]
 * ans[i + n] == nums[i]
 * ������ԣ�ans ������ nums ���� ���� �γɡ�
 * <p>
 * �������� ans ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,1]
 * �����[1,2,1,1,2,1]
 * ���ͣ����� ans ��������ʽ�γɣ�
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,3,2,1]
 * �����[1,3,2,1,1,3,2,1]
 * ���ͣ����� ans ��������ʽ�γɣ�
 * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 * - ans = [1,3,2,1,1,3,2,1]
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * n == nums.length
 * 1 <= n <= 1000
 * 1 <= nums[i] <= 1000
 * ͨ������5,529�ύ����5,762
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/concatenation-of-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetConcatenation {

    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] result = new int[len * 2];
        int k = 0;
        for (int m = 0; m < 2; m++) {
            for (int num : nums) {
                result[k++] = num;
            }
        }
        return result;
    }
}
