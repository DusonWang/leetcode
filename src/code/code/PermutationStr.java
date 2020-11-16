package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * ����һ���ַ�������ӡ�����ַ������ַ����������С�
 * <p>
 * ?
 * <p>
 * �����������˳�򷵻�����ַ������飬�����治�����ظ�Ԫ�ء�
 * <p>
 * ?
 * <p>
 * ʾ��:
 * <p>
 * ���룺s = "abc"
 * �����["abc","acb","bac","bca","cab","cba"]
 * ?
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= s �ĳ��� <= 8
 * <p>
 * ͨ������14,555�ύ����27,525
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PermutationStr {

    private final Set<String> result = new HashSet<>();

    public String[] permutation(String s) {
        if (s == null) {
            return new String[]{};
        }
        boolean[] visited = new boolean[s.length()];
        process(s, "", visited);
        return result.toArray(new String[0]);
    }

    private void process(String s, String letter, boolean[] visited) {
        if (s.length() == letter.length()) {
            result.add(letter);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            process(s, letter + temp, visited);
            visited[i] = false;
        }
    }
}
