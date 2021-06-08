package code.code;

/**
 * ���������ַ���s��t�����Ŀ������ k�β������ڰ��ַ���sת���t��
 * <p>
 * �ڵ� i�β���ʱ��1 <= i <= k���������ѡ��������²�����
 * <p>
 * ѡ���ַ��� s������ 1 <= j <= s.length��֮ǰδ��ѡ���������±� j���±�� 1 ��ʼ����������λ�õ��ַ��л� i�Ρ�
 * �������κβ�����
 * �л� 1 ���ַ�����˼������ĸ���и���ĸ����һ����ĸ�滻������ĸ��״������������ 'z'�л������ 'a'����
 * <p>
 * ���ס����һ���±� j���ֻ�ܱ�����1 �Ρ�
 * <p>
 * ����ڲ����� k�β����ڿ��԰��ַ��� sת��� t����ô���㷵��true���������㷵��false��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "input", t = "ouput", k = 9
 * �����true
 * ���ͣ��� 6 �β���ʱ�����ǽ� 'i' �л� 6 �εõ� 'o' ���� 7 �β���ʱ�����ǽ� 'n' �л� 7 �εõ� 'u' ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "abc", t = "bcd", k = 10
 * �����false
 * ���ͣ�������Ҫ��ÿ���ַ��л� 1 �β��ܵõ� t �����ǿ����ڵ� 1 �β���ʱ�� 'a' �л��� 'b' �������� 2 ����ĸ��ʣ��������޷���ת��Ϊ t �ж�Ӧ��ĸ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "aab", t = "bbb", k = 27
 * �����true
 * ���ͣ��� 1 �β���ʱ�����ǽ���һ�� 'a' �л� 1 �εõ� 'b' ���ڵ� 27 �β���ʱ�����ǽ��ڶ�����ĸ 'a' �л� 27 �εõ� 'b' ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= k <= 10^9
 * s��tֻ����СдӢ����ĸ��
 * ͨ������4,478�ύ����14,311
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/can-convert-string-in-k-moves
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CanConvertString {

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff > 0 && diff + count[diff] * 26 > k) {
                return false;
            }
            ++count[diff];
        }
        return true;
    }

    public static void main(String[] args) {
        CanConvertString canConvertString = new CanConvertString();
        System.out.println(canConvertString.canConvertString("input", "ouput", 9));
    }
}
