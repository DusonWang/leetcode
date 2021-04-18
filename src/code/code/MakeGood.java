package code.code;

/**
 * ����һ���ɴ�СдӢ����ĸ��ɵ��ַ��� s ��
 * <p>
 * һ������õ��ַ����У����������ַ� s[i] �� s[i+1]������ 0<= i <= s.length-2 ��Ҫ������������:
 * <p>
 * �� s[i] ��Сд�ַ����� s[i+1] ����������ͬ�Ĵ�д�ַ���
 * �� s[i] �Ǵ�д�ַ����� s[i+1] ����������ͬ��Сд�ַ���
 * ���㽫�ַ�������ã�ÿ���㶼���Դ��ַ�����ѡ���������������� �������� �ַ���ɾ����ֱ���ַ��������Ϊֹ��
 * <p>
 * �뷵������õ� �ַ��� ����Ŀ��֤�ڸ�����Լ�������£�����������Ӧ�Ĵ���Ψһ�ġ�
 * <p>
 * ע�⣺���ַ���Ҳ��������õ��ַ�������������û���κ��ַ���
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "leEeetcode"
 * �����"leetcode"
 * ���ͣ��������һ��ѡ���� i = 1 ���� i = 2������ʹ "leEeetcode" ����Ϊ "leetcode" ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "abBAcC"
 * �����""
 * ���ͣ����ڶ��ֲ�ͬ����������е�������ᵼ����ͬ�Ľ�������磺
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * ʾ�� 3��
 * <p>
 * ���룺s = "s"
 * �����"s"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 100
 * s ֻ����Сд�ʹ�дӢ����ĸ
 * ͨ������15,967�ύ����30,166
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/make-the-string-great
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MakeGood {

    public String makeGood(String s) {
        StringBuilder ret = new StringBuilder();
        int retIndex = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) == Character.toLowerCase(ch)
                    && ret.charAt(retIndex) != ch) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();

    }
}
