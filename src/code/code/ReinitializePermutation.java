package code.code;

/**
 * ����һ��ż�� n ����֪����һ������Ϊ n ������ perm ������ perm[i] == i���±� �� 0 ��ʼ ��������
 * <p>
 * һ�������У��㽫����һ�������� arr ������ÿ�� i ��
 * <p>
 * ��� i % 2 == 0 ����ô arr[i] = perm[i / 2]
 * ��� i % 2 == 1 ����ô arr[i] = perm[n / 2 + (i - 1) / 2]
 * Ȼ�� arr ��ֵ�� perm ��
 * <p>
 * Ҫ��ʹ perm �ص����г�ʼֵ��������Ҫִ�ж��ٲ�������������С�� ���� ����������
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 2
 * �����1
 * ���ͣ������perm = [0,1]
 * �� 1��������perm = [0,1]
 * ���ԣ�����ִ�� 1 ������
 * ʾ�� 2��
 * <p>
 * ���룺n = 4
 * �����2
 * ���ͣ������perm = [0,1,2,3]
 * �� 1��������perm = [0,2,1,3]
 * �� 2��������perm = [0,1,2,3]
 * ���ԣ�����ִ�� 2 ������
 * ʾ�� 3��
 * <p>
 * ���룺n = 6
 * �����4
 *
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 1000
 * n ��һ��ż��
 * ͨ������4,773�ύ����7,276
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ReinitializePermutation {

    public int reinitializePermutation(int n) {
        int res = 0;
        int i = 1;
        while (res == 0 || i > 1) {
            i = (i << 1) % (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        ReinitializePermutation reinitializePermutation = new ReinitializePermutation();
        System.out.println(reinitializePermutation.reinitializePermutation(2));
        System.out.println(reinitializePermutation.reinitializePermutation(4));
        System.out.println(reinitializePermutation.reinitializePermutation(6));
    }
}
