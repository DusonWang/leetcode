package code.code;

import java.util.Arrays;

/**
 * �������ʹ�����²�����һ���ַ����õ���һ���ַ���������Ϊ�����ַ��� �ӽ� ��
 * <p>
 * ���� 1�������������� ���� �ַ���
 * ���磬abcde -> aecdb
 * ���� 2����һ�� ���� �ַ���ÿ�γ���ת��Ϊ��һ�� ���� �ַ���������һ���ַ�ִ����ͬ�Ĳ�����
 * ���磬aacabb -> bbcbaa������ a ת��Ϊ b �������е� b ת��Ϊ a ��
 * ����Ը�����Ҫ������һ���ַ������ʹ�������ֲ�����
 * <p>
 * ���������ַ�����word1 �� word2 ����� word1 �� word2 �ӽ� ���ͷ��� true �����򣬷��� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺word1 = "abc", word2 = "bca"
 * �����true
 * ���ͣ�2 �β����� word1 ��� word2 ��
 * ִ�в��� 1��"abc" -> "acb"
 * ִ�в��� 1��"acb" -> "bca"
 * ʾ�� 2��
 * <p>
 * ���룺word1 = "a", word2 = "aa"
 * �����false
 * ���ͣ�����ִ�ж��ٴβ��������޷��� word1 �õ� word2 ����֮��Ȼ��
 * ʾ�� 3��
 * <p>
 * ���룺word1 = "cabbba", word2 = "abbccc"
 * �����true
 * ���ͣ�3 �β����� word1 ��� word2 ��
 * ִ�в��� 1��"cabbba" -> "caabbb"
 * ִ�в��� 2��"caabbb" -> "baaccc"
 * ִ�в��� 2��"baaccc" -> "abbccc"
 * ʾ�� 4��
 * <p>
 * ���룺word1 = "cabbba", word2 = "aabbss"
 * �����false
 * ���ͣ�����ִ�ж��ٴβ��������޷��� word1 �õ� word2 ����֮��Ȼ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= word1.length, word2.length <= 105
 * word1 �� word2 ������СдӢ����ĸ
 * ͨ������4,874�ύ����10,548
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/determine-if-two-strings-are-close
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < len1; i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0 && count2[i] == 0 || count2[i] > 0 && count1[i] == 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
