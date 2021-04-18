package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ����һ��ż�����ȵ��ַ��� s �������ֳɳ�����ͬ�����룬ǰһ��Ϊ a ����һ��Ϊ b ��
 * <p>
 * �����ַ��� ���� ��ǰ�������Ƕ�������ͬ��Ŀ��Ԫ����'a'��'e'��'i'��'o'��'u'��'A'��'E'��'I'��'O'��'U'����ע�⣬s ����ͬʱ���д�д��Сд��ĸ��
 * <p>
 * ��� a �� b ���ƣ����� true �����򣬷��� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "book"
 * �����true
 * ���ͣ�a = "bo" �� b = "ok" ��a ���� 1 ��Ԫ����b Ҳ�� 1 ��Ԫ�������ԣ�a �� b ���ơ�
 * ʾ�� 2��
 * <p>
 * ���룺s = "textbook"
 * �����false
 * ���ͣ�a = "text" �� b = "book" ��a ���� 1 ��Ԫ����b ���� 2 ��Ԫ������ˣ�a �� b �����ơ�
 * ע�⣬Ԫ�� o �� b �г������Σ���Ϊ 2 ����
 * ʾ�� 3��
 * <p>
 * ���룺s = "MerryChristmas"
 * �����false
 * ʾ�� 4��
 * <p>
 * ���룺s = "AbCdEfGh"
 * �����true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= s.length <= 1000
 * s.length ��ż��
 * s �� ��д��Сд ��ĸ���
 * ͨ������9,377�ύ����11,889
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/determine-if-string-halves-are-alike
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class HalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        Character[] ss = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<>(Arrays.asList(ss));
        int cnt1 = 0;
        int cnt2 = 0;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (set.contains(s.charAt(i))) {
                cnt1++;
            }
            if (set.contains(s.charAt(j))) {
                cnt2++;
            }
            i++;
            j--;
        }
        return cnt2 == cnt1;
    }
}
