package code.code;

/**
 * һ����������һЩ����������֮��ĵ����ո���ɣ��Ҿ��ӵĿ�ͷ�ͽ�βû�ж���ո񡣱ȷ�˵��"Hello World"��"HELLO"��"hello world hello world"���Ǿ��ӡ�ÿ�����ʶ� ֻ������д��СдӢ����ĸ��
 * <p>
 * �����������sentence1 ��sentence2������ͨ��������һ�����Ӳ���һ������ľ��ӣ������ǿվ��ӣ����õ���һ�����ӣ���ô���ǳ������������� ���Ƶġ��ȷ�˵��sentence1 = "Hello my name is Jane" ��sentence2 = "Hello Jane"�����ǿ����� sentence2��"Hello" ��"Jane"֮�����"my name is"�õ� sentence1��
 * <p>
 * ������������sentence1 ��sentence2�����sentence1 ��sentence2 �����Ƶģ����㷵��true�����򷵻�false��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺sentence1 = "My name is Haley", sentence2 = "My Haley"
 * �����true
 * ���ͣ������� sentence2 �� "My" �� "Haley" ֮����� "name is" ���õ� sentence1 ��
 * ʾ�� 2��
 * <p>
 * ���룺sentence1 = "of", sentence2 = "A lot of words"
 * �����false
 * ���ͣ�û���������������е�һ������ֻ����һ�����Ӿ͵õ���һ�����ӡ�
 * ʾ�� 3��
 * <p>
 * ���룺sentence1 = "Eating right now", sentence2 = "Eating"
 * �����true
 * ���ͣ������� sentence2 �Ľ�β���� "right now" �õ� sentence1 ��
 * ʾ�� 4��
 * <p>
 * ���룺sentence1 = "Luky", sentence2 = "Lucccky"
 * �����false
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1��sentence2��ֻ������СдӢ����ĸ�Ϳո�
 * sentence1��sentence2�еĵ��ʶ�ֻ�ɵ����ո������
 * ͨ������4,850�ύ����9,044
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sentence-similarity-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class AreSentencesSimilar3 {

    public boolean areSentencesSimilar(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        int i = 0;
        int n1 = words1.length;
        int n2 = words2.length;
        if (n1 > n2) {
            return areSentencesSimilar(s2, s1);
        }
        while (i < n1 && words1[i].equals(words2[i])) {
            ++i;
        }
        while (i < n1 && words1[i].equals(words2[n2 - n1 + i])) {
            ++i;
        }
        return i == n1;
    }

}
