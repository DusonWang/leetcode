package code.code;

/**
 * @author duson
 * ���������ַ���?s1?��?s2?�����ǳ�����ȣ��������Ƿ����һ��?s1? �����п��Դ��� s2?��һ�����У������Ƿ����һ��?s2?�����п��Դ��� s1 ��һ�����С�
 * <p>
 * �ַ���?x?���Դ����ַ���?y?�����߳��ȶ�Ϊ?n?���������������?i����?0?��?n - 1?֮�䣩����?x[i] >= y[i]���ֵ��������µ�˳�򣩡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s1 = "abc", s2 = "xya"
 * �����true
 * ���ͣ�"ayx" �� s2="xya" ��һ�����У�"abc" ���ַ��� s1="abc" ��һ�����У��� "ayx" ���Դ��� "abc" ��
 * ʾ�� 2��
 * <p>
 * ���룺s1 = "abe", s2 = "acd"
 * �����false
 * ���ͣ�s1="abe" ���������а�����"abe"��"aeb"��"bae"��"bea"��"eab" �� "eba" ��s2="acd" ���������а�����"acd"��"adc"��"cad"��"cda"��"dac" �� "dca"��Ȼ��û���κ� s1 �����п��Դ��� s2 �����С�Ҳû�� s2 �������ܴ��� s1 �����С�
 * ʾ�� 3��
 * <p>
 * ���룺s1 = "leetcodee", s2 = "interview"
 * �����true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * s1.length == n
 * s2.length == n
 * 1 <= n <= 10^5
 * �����ַ�����ֻ����СдӢ����ĸ��
 * ͨ������2,300�ύ����3,709
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-a-string-can-break-another-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CheckIfCanBreak {

    public boolean checkIfCanBreak(String s1, String s2) {
        int[] res1 = new int[26];
        int[] res2 = new int[26];
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            res1[c - 'a']++;
        }
        chars = s2.toCharArray();
        for (char c : chars) {
            res2[c - 'a']++;
        }
        for (int i = 1; i < 26; i++) {
            res1[i] += res1[i - 1];
            res2[i] += res2[i - 1];
        }
        return f(res1, res2) || f(res2, res1);
    }

    private boolean f(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }
}
