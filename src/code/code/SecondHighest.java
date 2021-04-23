package code.code;

/**
 * ����һ������ַ���?s?�����㷵�� s?�� �ڶ��� �����֣���������ڵڶ�������֣����㷵�� -1?��
 * <p>
 * ����ַ��� ��СдӢ����ĸ��������ɡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "dfa12321afd"
 * �����2
 * ���ͣ������� s �е����ְ��� [1, 2, 3] ���ڶ���������� 2 ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "abc1111"
 * �����-1
 * ���ͣ������� s �е�����ֻ���� [1] ��û�еڶ�������֡�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 500
 * s?ֻ����СдӢ����ĸ�ͣ������֡�
 * ͨ������4,155�ύ����8,813
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/second-largest-digit-in-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SecondHighest {

    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        SecondHighest secondHighest = new SecondHighest();
        System.out.println(secondHighest.secondHighest("abc1111"));
        System.out.println(secondHighest.secondHighest("dfa12321afd"));
        System.out.println(secondHighest.secondHighest("sjhtz8344"));
        System.out.println(secondHighest.secondHighest("ck077"));

    }

}
