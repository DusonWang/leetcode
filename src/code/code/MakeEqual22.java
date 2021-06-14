package code.code;

/**
 * ����һ���ַ������� words���±� �� 0 ��ʼ ��������
 * <p>
 * ��һ�������У�����ѡ������ ��ͬ �±� i �� j������ words[i] ��һ���ǿ��ַ��������Ž� words[i] �е� ��һ �ַ��ƶ��� words[j] �е� ��һ λ���ϡ�
 * <p>
 * ���ִ�����ⲽ��������ʹ words �е�ÿ���ַ�������ȣ����� true �����򣬷��� false ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺words = ["abc","aabc","bc"]
 * �����true
 * ���ͣ��� words[1] �еĵ�һ�� 'a' �ƶ��� words[2] ����ǰ�档
 * ʹ words[1] = "abc" �� words[2] = "abc" ��
 * �����ַ��������� "abc" �����Է��� true ��
 * ʾ�� 2��
 * <p>
 * ���룺words = ["ab","a"]
 * �����false
 * ���ͣ�ִ�в����޷�ʹ�����ַ�������ȡ�
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] ��СдӢ����ĸ���
 * ͨ������3,742�ύ����7,655
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/redistribute-characters-to-make-all-strings-equal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MakeEqual22 {

    public boolean makeEqual(String[] words) {
        int[] mp = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                mp[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (mp[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
