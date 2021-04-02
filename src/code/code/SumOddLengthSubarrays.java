package code.code;

/**
 * ����һ������������?arr?������������п��ܵ���������������ĺ͡�
 *
 * ������ ����Ϊԭ�����е�һ�����������С�
 *
 * ���㷵�� arr?�� ������������������ĺ� ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺arr = [1,4,2,5,3]
 * �����58
 * ���ͣ�����������������������ǵĺ�Ϊ��
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * ���ǽ�����ֵ��͵õ� 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * ʾ�� 2��
 *
 * ���룺arr = [1,2]
 * �����3
 * ���ͣ��ܹ�ֻ�� 2 ������Ϊ�����������飬[1] �� [2]�����ǵĺ�Ϊ 3 ��
 * ʾ�� 3��
 *
 * ���룺arr = [10,11,12]
 * �����66
 * ?
 *
 * ��ʾ��
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * ͨ������17,338�ύ����21,609
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays easy
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class SumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int leftOdd = (i + 1) / 2;
            int leftEven = i / 2 + 1;
            int rightOdd = (len - i) / 2;
            int rightEven = (len - 1 - i) / 2 + 1;
            res += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return res;
    }
}
