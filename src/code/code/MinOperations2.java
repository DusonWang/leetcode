package code.code;

/**
 * ����һ������Ϊ n ������ arr ������ arr[i] = (2 * i) + 1 �� 0 <= i < n ����
 * <p>
 * һ�β����У������ѡ�������±꣬���� x �� y �� 0 <= x, y < n ����ʹ arr[x] ��ȥ 1 ��arr[y] ���� 1 ���� arr[x] -=1 �� arr[y] += 1 �������յ�Ŀ����ʹ�����е�����Ԫ�ض� ��� ����Ŀ������������ ��֤ ����ִ�����ɲ������������е�����Ԫ�����տ���ȫ����ȡ�
 * <p>
 * ����һ������ n��������ĳ��ȡ����㷵��ʹ���� arr ������Ԫ���������� ��С������ ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 3
 * �����2
 * ���ͣ�arr = [1, 3, 5]
 * ��һ�β���ѡ�� x = 2 �� y = 0��ʹ�����Ϊ [2, 3, 4]
 * �ڶ��β�������ѡ�� x = 2 �� y = 0�����齫���� [3, 3, 3]
 * ʾ�� 2��
 * <p>
 * ���룺n = 6
 * �����9
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 10^4
 * ͨ������9,610�ύ����11,773
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinOperations2 {

    public int minOperations(int n) {
        return n * n / 4;
    }
}