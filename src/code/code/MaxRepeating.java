package code.code;

/**
 * ����һ���ַ���?sequence?������ַ��� word?�����ظ�?k?���γɵ��ַ�����?sequence?��һ�����ַ�������ô����?word �� �ظ�ֵΪ k ������ word?�� ����ظ�ֵ?�ǵ���?word?��?sequence?�������ظ�ֵ�����?word?����?sequence?���Ӵ�����ô�ظ�ֵ?k?Ϊ 0 ��
 * <p>
 * ����һ���ַ��� sequence?�� word?�����㷵�� ����ظ�ֵ?k ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺sequence = "ababc", word = "ab"
 * �����2
 * ���ͣ�"abab" �� "ababc" �����ַ�����
 * ʾ�� 2��
 * <p>
 * ���룺sequence = "ababc", word = "ba"
 * �����1
 * ���ͣ�"ba" �� "ababc" �����ַ������� "baba" ���� "ababc" �����ַ�����
 * ʾ�� 3��
 * <p>
 * ���룺sequence = "ababc", word = "ac"
 * �����0
 * ���ͣ�"ac" ���� "ababc" �����ַ�����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence ��?word?��ֻ����СдӢ����ĸ��
 * ͨ������4,792�ύ����11,117
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-repeating-substring
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxRepeating {

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }

    public static void main(String[] args) {
        MaxRepeating maxRepeating = new MaxRepeating();
        System.out.println(maxRepeating.maxRepeating("ababc","ab"));
        System.out.println(maxRepeating.maxRepeating("ababc","ba"));
        System.out.println(maxRepeating.maxRepeating("ababc","ac"));

        System.out.println(maxRepeating.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));

    }
}
