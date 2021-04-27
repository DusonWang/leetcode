package code.code;

/**
 * ����һ���� nums?��С��ͬ�ҳ�ʼֵȫΪ 0 ������ arr ������������Ϻ����õ��������� nums?��
 * <p>
 * ���㷵�ؽ� arr?��� nums?�����ٺ������ô�����
 * <p>
 * �𰸱�֤�� 32 λ�з����������ڡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,5]
 * �����5
 * ���ͣ����ڶ������� 1 ��[0, 0] ��� [0, 1] ��1 �β�������
 * ���������ֳ��� 2 ��[0, 1] -> [0, 2] -> [0, 4] ��2 �β�������
 * ���������ֶ��� 1 ��[0, 4] -> [1, 4] -> [1, 5] ��2 �β�������
 * �ܲ�������Ϊ��1 + 2 + 2 = 5 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [2,2]
 * �����3
 * ���ͣ����������ֶ��� 1 ��[0, 0] -> [0, 1] -> [1, 1] ��2 �β�������
 * ���������ֳ��� 2 �� [1, 1] -> [2, 2] ��1 �β�������
 * �ܲ�������Ϊ�� 2 + 1 = 3 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [4,2,5]
 * �����6
 * ���ͣ�����ʼ��[0,0,0] -> [1,0,0] -> [1,0,1] -> [2,0,2] -> [2,1,2] -> [4,2,4] -> [4,2,5] ��nums ���飩��
 * ʾ�� 4��
 * <p>
 * ���룺nums = [3,2,2,4]
 * �����7
 * ʾ�� 5��
 * <p>
 * ���룺nums = [2,4,8,16]
 * �����8
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * ͨ������3,928�ύ����6,361
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-numbers-of-function-calls-to-make-target-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinOperations3 {

    public int minOperations(int[] nums) {
        int ret = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            while (num != 0) {
                if ((num & 1) != 0) {
                    ret++;
                }
                num >>= 1;
            }
        }
        if (max != 0) {
            while (max != 0) {
                ret++;
                max >>= 1;
            }
            ret--;
        }
        return ret;
    }

    public int minOperations2(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            count += Integer.bitCount(num);
        }
        count += Integer.toBinaryString(max).length() - 1;
        return count;
    }
}
