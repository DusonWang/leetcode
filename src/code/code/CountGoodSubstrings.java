package code.code;

/**
 * ���һ���ַ����������κ��ظ��ַ������ǳ�����ַ���Ϊ ��?�ַ�����
 * <p>
 * ����һ���ַ��� s?�����㷵�� s?�г���Ϊ 3?�� �����ַ��� ��������
 * <p>
 * ע�⣬�����ͬ�ĺ����ַ������ֶ�Σ�ÿһ�ζ�Ӧ�ñ������֮�С�
 * <p>
 * ���ַ��� ��һ���ַ������������ַ����С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "xyzzaz"
 * �����1
 * ���ͣ��ܹ��� 4 ������Ϊ 3 �����ַ�����"xyz"��"yzz"��"zza" �� "zaz" ��
 * Ψһ�ĳ���Ϊ 3 �ĺ����ַ����� "xyz" ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "aababcabc"
 * �����4
 * ���ͣ��ܹ��� 7 ������Ϊ 3 �����ַ�����"aab"��"aba"��"bab"��"abc"��"bca"��"cab" �� "abc" ��
 * �����ַ������� "abc"��"bca"��"cab" �� "abc" ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 100
 * s?????? ֻ����СдӢ����ĸ��
 * ͨ������3,079�ύ����4,232
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountGoodSubstrings {

    public int countGoodSubstrings(String str) {
        int res = 0;
        int n = str.length();
        char[] s = str.toCharArray();
        for (int i = 0; i < n - 2; ++i) {
            if (s[i] != s[i + 1] && s[i] != s[i + 2] && s[i + 1] != s[i + 2]) {
                ++res;
            }
        }
        return res;
    }
}
