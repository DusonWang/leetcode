package code.code;

/**
 * ���������ַ��� word1 �� word2 ������� word1 ��ʼ��ͨ�����������ĸ���ϲ��ַ��������һ���ַ�������һ���ַ��������ͽ����������ĸ׷�ӵ��ϲ����ַ�����ĩβ��
 * <p>
 * ���� �ϲ�����ַ��� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺word1 = "abc", word2 = "pqr"
 * �����"apbqcr"
 * ���ͣ��ַ����ϲ����������ʾ��
 * word1��  a   b   c
 * word2��    p   q   r
 * �ϲ���  a p b q c r
 * ʾ�� 2��
 * <p>
 * ���룺word1 = "ab", word2 = "pqrs"
 * �����"apbqrs"
 * ���ͣ�ע�⣬word2 �� word1 ����"rs" ��Ҫ׷�ӵ��ϲ����ַ�����ĩβ��
 * word1��  a   b
 * word2��    p   q   r   s
 * �ϲ���  a p b q   r   s
 * ʾ�� 3��
 * <p>
 * ���룺word1 = "abcd", word2 = "pq"
 * �����"apbqcd"
 * ���ͣ�ע�⣬word1 �� word2 ����"cd" ��Ҫ׷�ӵ��ϲ����ַ�����ĩβ��
 * word1��  a   b   c   d
 * word2��    p   q
 * �ϲ���  a p b q c   d
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 �� word2 ��СдӢ����ĸ���
 * ͨ������8,089�ύ����10,425
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-strings-alternately
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int idx = 0;
        char[] res = new char[len1 + len2];
        for (int i = 0; i < len1 || i < len2; ++i) {
            if (i < len1) {
                res[idx++] = word1.charAt(i);
            }
            if (i < len2) {
                res[idx++] = word2.charAt(i);
            }
        }
        return new String(res);
    }
}
