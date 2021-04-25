package code.code;

/**
 * ����һ������ n��10 ���ƣ���һ������ k �����㽫 n �� 10 ���Ʊ�ʾת��Ϊ k ���Ʊ�ʾ�����㲢����ת�����λ���ֵ� �ܺ� ��
 * <p>
 * ת���󣬸�λ����Ӧ�������� 10 �������֣������ǵ��ܺ�ҲӦ���� 10 ���Ʊ�ʾ���ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 34, k = 6
 * �����9
 * ���ͣ�34 (10 ����) �� 6 �����±�ʾΪ 54 ��5 + 4 = 9 ��
 * ʾ�� 2��
 * <p>
 * ���룺n = 10, k = 10
 * �����1
 * ���ͣ�n ������� 10 ���ơ� 1 + 0 = 1 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 100
 * 2 <= k <= 10
 * ͨ������3,200�ύ����4,069
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-of-digits-in-base-k
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SumBase {

    public int sumBase(int n, int k) {
        int res = 0;
        while (n != 0) {
            res += n % k;
            n /= k;
        }
        return res;
    }

    public static void main(String[] args) {
        SumBase sumBase = new SumBase();
        System.out.println(sumBase.sumBase(34, 6));
        System.out.println(sumBase.sumBase(10, 10));

    }

}
