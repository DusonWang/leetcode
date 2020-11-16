package code.code;

import java.util.Arrays;

/**
 * ����������ͬ�������ַ�����A ��?B������ A[i] �� B[i] ��һ��ȼ��ַ����ٸ����ӣ����?A = "abc" ��?B = "cde"����ô����?'a' == 'c', 'b' == 'd', 'c' == 'e'��
 * <p>
 * �ȼ��ַ���ѭ�κεȼ۹�ϵ��һ�����
 * <p>
 * �Է��ԣ�'a' == 'a'
 * �Գ��ԣ�'a' == 'b' ��ض��� 'b' == 'a'
 * �����ԣ�'a' == 'b' �� 'b' == 'c' �ͱ��� 'a' == 'c'
 * ���磬A ��?B?�ĵȼ���Ϣ��֮ǰ������һ������ô?S = "eed", "acd"?��?"aab"���������ַ������ǵȼ۵ģ���?"aab"?�� S?�İ��ֵ�����С�ĵȼ��ַ���
 * <p>
 * ����?A ��?B?�ĵȼ���Ϣ���ҳ������� S?�İ��ֵ���������С�ĵȼ��ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺A = "parker", B = "morris", S = "parser"
 * �����"makkek"
 * ���ͣ����� A �� B �еĵȼ���Ϣ�����ǿ��Խ���Щ�ַ���Ϊ [m,p], [a,o], [k,r,s], [e,i] �� 4 �顣ÿ���е��ַ����ǵȼ۵ģ������ֵ������С����Դ��� "makkek"��
 * ʾ�� 2��
 * <p>
 * ���룺A = "hello", B = "world", S = "hold"
 * �����"hdld"
 * ���ͣ����� A �� B �еĵȼ���Ϣ�����ǿ��Խ���Щ�ַ���Ϊ [h,w], [d,e,o], [l,r] �� 3 �顣����ֻ�� S �еĵڶ����ַ� 'o' ��� 'd'������Ϊ "hdld"��
 * ʾ�� 3��
 * <p>
 * ���룺A = "leetcode", B = "programs", S = "sourcecode"
 * �����"aauaaaaada"
 * ���ͣ����ǿ��԰� A �� B �еĵȼ��ַ���Ϊ [a,o,e,r,s,c], [l,p], [g,t] �� [d,m] �� 4 �飬��� S �г��� 'u' �� 'd' ֮���������ĸ��ת������ 'a'������Ϊ "aauaaaaada"��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * �ַ���?A��B?��?S?���д�?'a' ��?'z'?��СдӢ����ĸ��ɡ�
 * �ַ���?A��B?��?S?�ĳ�����?1 ��?1000?֮�䡣
 * �ַ���?A?��?B?������ͬ��
 * ͨ������1,310�ύ����2,501
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/lexicographically-smallest-equivalent-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SmallestEquivalentString {

    public String smallestEquivalentString(String a, String b, String s) {
        if (a == null || a.length() == 0) {
            return s;
        }
        int[] set = new int[26];
        Arrays.fill(set, -1);
        char[] cA = a.toCharArray(), cB = b.toCharArray();
        int lenA = cA.length;
        for (int i = 0; i < lenA; i++) {
            build(set, cA[i], cB[i]);
        }
        int lenS = s.length();
        char[] ret = new char[lenS];
        for (int i = 0; i < lenS; i++) {
            ret[i] = (char) (getRoot(set, s.charAt(i) - 'a') + 'a');
        }
        return new String(ret);
    }

    private void build(int[] set, char a, char b) {
        int i = getRoot(set, a - 'a');
        int j = getRoot(set, b - 'a');
        if (i == j) {
            return;
        } else if (i > j) {
            set[i] = getRoot(set, j);
        } else {
            set[j] = getRoot(set, i);
        }
    }

    private int getRoot(int[] set, int a) {
        while (set[a] != -1) {
            a = set[a];
        }
        return a;
    }
}
