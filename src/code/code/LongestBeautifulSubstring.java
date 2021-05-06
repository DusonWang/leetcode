package code.code;

/**
 * ��һ���ַ���������������ʱ�����ǳ����� ������?��
 * <p>
 * ���� 5 ��Ӣ��Ԫ����ĸ��'a'?��'e'?��'i'?��'o'?��'u'��������?����?����һ�Ρ�
 * ��ЩԪ����ĸ��˳�򶼱��밴�� �ֵ���?�����Ų���Ҳ����˵���е� 'a'?���� 'e'?ǰ�棬���е� 'e'?���� 'i'?ǰ�棬�Դ����ƣ�
 * �ȷ�˵���ַ���?"aeiou" ��?"aaaaaaeiiiioou"?���� ������?������?"uaeio"?��"aeoiu"?��?"aaaeeeooo"?����������?��
 * <p>
 * ����һ��ֻ����Ӣ��Ԫ����ĸ���ַ���?word?�����㷵��?word �� ��������ַ����ĳ���?��������������������ַ������뷵�� 0?��
 * <p>
 * ���ַ��� ���ַ�����һ���������ַ����С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * �����13
 * ���ͣ�����ַ����� "aaaaeiiiiouuu" ������Ϊ 13 ��
 * ʾ�� 2��
 * <p>
 * ���룺word = "aeeeiiiioooauuuaeiou"
 * �����5
 * ���ͣ�����ַ����� "aeiou" ������Ϊ 5 ��
 * ʾ�� 3��
 * <p>
 * ���룺word = "a"
 * �����0
 * ���ͣ�û���������ַ��������Է��� 0 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= word.length <= 5 * 105
 * word?ֻ�����ַ�?'a'��'e'��'i'��'o'?��?'u'?��
 * ͨ������5,283�ύ����8,758
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-substring-of-all-vowels-in-order
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestBeautifulSubstring {

    public int longestBeautifulSubstring(String word) {
        int index = 0;
        int len = word.length();
        char[] ch = word.toCharArray();
        int res = 0;
        while (index < len) {
            while (index < len && ch[index] != 'a') {
                index++;
            }
            if (index < len && ch[index] == 'a') {
                int l = index;
                while (index < len && ch[index] == 'a') {
                    index++;
                }
                if (index < len && ch[index] == 'e') {
                    while (index < len && ch[index] == 'e') {
                        index++;
                    }
                } else {
                    continue;
                }
                if (index < len && ch[index] == 'i') {
                    while (index < len && ch[index] == 'i') {
                        index++;
                    }
                } else {
                    continue;
                }
                if (index < len && ch[index] == 'o') {
                    while (index < len && ch[index] == 'o') {
                        index++;
                    }
                } else {
                    continue;
                }
                if (index < len && ch[index] == 'u') {
                    while (index < len && ch[index] == 'u') {
                        index++;
                    }
                } else {
                    continue;
                }
                res = Math.max(res, index - l);
            }
        }
        return res;
    }
}
