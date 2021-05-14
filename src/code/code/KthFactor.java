package code.code;

/**
 * ��������������?n ��?k?��
 * <p>
 * ��������� i ���� n % i == 0 ����ô���Ǿ�˵������ i ������ n?�����ӡ�
 * <p>
 * �������� n?���������ӣ������� ��������?�����㷵�ص� k?�����ӡ���� n?������������ k?�����㷵�� -1?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 12, k = 3
 * �����3
 * ���ͣ������б���� [1, 2, 3, 4, 6, 12]���� 3 �������� 3 ��
 * ʾ�� 2��
 * <p>
 * ���룺n = 7, k = 2
 * �����7
 * ���ͣ������б���� [1, 7] ���� 2 �������� 7 ��
 * ʾ�� 3��
 * <p>
 * ���룺n = 4, k = 4
 * �����-1
 * ���ͣ������б���� [1, 2, 4] ��ֻ�� 3 �����ӣ���������Ӧ�÷��� -1 ��
 * ʾ�� 4��
 * <p>
 * ���룺n = 1, k = 1
 * �����1
 * ���ͣ������б���� [1] ���� 1 ������Ϊ 1 ��
 * ʾ�� 5��
 * <p>
 * ���룺n = 1000, k = 3
 * �����4
 * ���ͣ������б���� [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000] ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= k <= n <= 1000
 * ͨ������5,572�ύ����8,314
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/the-kth-factor-of-n
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class KthFactor {

    public int kthFactor(int n, int k) {
        int cnt = 0;
        for (int a = 1; a <= n; a++) {
            if (n % a == 0) {
                cnt++;
            }
            if (cnt == k) {
                return a;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KthFactor kthFactor = new KthFactor();
        System.out.println(kthFactor.kthFactor(1, 1));

        System.out.println(kthFactor.kthFactor(12, 3));
        System.out.println(kthFactor.kthFactor(7, 2));
        System.out.println(kthFactor.kthFactor(4, 4));
        System.out.println(kthFactor.kthFactor(1000, 3));
    }
}
