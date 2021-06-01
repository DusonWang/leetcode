package code.code;

/**
 * ��ĸ�� ��ĸֵ ȡ������ĸ����ĸ���е�λ�ã��� 0 ��ʼ ����������'a' -> 0��'b' -> 1��'c' -> 2���Դ����ơ�
 * <p>
 * ��ĳ����Сд��ĸ��ɵ��ַ���?s ���ԣ��� ��ֵ �͵��ڽ� s ��ÿ����ĸ�� ��ĸֵ ��˳�� ���� �� ת�� �ɶ�Ӧ������
 * <p>
 * ���磬s = "acb" ����������ÿ����ĸ����ĸֵ���Եõ� "021" ��ת��Ϊ�����õ� 21 ��
 * ���������ַ��� firstWord��secondWord �� targetWord ��ÿ���ַ������ɴ� 'a' �� 'j' ����?'a' �� 'j' ����СдӢ����ĸ��ɡ�
 * <p>
 * ���?firstWord �� secondWord �� ��ֵ֮�� ���� targetWord ����ֵ������ true �����򣬷��� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺firstWord = "acb", secondWord = "cba", targetWord = "cdb"
 * �����true
 * ���ͣ�
 * firstWord ����ֵΪ "acb" -> "021" -> 21
 * secondWord ����ֵΪ "cba" -> "210" -> 210
 * targetWord ����ֵΪ "cdb" -> "231" -> 231
 * ���� 21 + 210 == 231 ������ true
 * ʾ�� 2��
 * <p>
 * ���룺firstWord = "aaa", secondWord = "a", targetWord = "aab"
 * �����false
 * ���ͣ�
 * firstWord ����ֵΪ "aaa" -> "000" -> 0
 * secondWord ����ֵΪ "a" -> "0" -> 0
 * targetWord ����ֵΪ "aab" -> "001" -> 1
 * ���� 0 + 0 != 1 ������ false
 * ʾ�� 3��
 * <p>
 * ���룺firstWord = "aaa", secondWord = "a", targetWord = "aaaa"
 * �����true
 * ���ͣ�
 * firstWord ����ֵΪ "aaa" -> "000" -> 0
 * secondWord ����ֵΪ "a" -> "0" -> 0
 * targetWord ����ֵΪ "aaaa" -> "0000" -> 0
 * ���� 0 + 0 == 0 ������ true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= firstWord.length, secondWord.length, targetWord.length <= 8
 * firstWord��secondWord �� targetWord ���ɴ� 'a' �� 'j' ����?'a' �� 'j' ����СдӢ����ĸ��ɡ�
 * ͨ������4,809�ύ����6,122
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-word-equals-summation-of-two-words
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsSumEqual {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = getValue(firstWord);
        int second = getValue(secondWord);
        int target = getValue(targetWord);
        return first + second == target;

    }

    public int getValue(String str) {
        char[] chars = str.toCharArray();
        int value = 0;
        for (char aChar : chars) {
            value = value * 10 + (aChar - 'a');
        }
        return value;
    }

    public static void main(String[] args) {
        IsSumEqual isSumEqual = new IsSumEqual();
        System.out.println(isSumEqual.isSumEqual("acb", "cba", "cdb"));
        System.out.println(isSumEqual.isSumEqual("aaa", "a", "aaaa"));
        System.out.println(isSumEqual.isSumEqual("aaa", "a", "aab"));

    }

}
