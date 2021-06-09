package code.code;

/**
 * ����һ���ַ��� s ������ s �� ͬ�����ַ��� ����Ŀ�����ڴ𰸿��ܴܺ�ֻ�践�ض� 109 + 7 ȡ�� ��Ľ����
 * <p>
 * ͬ���ַ��� �Ķ���Ϊ�����һ���ַ����е������ַ�����ͬ����ô���ַ�������ͬ���ַ�����
 * <p>
 * ���ַ��� ���ַ����е�һ�������ַ����С�
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "abbcccaa"
 * �����13
 * ���ͣ�ͬ�����ַ����������У�
 * "a"   ���� 3 �Ρ�
 * "aa"  ���� 1 �Ρ�
 * "b"   ���� 2 �Ρ�
 * "bb"  ���� 1 �Ρ�
 * "c"   ���� 3 �Ρ�
 * "cc"  ���� 2 �Ρ�
 * "ccc" ���� 1 �Ρ�
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 * ʾ�� 2��
 * <p>
 * ���룺s = "xy"
 * �����2
 * ���ͣ�ͬ�����ַ����� "x" �� "y" ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "zzzzz"
 * �����15
 *
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 105
 * s ��Сд�ַ������
 * ͨ������4,150�ύ����9,712
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-number-of-homogenous-substrings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountHomogenous {

    public int countHomogenous(String s) {
        int res = 0;
        int cur = 0;
        int count = 0;
        int mod = 1_000_000_007;
        for (int i = 0; i < s.length(); ++i) {
            count = s.charAt(i) == cur ? count + 1 : 1;
            cur = s.charAt(i);
            res = (res + count) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        CountHomogenous countHomogenous = new CountHomogenous();
        System.out.println(countHomogenous.countHomogenous("zzzzz"));
    }
}
