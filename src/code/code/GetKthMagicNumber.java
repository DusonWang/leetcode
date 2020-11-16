package code.code;

/**
 * ��Щ����������ֻ�� 3��5��7�������һ���㷨�ҳ��� k ������ע�⣬���Ǳ�������Щ�����ӣ����Ǳ��벻���������������ӡ����磬ǰ��������˳��Ӧ���� 1��3��5��7��9��15��21��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: k = 5
 * <p>
 * ���: 9
 * ͨ������2,459�ύ����4,711
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        int p3 = 0, p5 = 0, p7 = 0;
        int[] arr = new int[k];
        arr[0] = 1;
        for (int i = 1; i < k; i++) {
            arr[i] = Math.min(arr[p3] * 3, Math.min(arr[p5] * 5, arr[p7] * 7));
            if (arr[i] == arr[p3] * 3) {
                p3++;
            }
            if (arr[i] == arr[p5] * 5) {
                p5++;
            }
            if (arr[i] == arr[p7] * 7) {
                p7++;
            }
        }
        return arr[k - 1];
    }
}
