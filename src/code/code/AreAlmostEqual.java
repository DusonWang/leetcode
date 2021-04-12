package code.code;

/**
 * ���㳤����ȵ������ַ��� s1 �� s2 ��һ�� �ַ������� �����Ĳ������£�ѡ��ĳ���ַ����е������±꣨���ز�ͬ�����������������±�����Ӧ���ַ���
 * <p>
 * ����� ����һ���ַ��� ִ�� ���һ���ַ������� �Ϳ���ʹ�����ַ�����ȣ����� true �����򣬷��� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s1 = "bank", s2 = "kanb"
 * �����true
 * ���ͣ����磬���� s2 �еĵ�һ�������һ���ַ����Եõ� "bank"
 * ʾ�� 2��
 * <p>
 * ���룺s1 = "attack", s2 = "defend"
 * �����false
 * ���ͣ�һ���ַ��������޷�ʹ�����ַ������
 * ʾ�� 3��
 * <p>
 * ���룺s1 = "kelb", s2 = "kelb"
 * �����true
 * ���ͣ������ַ����Ѿ���ȣ����Բ���Ҫ�����ַ�������
 * ʾ�� 4��
 * <p>
 * ���룺s1 = "abcd", s2 = "dcba"
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 �� s2 ����СдӢ����ĸ���
 * ͨ������10,615�ύ����15,396
 * <p>
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class AreAlmostEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] arr = new int[3];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                arr[count] = i;
                count++;
            }
            if (count >= 3) {
                return false;
            }
        }
        if (count == 1) {
            return false;
        }
        return s1.charAt(arr[0]) == s2.charAt(arr[1]) && s2.charAt(arr[0]) == s1.charAt(arr[1]);
    }

}
