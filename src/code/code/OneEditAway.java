package code.code;

/**
 * �ַ��������ֱ༭����:����һ���ַ���ɾ��һ���ַ������滻һ���ַ��� ���������ַ�������дһ�������ж������Ƿ�ֻ��Ҫһ��(�������)�༭��
 * <p>
 * <p>
 * ʾ��?1:
 * <p>
 * ����:
 * first = "pale"
 * second = "ple"
 * ���: True
 * <p>
 * ʾ��?2:
 * <p>
 * ����:
 * first = "pales"
 * second = "pal"
 * ���: False
 * ͨ������5,902�ύ����18,716
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/one-away-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        int i = 0, j = len1 - 1, k = len2 - 1;
        while (i < len1 && i < len2 && first.charAt(i) == second.charAt(i)) {
            ++i;
        }
        while (j >= 0 && k >= 0 && first.charAt(j) == second.charAt(k)) {
            --j;
            --k;
        }
        return j - i < 1 && k - i < 1;
    }

}
