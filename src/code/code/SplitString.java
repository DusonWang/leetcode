package code.code;

/**
 * ����һ������������ɵ��ַ��� s ��
 * <p>
 * �����ж��ܷ� s ��ֳ��������߶�� �ǿ����ַ��� ��ʹ���ַ����� ��ֵ �� ���� ���У���ÿ���� �������ַ��� ����ֵ֮ �� ���� 1 ��
 * <p>
 * ���磬�ַ��� s = "0090089" ���Բ�ֳ� ["0090", "089"] ����ֵΪ [90,89] ����Щ��ֵ���㰴�������У�������ֵ��� 1 �����ֲ�ַ������С�
 * ��һ�������У��ַ��� s = "001" ���Բ�ֳ� ["0", "01"]��["00", "1"] �� ["0", "0", "1"] ��Ȼ����������Щ��ַ����������У���Ϊ��Ӧ��ֵ�ֱ��� [0,1]��[0,1] �� [0,0,1] ���������㰴�������е�Ҫ��
 * ������԰�Ҫ���� s ������ true �����򣬷��� false ��
 * <p>
 * ���ַ��� ���ַ����е�һ�������ַ����С�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "1234"
 * �����false
 * ���ͣ������ڲ�� s �Ŀ��з�����
 * ʾ�� 2��
 * <p>
 * ���룺s = "050043"
 * �����true
 * ���ͣ�s ���Բ��Ϊ ["05", "004", "3"] ����Ӧ��ֵΪ [5,4,3] ��
 * ���㰴�������У�������ֵ��� 1 ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "9080701"
 * �����false
 * ���ͣ������ڲ�� s �Ŀ��з�����
 * ʾ�� 4��
 * <p>
 * ���룺s = "10009998"
 * �����true
 * ���ͣ�s ���Բ��Ϊ ["100", "099", "98"] ����Ӧ��ֵΪ [100,99,98] ��
 * ���㰴�������У�������ֵ��� 1 ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 20
 * s �����������
 * ͨ������4,960�ύ����15,024
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/splitting-a-string-into-descending-consecutive-values
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SplitString {

    public boolean splitString(String s) {
        return isRemainingValid(s, null);
    }

    private boolean isRemainingValid(String s, Long previous) {
        long current = 0;
        for (int i = 0; i < s.length(); i++) {
            current = current * 10 + s.charAt(i) - '0';
            if (current >= 10000000000L) {
                return false;
            }
            if (previous == null) {
                if (isRemainingValid(s.substring(i + 1), current)) {
                    return true;
                }
            } else if (current == previous - 1 && (i == s.length() - 1 || isRemainingValid(s.substring(i + 1), current))) {
                return true;
            }
        }
        return false;
    }

}
