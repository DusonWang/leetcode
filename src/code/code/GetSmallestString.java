package code.code;

/**
 * Сд�ַ� �� ��ֵ ��������ĸ���е�λ�ã��� 1 ��ʼ������� a ����ֵΪ 1 ��b ����ֵΪ 2 ��c ����ֵΪ 3 ���Դ����ơ�
 * <p>
 * �ַ���������Сд�ַ���ɣ��ַ�������ֵ Ϊ���ַ�����ֵ֮�͡����磬�ַ��� "abe" ����ֵ���� 1 + 2 + 5 = 8 ��
 * <p>
 * ������������ n �� k ������ ���� ���� n �� ��ֵ ���� k �� �ֵ�����С ���ַ�����
 * <p>
 * ע�⣬����ַ��� x ���ֵ�������λ�� y ֮ǰ������Ϊ x �ֵ���� y С�����������������
 * <p>
 * x �� y ��һ��ǰ׺��
 * ��� i ��x[i] != y[i] �ĵ�һ��λ�ã��� x[i]����ĸ���е�λ�ñ�y[i]��ǰ��
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 3, k = 27
 * �����"aay"
 * ���ͣ��ַ�������ֵΪ 1 + 1 + 25 = 27��������ֵ����Ҫ���ҳ��ȵ��� 3 �ֵ�����С���ַ�����
 * ʾ�� 2��
 * <p>
 * ���룺n = 5, k = 73
 * �����"aaszz"
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 105
 * n <= k <= 26 * n
 * ͨ������6,917�ύ����12,138
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetSmallestString {

    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = 'a';
        }
        k -= n;
        int i = n - 1;
        while (k > 0) {
            int min = Math.min(k, 25);
            result[i--] += min;
            k -= min;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        GetSmallestString getSmallestString = new GetSmallestString();
        System.out.println(getSmallestString.getSmallestString(3, 27));
    }
}
