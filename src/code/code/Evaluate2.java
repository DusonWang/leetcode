package code.code;

import java.util.HashMap;
import java.util.List;

/**
 * ����һ���ַ���?s?��������һЩ���Ŷԣ�ÿ�������а���һ�� �ǿ�?�ļ���
 * <p>
 * �ȷ�˵���ַ���?"(name)is(age)yearsold"?�У���?����?���Ŷԣ��ֱ������?"name" ��?"age"?��
 * ��֪��������Ӧ��ֵ����Щ��ϵ�ɶ�ά�ַ�������?knowledge?��ʾ������?knowledge[i] = [keyi, valuei]?����ʾ��?keyi?��Ӧ��ֵΪ?valuei?��
 * <p>
 * ����Ҫ�滻 ����?�����Ŷԡ������滻һ�����Ŷԣ����������ļ�Ϊ?keyi?ʱ������Ҫ��
 * <p>
 * ��?keyi?�������ö�Ӧ��ֵ?valuei?�滻��
 * ����� knowledge?���޷���֪ĳ������Ӧ��ֵ������Ҫ��?keyi?���������ʺ�?"?"?�滻������Ҫ���ţ���
 * knowledge?��ÿ�������ֻ�����һ�Ρ�s?�в�����Ƕ�׵����š�
 * <p>
 * ���㷵���滻 ����?���ŶԺ�Ľ���ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * �����"bobistwoyearsold"
 * ���ͣ�
 * �� "name" ��Ӧ��ֵΪ "bob" �����Խ� "(name)" �滻Ϊ "bob" ��
 * �� "age" ��Ӧ��ֵΪ "two" �����Խ� "(age)" �滻Ϊ "two" ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "hi(name)", knowledge = [["a","b"]]
 * �����"hi?"
 * ���ͣ����ڲ�֪���� "name" ��Ӧ��ֵ�������� "?" �滻 "(name)" ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
 * �����"yesyesyesaaa"
 * ���ͣ���ͬ�ļ��� s �п��ܻ���ֶ�Ρ�
 * �� "a" ��Ӧ��ֵΪ "yes" �����Խ����е� "(a)" �滻Ϊ "yes" ��
 * ע�⣬����������� "a" ����Ҫ���滻��
 * ʾ�� 4��
 * <p>
 * ���룺s = "(a)(b)", knowledge = [["a","b"],["b","a"]]
 * �����"ba"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 105
 * 0 <= knowledge.length <= 105
 * knowledge[i].length == 2
 * 1 <= keyi.length, valuei.length <= 10
 * s?ֻ����СдӢ����ĸ��Բ����?'('?��?')'?��
 * s?��ÿһ����Բ����?'('?���ж�Ӧ����Բ����?')'?��
 * s?��ÿ�������ڵļ�������Ϊ�ա�
 * s?�в�����Ƕ�����Ŷԡ�
 * keyi?��?valuei?ֻ����СдӢ����ĸ��
 * knowledge?�е�?keyi?�����ظ���
 * ͨ������5,089�ύ����8,698
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/evaluate-the-bracket-pairs-of-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Evaluate2 {

    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> str : knowledge) {
            map.put(str.get(0), str.get(1));
        }
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (ch == '(') {
                StringBuilder key = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ')') {
                    key.append(s.charAt(i++));
                }
                sb.append(map.getOrDefault(key.toString(), "?"));
                i++;
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
