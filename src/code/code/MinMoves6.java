package code.code;

/**
 * ����һ������Ϊ ż�� n ���������� nums ��һ������ limit ��ÿһ�β���������Խ� nums �е��κ������滻Ϊ1��limit ֮�����һ��������
 * <p>
 * ������������±� i���±�� 0 ��ʼ����nums[i] + nums[n - 1 - i]������ͬһ������������ nums �� ������ �����磬���� [1,2,3,4] �ǻ����ģ���Ϊ���������±�i ��nums[i] + nums[n - 1 - i] = 5 ��
 * <p>
 * ����ʹ���� ���� �� ���ٲ���������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,4,3], limit = 4
 * �����1
 * ���ͣ����� 1 �β���������Խ����� nums ��� [1,2,2,3]���Ӵ�Ԫ���Ǳ�������֣���
 * nums[0] + nums[3] = 1 + 3 = 4.
 * nums[1] + nums[2] = 2 + 2 = 4.
 * nums[2] + nums[1] = 2 + 2 = 4.
 * nums[3] + nums[0] = 3 + 1 = 4.
 * ����ÿ�� i ��nums[i] + nums[n-1-i] = 4 ������ nums �ǻ����ġ�
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,2,1], limit = 2
 * �����2
 * ���ͣ����� 2 �β���������Խ����� nums ��� [2,2,2,2] ���㲻�ܽ��κ����ֱ��Ϊ 3 ����Ϊ 3 > limit ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,2,1,2], limit = 2
 * �����0
 * ���ͣ�nums �Ѿ��ǻ����ġ�
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * n == nums.length
 * 2 <= n<=105
 * 1 <= nums[i]<= limit <=105
 * n ��ż����
 * ͨ������2,173�ύ����6,207
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-moves-to-make-array-complementary
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinMoves6 {

    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - i - 1]);
            int b = Math.max(nums[i], nums[n - i - 1]);
            diff[2] += 2;
            diff[a + 1] -= 1;
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
            diff[b + limit + 1] += 1;
        }
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 2; i < diff.length; i++) {
            sum += diff[i];
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}
