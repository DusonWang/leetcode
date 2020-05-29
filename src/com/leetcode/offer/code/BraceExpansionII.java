package com.leetcode.offer.code;

import java.util.*;

/**
 * �������Ϥ Shell ��̣���ôһ���˽��������չ�����������������������ַ�����
 * <p>
 * ������չ���ı��ʽ���Կ���һ���� �����š����� �� СдӢ����ĸ ��ɵ��ַ������������漸���﷨����
 * <p>
 * ���ֻ������һ��Ԫ��?x����ô���ʽ��ʾ���ַ�����ֻ��?"x"��?
 * ���磬���ʽ {a}?��ʾ�ַ��� "a"��
 * �����ʽ {ab}?�ͱ�ʾ�ַ��� "ab"��
 * �������������ʽ���У��Զ��ŷָ�ʱ������ȡ��Щ���ʽ��Ԫ�صĲ�����
 * ���磬���ʽ?{a,b,c} ��ʾ�ַ���?"a","b","c"��
 * �����ʽ {a,b},{b,c}?Ҳ���Ա�ʾ�ַ���?"a","b","c"��
 * Ҫ�������������ʽ��ӣ��м�û�и���ʱ�����Ǵ���Щ���ʽ�и�ȡһ��Ԫ�����������γ��ַ�����
 * ���磬���ʽ {a,b}{c,d} ��ʾ�ַ���?"ac","ad","bc","bd"��
 * ���ʽ֮������Ƕ�ף���һԪ������ʽ������Ҳ������ġ�
 * ���磬���ʽ?a{b,c,d} ��ʾ�ַ���?"ab","ac","ad"??????��
 * ���磬���ʽ?{a{b,c}}{{d,e}f{g,h}} ���Դ���Ϊ?{ab,ac}{dfg,dfh,efg,efh}����ʾ�ַ���?"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"��
 * ������ʾ���ڸ����﷨����ı��ʽ?expression������������ʾ�������ַ�����ɵ������б�
 * <p>
 * ������ϣ���ԡ����ϡ��ĸ����˽���⣬Ҳ����ͨ����� ����ʾӢ�������� ��ȡ���顣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺"{a,b}{c{d,e}}"
 * �����["acd","ace","bcd","bce"]
 * ʾ�� 2��
 * <p>
 * ���룺"{{a,z}, a{b,c}, {ab,z}}"
 * �����["a","ab","ac","z"]
 * ���ͣ������ ��Ӧ �����ظ�����Ͻ����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= expression.length <= 50
 * expression[i] �� '{'��'}'��','?��СдӢ����ĸ���
 * �����ı��ʽ?expression?���Ա�ʾһ�������Ŀ�������﷨������ַ���
 * ͨ������788�ύ����1,572
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/brace-expansion-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BraceExpansionII {

    public List<String> braceExpansionII(String expression) {
        int n = expression.length();
        if (n <= 1) {
            return Collections.singletonList(expression);
        }
        List<String> result = new ArrayList<>();
        if (expression.charAt(0) != '{') {
            List<String> tmp = braceExpansionII(expression.substring(1));
            for (String s : tmp) {
                result.add(expression.charAt(0) + s);
            }
            return result;
        }
        int level = 1;
        int i = 1;
        while (i < n) {
            if (expression.charAt(i) == '{') {
                level++;
            } else if (expression.charAt(i) == '}') {
                level--;
            }
            if (level == 0) {
                break;
            }
            i++;
        }
        Set<String> set = new HashSet<>();
        List<String> tmp = helper(expression.substring(1, i));
        for (String t : tmp) {
            set.addAll(braceExpansionII(t));
        }
        List<String> remain = braceExpansionII(expression.substring(i + 1));
        for (String s : set) {
            for (String r : remain) {
                result.add(s + r);
            }
        }
        Collections.sort(result);
        return result;
    }

    private List<String> helper(String expression) {
        List<String> result = new ArrayList<>();
        int count = 0;
        int i = 0;
        for (int j = 0; j < expression.length(); j++) {
            char c = expression.charAt(j);
            if (c == ',') {
                if (count == 0) {
                    result.add(expression.substring(i, j));
                    i = j + 1;
                }
            } else if (c == '{') {
                count++;
            } else if (c == '}') {
                count--;
            }
        }
        result.add(expression.substring(i));
        return result;
    }
}
