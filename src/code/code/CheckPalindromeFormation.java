package code.code;

/**
 * ���������ַ���?a ��?b?�����ǳ�����ͬ������ѡ��һ���±꣬�������ַ�������?��ͬ���±� �ָ����?a?���Եõ������ַ�����?aprefix?��?asuffix?������?a = aprefix + asuffix?��ͬ����?b ���Եõ������ַ���?bprefix ��?bsuffix?������?b = bprefix + bsuffix?�������ж�?aprefix + bsuffix ����?bprefix + asuffix?�ܷ񹹳ɻ��Ĵ���
 * <p>
 * ���㽫һ���ַ���?s?�ָ��?sprefix ��?ssuffix?ʱ��?ssuffix ����?sprefix ����Ϊ�ա��ȷ�˵��?s = "abc"?��ô?"" + "abc"?��?"a" + "bc"?��?"ab" + "c"?��?"abc" + ""?���ǺϷ��ָ
 * <p>
 * ��� �ܹ��ɻ����ַ��� ����ô�뷵��?true�����򷵻�?false?��
 * <p>
 * ע�⣬?x + y?��ʾ�����ַ���?x ��?y?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺a = "x", b = "y"
 * �����true
 * ���ͣ���� a ���� b �ǻ��Ĵ�����ô��һ��Ϊ true ����Ϊ��������·ָ
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * ��ô aprefix + bsuffix = "" + "y" = "y" �ǻ��Ĵ���
 * ʾ�� 2��
 * <p>
 * ���룺a = "abdef", b = "fecab"
 * �����true
 * ʾ�� 3��
 * <p>
 * ���룺a = "ulacfd", b = "jizalu"
 * �����true
 * ���ͣ����±�Ϊ 3 ���ָ
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * ��ô aprefix + bsuffix = "ula" + "alu" = "ulaalu" �ǻ��Ĵ���
 * ʾ�� 4��
 * <p>
 * ���룺a = "xbdef", b = "xecab"
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= a.length, b.length <= 105
 * a.length == b.length
 * a ��?b?��ֻ����СдӢ����ĸ
 * ͨ������4,608�ύ����16,749
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/split-two-strings-to-make-palindrome
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CheckPalindromeFormation {

    public boolean isPa(String s, int i, int j) {
        for (; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean check(String a, String b) {
        for (int i = 0, j = b.length() - 1; i < j; ++i, --j) {
            if (a.charAt(i) != b.charAt(j)) {
                return isPa(a, i, j) || isPa(b, i, j);
            }
        }
        return true;
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

}
