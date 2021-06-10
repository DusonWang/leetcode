package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * ����һ���ַ��� s �������ָ��ַ����������ز�ֺ�Ψһ���ַ����������Ŀ��
 * <p>
 * �ַ��� s ��ֺ���Եõ����� �ǿ����ַ��� ����Щ���ַ������Ӻ�Ӧ���ܹ���ԭΪԭ�ַ��������ǲ�ֳ�����ÿ�����ַ����������� Ψһ�� ��
 * <p>
 * ע�⣺���ַ��� ���ַ����е�һ�������ַ����С�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "ababccc"
 * �����5
 * ���ͣ�һ������ַ���Ϊ ['a', 'b', 'ab', 'c', 'cc'] ���� ['a', 'b', 'a', 'b', 'c', 'cc'] ������ֲ�������ĿҪ����Ϊ���е� 'a' �� 'b' �������˲�ֹһ�Ρ�
 * ʾ�� 2��
 * <p>
 * ���룺s = "aba"
 * �����2
 * ���ͣ�һ������ַ���Ϊ ['a', 'ba'] ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "aa"
 * �����1
 * ���ͣ��޷���һ������ַ�����
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length<= 16
 * <p>
 * s ������СдӢ����ĸ
 * <p>
 * ͨ������4,646�ύ����9,007
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxUniqueSplit {

    private Set<String> set = new HashSet<>();
    private int ans = 1;

    public int maxUniqueSplit(String s) {
        maxUnique(s, 0);
        return ans;
    }

    public void maxUnique(String s, int start) {
        if (start == s.length()) {
            ans = Math.max(ans, set.size());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (set.contains(sub)) {
                continue;
            }
            set.add(sub);
            maxUnique(s, i + 1);
            set.remove(sub);

        }
    }
}
