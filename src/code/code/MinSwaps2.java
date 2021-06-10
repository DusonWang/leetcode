package code.code;

/**
 * ����һ���������ַ��� s ������Ҫ����ת��Ϊһ�� �����ַ��� ��������㲢����ת������� ��С �ַ���������������޷����ת�������� -1 ��
 * <p>
 * �����ַ��� ��ָ�������ַ�֮�䲻�������������ַ��������磬�ַ��� "010" �� "1010" ���ڽ����ַ������� "0100" ���ǡ�
 * <p>
 * ���������ַ������Խ��н������������� ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "111000"
 * �����1
 * ���ͣ�����λ�� 1 �� 4��"111000" -> "101010" ���ַ�����Ϊ�����ַ�����
 * ʾ�� 2��
 * <p>
 * ���룺s = "010"
 * �����0
 * ���ͣ��ַ����Ѿ��ǽ����ַ����ˣ�����Ҫ������
 * ʾ�� 3��
 * <p>
 * ���룺s = "1110"
 * �����-1
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 1000
 * s[i] ��ֵΪ '0' �� '1'
 * ͨ������3,841�ύ����10,044
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinSwaps2 {
    public int minSwaps2(String s) {
        int o0 = 0;
        int o1 = 0;
        int e0 = 0;
        int e1 = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                if ((i & 1) == 0) {
                    e0++;
                } else {
                    o0++;
                }
            } else {
                if ((i & 1) == 0) {
                    e1++;
                } else {
                    o1++;
                }
            }
        }
        if (Math.abs(o0 + e0 - o1 - e1) > 1) {
            return -1;
        }
        if (o0 == e1 && o1 == e0) {
            return Math.min(o0, o1);
        }
        return o0 == e1 ? o0 : o1;
    }

    public int minSwaps(String s) {
        int cntOne = 0;
        int cntZero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                ++cntZero;
            } else {
                ++cntOne;
            }
        }
        if (Math.abs(cntOne - cntZero) > 1) {
            return -1;
        }
        if (cntZero > cntOne) {
            return countSwaps(s, '0');
        }
        if (cntZero < cntOne) {
            return countSwaps(s, '1');
        }
        return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
    }

    private int countSwaps(String s, char start) {
        int cntWrongPos = 0;
        for (char c : s.toCharArray()) {
            if (c != start) {
                ++cntWrongPos;
            }
            start = (char) ('1' - start + '0');
        }
        return cntWrongPos / 2;
    }
}
