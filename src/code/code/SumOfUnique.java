package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ����������?nums?��������ΨһԪ������Щֻ����?ǡ��һ��?��Ԫ�ء�
 * <p>
 * ���㷵�� nums?��ΨһԪ�ص� ��?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,2]
 * �����4
 * ���ͣ�ΨһԪ��Ϊ [1,3] ����Ϊ 4 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,1,1,1,1]
 * �����0
 * ���ͣ�û��ΨһԪ�أ���Ϊ 0 ��
 * ʾ�� 3 ��
 * <p>
 * ���룺nums = [1,2,3,4,5]
 * �����15
 * ���ͣ�ΨһԪ��Ϊ [1,2,3,4,5] ����Ϊ 15 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * ͨ������6,322�ύ����8,259
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-of-unique-elements
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SumOfUnique {

    public int sumOfUnique(int[] nums) {
        int[] tag = new int[101];
        int sum = 0;
        for (int num : nums) {
            tag[num]++;
        }
        for (int i = 1; i < 101; i++) {
            if (tag[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
