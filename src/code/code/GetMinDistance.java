package code.code;

/**
 * ����һ���������� nums ���±� �� 0 ��ʼ �������Լ��������� target �� start �������ҳ�һ���±� i ������ nums[i] == target �� abs(i - start) ��С�� ��ע�⣺abs(x) ��ʾ x �ľ���ֵ��
 * <p>
 * ���� abs(i - start) ��
 * <p>
 * ��Ŀ���ݱ�֤ target ������ nums �С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,4,5], target = 5, start = 3
 * �����1
 * ���ͣ�nums[4] = 5 ��Ψһһ������ target ��ֵ�����Դ��� abs(4 - 3) = 1 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1], target = 1, start = 0
 * �����0
 * ���ͣ�nums[0] = 1 ��Ψһһ������ target ��ֵ�����Դ��� abs(0 - 0) = 1 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
 * �����0
 * ���ͣ�nums �е�ÿ��ֵ���� 1 ���� nums[0] ʹ abs(i - start) �Ľ��������С�������Դ��� abs(0 - 0) = 0 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * 0 <= start < nums.length
 * target ������ nums ��
 * ͨ������3,499�ύ����4,985
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-distance-to-the-target-element
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetMinDistance {

    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(i - start));
            }
        }
        return min;
    }
}
