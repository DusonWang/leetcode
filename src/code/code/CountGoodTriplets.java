package code.code;

/**
 * ����һ���������� arr ���Լ� a��b ��c ��������������ͳ�����к���Ԫ���������
 * <p>
 * �����Ԫ�� (arr[i], arr[j], arr[k]) ��������ȫ������������Ϊ����һ�� ����Ԫ�� ��
 * <p>
 * 0 <= i < j < k <?arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * ���� |x| ��ʾ x �ľ���ֵ��
 * <p>
 * ���� ����Ԫ������� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * �����4
 * ���ͣ�һ���� 4 ������Ԫ�飺[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] ��
 * ʾ�� 2��
 * <p>
 * ���룺arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * �����0
 * ���ͣ�����������������������Ԫ�顣
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 * ͨ������15,385�ύ����19,538
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-good-triplets
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountGoodTriplets countGoodTriplets = new CountGoodTriplets();
        System.out.println(countGoodTriplets.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(countGoodTriplets.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
        System.out.println(countGoodTriplets.countGoodTriplets(new int[]{4, 9, 9, 8, 9, 5, 3, 7}, 1, 3, 0));

    }
}
