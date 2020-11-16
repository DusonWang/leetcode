package code.code;

/**
 * �����ַ��� s ������ k ��
 * <p>
 * �뷵���ַ��� s �г���Ϊ k �ĵ������ַ����п��ܰ��������Ԫ����ĸ����
 * <p>
 * Ӣ���е� Ԫ����ĸ Ϊ��a, e, i, o, u����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "abciiidef", k = 3
 * �����3
 * ���ͣ����ַ��� "iii" ���� 3 ��Ԫ����ĸ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "aeiou", k = 2
 * �����2
 * ���ͣ����ⳤ��Ϊ 2 �����ַ��������� 2 ��Ԫ����ĸ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "leetcode", k = 3
 * �����2
 * ���ͣ�"lee"��"eet" �� "ode" ������ 2 ��Ԫ����ĸ��
 * ʾ�� 4��
 * <p>
 * ���룺s = "rhythms", k = 4
 * �����0
 * ���ͣ��ַ��� s �в����κ�Ԫ����ĸ��
 * ʾ�� 5��
 * <p>
 * ���룺s = "tryhard", k = 4
 * �����1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 10^5
 * s ��СдӢ����ĸ���
 * 1 <= k <= s.length
 * ͨ������2,580�ύ����6,104
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0, result = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if ("aeiou".contains(String.valueOf(s.charAt(j)))) {
                count++;
            }
            if (j > k - 1) {
                if ("aeiou".contains(String.valueOf(s.charAt(i)))) {
                    count--;
                }
                i++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
