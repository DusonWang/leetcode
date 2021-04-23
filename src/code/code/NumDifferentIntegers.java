package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * ����һ���ַ��� word �����ַ��������ֺ�СдӢ����ĸ��ɡ�
 *
 * �����ÿո��滻ÿ���������ֵ��ַ������磬"a123bc34d8ef34" ������ " 123? 34 8? 34" ��ע�⣬ʣ�µ���Щ����Ϊ�����ڱ˴�������һ���ո��������"123"��"34"��"8" �� "34" ��
 *
 * ���ض� word ����滻���γɵ� ��ͬ ��������Ŀ��
 *
 * ֻ�е����������� ����ǰ���� ��ʮ���Ʊ�ʾ��ͬ�� ����Ϊ����������Ҳ��ͬ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺word = "a123bc34d8ef34"
 * �����3
 * ���ͣ���ͬ�������� "123"��"34" �� "8" ��ע�⣬"34" ֻ����һ�Ρ�
 * ʾ�� 2��
 *
 * ���룺word = "leet1234code234"
 * �����2
 * ʾ�� 3��
 *
 * ���룺word = "a1b01c001"
 * �����1
 * ���ͣ�"1"��"01" �� "001" ��Ϊͬһ��������ʮ���Ʊ�ʾ����Ϊ�ڱȽ�ʮ����ֵʱ�����ǰ����Ĵ��ڡ�
 * ?
 *
 * ��ʾ��
 *
 * 1 <= word.length <= 1000
 * word �����ֺ�СдӢ����ĸ���
 * ͨ������9,337�ύ����17,811
 * ��������������Ƹ����������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-different-integers-in-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class NumDifferentIntegers {

    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set<String> strings = new HashSet<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                while (i < chars.length && chars[i] == '0') {
                    i++;
                }
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                    number.append(chars[i]);
                    i++;
                }
                strings.add(number.toString());
                number.setLength(0);
            }
        }
        return strings.size();
    }
}
