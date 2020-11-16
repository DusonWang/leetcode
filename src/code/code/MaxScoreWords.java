package code.code;

/**
 * �㽫��õ�һ�ݵ��ʱ�?words��һ����ĸ��?letters?�����ܻ����ظ���ĸ�����Լ�ÿ����ĸ��Ӧ�ĵ÷������?score��
 * <p>
 * �����æ��������ڵ���ƴд��Ϸ�����ܻ�õġ���ߵ÷֡����ܹ���?letters?�����ĸƴд����?����?���� words?�����Ӽ��У�������ߵĵ��ʼ��ϵĵ÷֡�
 * <p>
 * ����ƴд��Ϸ�Ĺ���������£�
 * <p>
 * �����Ҫ����ĸ��?letters �����ĸ��ƴд���ʱ�?words?�еĵ��ʡ�
 * ����ֻʹ����ĸ��?letters �еĲ�����ĸ������ÿ����ĸ��౻ʹ��һ�Ρ�
 * ���ʱ� words?��ÿ������ֻ�ܼƷ֣�ʹ�ã�һ�Ρ�
 * ������ĸ�÷������score����ĸ 'a',?'b',?'c', ... ,?'z' ��Ӧ�ĵ÷ֱַ�Ϊ score[0], score[1],?...,?score[25]��
 * ������Ϸ�ġ��÷֡���ָ�������ƴд���ĵ��ʼ����������������ĸ�ĵ÷�֮�͡�
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
 * �����23
 * ���ͣ�
 * ��ĸ�÷�Ϊ  a=1, c=9, d=5, g=3, o=2
 * ʹ�ø�������ĸ�� letters�����ǿ���ƴд���� "dad" (5+1+5)�� "good" (3+2+2+5)���÷�Ϊ 23 ��
 * ������ "dad" �� "dog" ֻ�ܵõ� 21 �֡�
 * ʾ�� 2��
 * <p>
 * ���룺words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
 * �����27
 * ���ͣ�
 * ��ĸ�÷�Ϊ  a=4, b=4, c=4, x=5, z=10
 * ʹ�ø�������ĸ�� letters�����ǿ�����ɵ��� "ax" (4+5)�� "bx" (4+5) �� "cx" (4+5) ���ܵ÷�Ϊ 27 ��
 * ���� "xxxz" �ĵ÷ֽ�Ϊ 25 ��
 * ʾ�� 3��
 * <p>
 * ���룺words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
 * �����0
 * ���ͣ�
 * ��ĸ "e" ����ĸ�� letters ��ֻ������һ�Σ������޷���ɵ��ʱ� words �еĵ��ʡ�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= words.length <= 14
 * 1 <= words[i].length <= 15
 * 1 <= letters.length <= 100
 * letters[i].length == 1
 * score.length ==?26
 * 0 <= score[i] <= 10
 * words[i]?��?letters[i]?ֻ����Сд��Ӣ����ĸ��
 * ͨ������1,544�ύ����2,412
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-score-words-formed-by-letters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author duson
 */
public class MaxScoreWords {

    private int res = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] table = new int[26];
        for (char c : letters) {
            table[c - 'a']++;
        }
        helper(words, score, table, 0, 0);
        return res;
    }

    public void helper(String[] words, int[] score, int[] curr, int i, int currScore) {
        res = Math.max(res, currScore);
        for (; i < words.length; i++) {
            String word = words[i];
            int[] temp = new int[26];
            int val = currScore;
            System.arraycopy(curr, 0, temp, 0, 26);
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (temp[c - 'a'] == 0) {
                    flag = false;
                    break;
                }
                temp[c - 'a']--;
                val += score[c - 'a'];
            }
            if (!flag) {
                continue;
            }
            helper(words, score, temp, i + 1, val);
        }
    }
}
