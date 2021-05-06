package code.code;

import java.util.Arrays;

/**
 * ����һ������С�����߳��������� n ��С�򣬱�Ŵ� lowLimit ��ʼ���� highLimit ���������� lowLimit ��?highLimit ����?n == highLimit - lowLimit + 1�����������������ĺ��ӣ���Ŵ� 1 �� infinity ��
 * <p>
 * ��Ĺ����ǽ�ÿ��С���������У����к��ӵı��Ӧ������С������ÿλ���ֵĺ͡����磬��� 321 ��С��Ӧ�������� 3 + 2 + 1 = 6 �ĺ��ӣ������ 10 ��С��Ӧ�������� 1 + 0 = 1 �ĺ��ӡ�
 * <p>
 * ������������ lowLimit �� highLimit �����ط������С��ĺ����е�С������������ж�����Ӷ�����������С��ֻ�践��������һ���ӵ�С��������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺lowLimit = 1, highLimit = 10
 * �����2
 * ���ͣ�
 * ���ӱ�ţ�1 2 3 4 5 6 7 8 9 10 11 ...
 * С��������2 1 1 1 1 1 1 1 1 0  0  ...
 * ��� 1 �ĺ��ӷ������С��С������Ϊ 2 ��
 * ʾ�� 2��
 * <p>
 * ���룺lowLimit = 5, highLimit = 15
 * �����2
 * ���ͣ�
 * ���ӱ�ţ�1 2 3 4 5 6 7 8 9 10 11 ...
 * С��������1 1 1 1 2 2 1 1 1 0  0  ...
 * ��� 5 �� 6 �ĺ��ӷ������С��ÿ�������е�С���������� 2 ��
 * ʾ�� 3��
 * <p>
 * ���룺lowLimit = 19, highLimit = 28
 * �����2
 * ���ͣ�
 * ���ӱ�ţ�1 2 3 4 5 6 7 8 9 10 11 12 ...
 * С��������0 1 1 1 1 1 1 1 1 2  0  0  ...
 * ��� 10 �ĺ��ӷ������С��С������Ϊ 2 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= lowLimit <= highLimit <= 105
 * ͨ������6,814�ύ����9,633
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-number-of-balls-in-a-box
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountBalls {

    public int countBalls(int lowLimit, int highLimit) {
        int[] ans = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int a = i;
            int sum = 0;
            while (a != 0) {
                sum += a % 10;
                a /= 10;
            }
            ans[sum]++;
        }
        Arrays.sort(ans);
        return ans[ans.length - 1];
    }
}
