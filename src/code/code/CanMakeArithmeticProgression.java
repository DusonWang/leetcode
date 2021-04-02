package code.code;

import java.util.Arrays;

/**
 * ����һ���������� arr ��
 *
 * ���һ�������У�������������Ĳ��ܵ���ͬһ����������ô������оͳ�Ϊ �Ȳ����� ��
 *
 * ��������������������γɵȲ����У��뷵�� true �����򣬷��� false ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺arr = [3,5,1]
 * �����true
 * ���ͣ���������������õ� [1,3,5] ���� [5,3,1] ��������������Ĳ�ֱ�Ϊ 2 �� -2 �������γɵȲ����С�
 * ʾ�� 2��
 *
 * ���룺arr = [1,2,4]
 * �����false
 * ���ͣ��޷�ͨ����������õ��Ȳ����С�
 * ?
 *
 * ��ʾ��
 *
 * 2 <= arr.length <= 1000
 * -10^6 <= arr[i] <= 10^6
 * ͨ������21,261�ύ����29,393
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class CanMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
