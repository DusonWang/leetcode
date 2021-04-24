package code.code;

/**
 * ����һ��������СдӢ����ĸ�� '?' �ַ����ַ��� s�����㽫���е� '?' ת��Ϊ����Сд��ĸ��ʹ���յ��ַ����������κ� �����ظ� ���ַ���
 * <p>
 * ע�⣺�� ���� �޸ķ� '?' �ַ���
 * <p>
 * ��Ŀ����������֤ �� '?' �ַ� ֮�⣬�����������ظ����ַ���
 * <p>
 * ���������ת������������ת�����󷵻����յ��ַ���������ж������������뷵�������κ�һ��������֤�����ڸ�����Լ�������£������Ǵ��ڵġ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "?zs"
 * �����"azs"
 * ���ͣ���ʾ������ 25 �ֽ���������� "azs" �� "yzs" ���Ƿ�����ĿҪ��ġ�ֻ�� "z" ����Ч���޸ģ���Ϊ�ַ��� "zzs" ���������ظ������� 'z' ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "ubv?w"
 * �����"ubvaw"
 * ���ͣ���ʾ������ 24 �ֽ��������ֻ���滻�� "v" �� "w" ��������ĿҪ����Ϊ "ubvvw" �� "ubvww" �����������ظ����ַ���
 * ʾ�� 3��
 * <p>
 * ���룺s = "j?qg??b"
 * �����"jaqgacb"
 * ʾ�� 4��
 * <p>
 * ���룺s = "??yw?ipkj?"
 * �����"acywaipkja"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length?<= 100
 * <p>
 * s ������СдӢ����ĸ�� '?' �ַ�
 * <p>
 * ͨ������15,822�ύ����33,475
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ModifyString {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                char ahead = i == 0 ? ' ' : chars[i - 1];
                char behind  = i == chars.length - 1 ? ' ' : chars[i + 1];
                char temp = 'a';
                while (temp == ahead || temp == behind ) {
                    temp++;
                }
                chars[i] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ModifyString modifyString = new ModifyString();
        System.out.println(modifyString.modifyString("?zs"));
        System.out.println(modifyString.modifyString("ubv?w"));
        System.out.println(modifyString.modifyString("j?qg??b"));
        System.out.println(modifyString.modifyString("??yw?ipkj?"));



    }
}
