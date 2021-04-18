package code.code;

/**
 * ȫ��ĸ�� ָ����Ӣ����ĸ����ÿ����ĸ����һ�εľ��ӡ�
 * <p>
 * ����һ������СдӢ����ĸ��ɵ��ַ��� sentence �������ж�?sentence �Ƿ�Ϊ ȫ��ĸ�� ��
 * <p>
 * ����ǣ����� true �����򣬷��� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺sentence = "thequickbrownfoxjumpsoverthelazydog"
 * �����true
 * ���ͣ�sentence ����Ӣ����ĸ����ÿ����ĸ����һ�Ρ�
 * ʾ�� 2��
 * <p>
 * ���룺sentence = "leetcode"
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= sentence.length <= 1000
 * sentence ��СдӢ����ĸ���
 * ͨ������4,328�ύ����5,004
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CheckIfPangram {

    public boolean checkIfPangram(String sentence) {
        if (sentence == null || sentence.length() < 26) {
            return false;
        }
        int[] chars = new int[26];
        for (char c : sentence.toCharArray()) {
            chars[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
