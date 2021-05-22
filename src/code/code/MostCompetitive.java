package code.code;

import java.util.Stack;

/**
 * ����һ���������� nums ��һ�������� k �����س���Ϊ k ����� ������ �� nums �����С�
 * <p>
 * ������������Ǵ�������ɾ��һЩԪ�أ����ܲ�ɾ��Ԫ�أ��õ������С�
 * <p>
 * ��������?a ��������?b ��һ������ͬ��λ���ϣ����?a?�е�����С�� b �ж�Ӧ�����֣���ô���ǳ������� a �������� b����ͬ�����£����� ������ �� ���磬[1,3,4] �� [1,3,5] ���߾��������ڵ�һ������ͬ��λ�ã�Ҳ�������һ��λ���ϣ�?4 С�� 5 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [3,5,2,6], k = 2
 * �����[2,6]
 * ���ͣ������п��ܵ������м��� {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} �У�[2,6] ��߾�������
 * ʾ�� 2��
 * <p>
 * ���룺nums = [2,4,3,3,5,4,9,6], k = 4
 * �����[2,3,3,4]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 1 <= k <= nums.length
 * ͨ������6,318�ύ����18,674
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-most-competitive-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MostCompetitive {

    public int[] mostCompetitive(int[] nums, int k) {
        int[] stack = new int[k];
        int top = 0;
        int drop = nums.length - k;
        for (int num : nums) {
            while (drop > 0 && top > 0 && stack[top - 1] > num) {
                drop--;
                top--;
            }
            if (top < k) {
                stack[top++] = num;
            } else {
                --drop;
            }
        }
        return stack;
    }
}
