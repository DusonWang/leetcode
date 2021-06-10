package code.code;

import java.util.PriorityQueue;

/**
 * ����һ���� n ����������ɵ����� nums ��
 * <p>
 * ����Զ����������Ԫ��ִ��������������������
 * <p>
 * ���Ԫ���� ż�� ������ 2
 * ���磬��������� [1,2,3,4] ����ô����Զ����һ��Ԫ��ִ�д˲�����ʹ���� [1,2,3,2]
 * ���Ԫ���� ���� ������ 2
 * ���磬��������� [1,2,3,4] ����ô����ԶԵ�һ��Ԫ��ִ�д˲�����ʹ���� [2,2,3,4]
 * ����� ƫ���� ����������������Ԫ��֮��� ����ֵ ��
 * <p>
 * ����������ִ��ĳЩ����֮�����ӵ�е� ��Сƫ���� ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,4]
 * �����1
 * ���ͣ�����Խ�����ת��Ϊ [1,2,3,2]��Ȼ��ת���� [2,2,3,2]��ƫ������ 3 - 2 = 1
 * ʾ�� 2��
 * <p>
 * ���룺nums = [4,1,5,20,3]
 * �����3
 * ���ͣ����β���������Խ�����ת��Ϊ [4,2,5,5,3]��ƫ������ 5 - 2 = 3
 * ʾ�� 3��
 * <p>
 * ���룺nums = [2,10,8]
 * �����3
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * n == nums.length
 * 2 <= n <= 105
 * 1 <= nums[i] <= 109
 * ͨ������2,282�ύ����5,218
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimize-deviation-in-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinimumDeviation {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int min = Integer.MAX_VALUE;
        // step1: ��������������������2 �õ��������֣��Լ�ԭ�������е�ż���������浽���ȶ���
        // ��������С��min
        for (int num : nums) {
            if ((num & 1) == 1) {
                num *= 2;
            }
            queue.add(num);
            min = Math.min(min, num);
        }
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res = Math.min(res, curr - min);
            // �����ż����ż������2�����浽����
            if ((curr & 1) == 0) {
                queue.add(curr / 2);
                // ����2������� �� Ŀǰ��������С�����ֻ�С����ô����minֵ
                min = Math.min(min, curr / 2);
            } else {
                //�����������������������ǲ��ü��������ˣ�����ѳ�
                break;
            }
        }
        return res;
    }

}
