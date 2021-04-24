package code.code;

/**
 * ����һ���ɲ�ͬ�ַ���ɵ��ַ���?allowed?��һ���ַ�������?words?�����һ���ַ�����ÿһ���ַ����� allowed?�У��ͳ�����ַ����� һ���ַ��� ��
 * <p>
 * ���㷵��?words?������?һ���ַ��� ����Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * �����2
 * ���ͣ��ַ��� "aaab" �� "baa" ����һ���ַ�������Ϊ����ֻ�����ַ� 'a' �� 'b' ��
 * ʾ�� 2��
 * <p>
 * ���룺allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * �����7
 * ���ͣ������ַ�������һ�µġ�
 * ʾ�� 3��
 * <p>
 * ���룺allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * �����4
 * ���ͣ��ַ��� "cc"��"acd"��"ac" �� "d" ��һ���ַ�����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed?�е��ַ� ������ͬ?��
 * words[i] ��?allowed?ֻ����СдӢ����ĸ��
 * ͨ������12,492�ύ����15,098
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] arr = new boolean[26];
        int sum = 0;
        for (int i = 0; i < allowed.length(); i++) {
            arr[allowed.charAt(i) - 'a'] = true;
        }
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (!arr[word.charAt(j) - 'a']) {
                    sum++;
                    break;
                }
            }
        }
        return words.length - sum;
    }
}
