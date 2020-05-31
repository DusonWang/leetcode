package com.leetcode.offer.code;

/**
 * @author duson
 * ��������������ͬ����������?target?��?arr?��
 * <p>
 * ÿһ���У������ѡ��?arr?������ �ǿ�������?��������ת�������ִ�д˹�������Ρ�
 * <p>
 * ��������� arr?����� target?��ͬ������ True�����򣬷��� False ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺target = [1,2,3,4], arr = [2,4,1,3]
 * �����true
 * ���ͣ�����԰������²���ʹ arr ��� target��
 * 1- ��ת������ [2,4,1] ��arr ��� [1,4,2,3]
 * 2- ��ת������ [4,2] ��arr ��� [1,2,4,3]
 * 3- ��ת������ [4,3] ��arr ��� [1,2,3,4]
 * ��������������Ψһ�ģ������ڶ��ֽ� arr ��� target �ķ�����
 * ʾ�� 2��
 * <p>
 * ���룺target = [7], arr = [7]
 * �����true
 * ���ͣ�arr ����Ҫ���κη�ת�Ѿ��� target ��ȡ�
 * ʾ�� 3��
 * <p>
 * ���룺target = [1,12], arr = [12,1]
 * �����true
 * ʾ�� 4��
 * <p>
 * ���룺target = [3,7,9], arr = [3,7,11]
 * �����false
 * ���ͣ�arr û������ 9 �������������Ҳ�޷���� target ��
 * ʾ�� 5��
 * <p>
 * ���룺target = [1,1,1,1,1], arr = [1,1,1,1,1]
 * �����true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * target.length == arr.length
 * 1 <= target.length <= 1000
 * 1 <= target[i] <= 1000
 * 1 <= arr[i] <= 1000
 * ͨ������2,102�ύ����2,473
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        int length = target.length;
        int match = 0;
        for (int value : target) {
            for (int j = 0; j < length; j++) {
                if (value == arr[j]) {
                    match++;
                    break;
                }
            }
        }
        return match == length;
    }
}
