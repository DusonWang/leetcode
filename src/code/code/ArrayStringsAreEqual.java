package code.code;

/**
 * ���������ַ������� word1 �� word2 ��������������ʾ���ַ�����ͬ������ true �����򣬷��� false ��
 * <p>
 * �����ʾ���ַ���?���������е�����Ԫ�� ��˳�� �����γɵ��ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺word1 = ["ab", "c"], word2 = ["a", "bc"]
 * �����true
 * ���ͣ�
 * word1 ��ʾ���ַ���Ϊ "ab" + "c" -> "abc"
 * word2 ��ʾ���ַ���Ϊ "a" + "bc" -> "abc"
 * �����ַ�����ͬ������ true
 * ʾ�� 2��
 * <p>
 * ���룺word1 = ["a", "cb"], word2 = ["ab", "c"]
 * �����false
 * ʾ�� 3��
 * <p>
 * ���룺word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * �����true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] �� word2[i] ��Сд��ĸ���
 * ͨ������15,888�ύ����19,379
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int len1 = word1.length;
        int len2 = word2.length;
        int i = 0;
        int j = 0;
        int p1 = 0;
        int p2 = 0;
        while (i < len1 && j < len2) {
            String str = word1[i];
            String str2 = word2[j];
            while (p1 < str.length() && p2 < str2.length()) {
                if (str.charAt(p1) != str2.charAt(p2)) {
                    return false;
                }
                p1++;
                p2++;
            }
            if (p1 == str.length()) {
                p1 = 0;
                i++;
            }
            if (p2 == str2.length()) {
                p2 = 0;
                j++;
            }
        }
        return p1 == 0 && p2 == 0;
    }
}
