package code.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duson
 * �ڸ��������б�?wordlist?������£�����ϣ��ʵ��һ��ƴд�����������ѯ����ת��Ϊ��ȷ�ĵ��ʡ�
 * <p>
 * ���ڸ����Ĳ�ѯ����?query��ƴд��������ᴦ������ƴд����
 * <p>
 * ��Сд�������ѯƥ�䵥���б��е�ĳ�����ʣ������ִ�Сд�����򷵻ص���ȷ�����뵥���б��еĴ�Сд��ͬ��
 * ���磺wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 * ���磺wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 * ���磺wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * Ԫ����������ڽ���ѯ�����е�Ԫ������a������e������i������o������u�����ֱ��滻Ϊ�κ�Ԫ�������뵥���б��еĵ���ƥ�䣨�����ִ�Сд�����򷵻ص���ȷ�����뵥���б��е�ƥ�����Сд��ͬ��
 * ���磺wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 * ���磺wordlist = ["YellOw"], query = "yeellow": correct = "" ����ƥ���
 * ���磺wordlist = ["YellOw"], query = "yllw": correct = "" ����ƥ���
 * ���⣬ƴд������������������ȼ����������
 * <p>
 * ����ѯ��ȫƥ�䵥���б��е�ĳ�����ʣ����ִ�Сд��ʱ��Ӧ������ͬ�ĵ��ʡ�
 * ����ѯƥ�䵽��Сд����ĵ���ʱ����Ӧ�÷��ص����б��еĵ�һ��������ƥ���
 * ����ѯƥ�䵽Ԫ������ĵ���ʱ����Ӧ�÷��ص����б��еĵ�һ��������ƥ���
 * ����ò�ѯ�ڵ����б���û��ƥ�����Ӧ���ؿ��ַ�����
 * ����һЩ��ѯ queries������һ�������б� answer������ answer[i] ���ɲ�ѯ query = queries[i] �õ�����ȷ���ʡ�
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * �����["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= wordlist.length <= 5000
 * 1 <= queries.length <= 5000
 * 1 <= wordlist[i].length <= 7
 * 1 <= queries[i].length <= 7
 * wordlist ��?queries?�е������ַ�������Ӣ����ĸ��ɡ�
 * ͨ������1,482�ύ����3,899
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/vowel-spellchecker
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Spellchecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] res = new String[queries.length];
        Set<String> dict = new HashSet<>();
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            dict.add(w);
            String lower = w.toLowerCase();
            if (!cap.containsKey(lower)) {
                cap.put(lower, w);
            }
            String v = removeVowel(lower);
            if (!vowel.containsKey(v)) {
                vowel.put(v, w);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            String lowerq = q.toLowerCase();
            String devowelq = removeVowel(lowerq);
            if (dict.contains(q)) {
                res[i] = q;
            } else if (cap.containsKey(lowerq)) {
                res[i] = cap.get(lowerq);
            } else {
                res[i] = vowel.getOrDefault(devowelq, "");
            }
        }
        return res;
    }

    private String removeVowel(String w) {
        StringBuilder sb = new StringBuilder();
        for (char c : w.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
