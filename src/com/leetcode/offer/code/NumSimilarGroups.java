package com.leetcode.offer.code;

/**
 * @author duson
 * ������ǽ����ַ���?X �е�������ͬλ�õ���ĸ��ʹ�������ַ���?Y ��ȣ���ô�� X �� Y �����ַ������ơ�����������ַ�����������ȵģ�������Ҳ�����Ƶġ�
 * <p>
 * ���磬"tars" �� "rats" �����Ƶ� (���� 0 �� 2 ��λ��)��?"rats" �� "arts" Ҳ�����Ƶģ����� "star" ���� "tars"��"rats"���� "arts" ���ơ�
 * <p>
 * ��֮������ͨ���������γ������������飺{"tars", "rats", "arts"} �� {"star"}��ע�⣬"tars" �� "arts" ����ͬһ���У���ʹ���ǲ������ơ���ʽ�ϣ���ÿ������ԣ�Ҫȷ��һ�����������У�ֻ��Ҫ����ʺ͸���������һ���������ơ�
 * <p>
 * ���Ǹ�����һ���������ظ����ַ����б� A���б��е�ÿ���ַ������� A �����������ַ�����һ����ĸ��λ�ʡ����� A ���ж��ٸ������ַ����飿
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺["tars","rats","arts","star"]
 * �����2
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * A.length <= 2000
 * A[i].length <= 1000
 * A.length * A[i].length <= 20000
 * A �е����е��ʶ�ֻ����Сд��ĸ��
 * A �е����е��ʶ�������ͬ�ĳ��ȣ����Ǳ˴˵���ĸ��λ�ʡ�
 * ��������ж�����ʱ���Ѿ��ӳ���
 * ?
 * <p>
 * ��ע��
 * <p>
 * ????? ��ĸ��λ��[anagram]��һ�ְ�ĳ���ַ�������ĸ��λ�ã�˳�򣩼��ԸĻ����γɵ��´ʡ�
 * <p>
 * ͨ������2,256�ύ����6,854
 * ����ʵ�������������������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/similar-string-groups
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumSimilarGroups {

    private int[] par;

    public int findpar(int vtx) {
        if (par[vtx] == vtx) {
            return vtx;
        }
        return par[vtx] = findpar(par[vtx]);
    }

    public int isSame(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++count > 2) {
                return 0;
            }
        }
        return 1;
    }

    public int numSimilarGroups(String[] a) {
        int n = a.length;
        par = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            par[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int p1 = findpar(i);
                int p2 = findpar(j);
                if (p1 != p2 && isSame(a[i], a[j]) == 1) {
                    n--;
                    par[p2] = p1;
                }
            }
        }
        return n;
    }
}
