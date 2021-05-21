package code.code;

/**
 * ����һ���������� nums ������������ limit �� goal ������ nums ��һ����Ҫ���ԣ�abs(nums[i]) <= limit ��
 * <p>
 * ����ʹ����Ԫ���ܺ͵��� goal ����Ҫ����������ӵ� ����Ԫ������ �����Ԫ�� ��Ӧ�ı� ������ abs(nums[i]) <= limit ��һ���ԡ�
 * <p>
 * ע�⣬��� x >= 0 ����ô abs(x) ���� x �����򣬵��� -x ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,-1,1], limit = 3, goal = -4
 * �����2
 * ���ͣ����Խ� -2 �� -3 ��ӵ������У������Ԫ���ܺͱ�Ϊ 1 - 1 + 1 - 2 - 3 = -4 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,-10,9,1], limit = 100, goal = 0
 * �����1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= limit <= 106
 * -limit <= nums[i] <= limit
 * -109 <= goal <= 109
 * ͨ������5,807�ύ����16,986
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-elements-to-add-to-form-a-given-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinElements {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        long diff = Math.abs(goal - sum);
        long num = diff / limit;
        long remain = diff % limit;
        return (int) (remain != 0 ? num + 1 : num);
    }


    public static void main(String[] args) {
        MinElements minElements = new MinElements();
        System.out.println(minElements.minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(minElements.minElements(new int[]{1, -10, 9, 1}, 100, 0));
    }
}
