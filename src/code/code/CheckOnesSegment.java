package code.code;

/**
 * ����һ���������ַ��� s �����ַ��� ����ǰ���� ��
 * <p>
 * ��� s ������ һ���������� '1' ��ɵ��ֶ� ������ true??? �����򣬷��� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "1001"
 * �����false
 * ���ͣ��ַ����е� 1 û���γ�һ�������ֶΡ�
 * ʾ�� 2��
 * <p>
 * ���룺s = "110"
 * �����true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 100
 * s[i]???? Ϊ '0' �� '1'
 * s[0] Ϊ '1'
 * ͨ������7,073�ύ����17,281
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CheckOnesSegment {

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
//        int x = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '1') {
//                x++;
//                while (i < s.length() - 1) {
//                    i++;
//                    if (s.charAt(i) == '0') {
//                        i--;
//                        break;
//                    }
//                }
//            }
//        }
//        return x == 1;
    }

}
