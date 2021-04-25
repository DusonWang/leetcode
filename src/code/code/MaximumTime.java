package code.code;

/**
 * ����һ���ַ��� time ����ʽΪ hh:mm��Сʱ�����ӣ�������ĳ��λ���ֱ����أ��� ? ��ʾ����
 * <p>
 * ��Ч��ʱ��Ϊ 00:00 �� 23:59 ֮�������ʱ�䣬���� 00:00 �� 23:59 ��
 * <p>
 * �滻?time �����ص����֣���������Եõ���������Чʱ�䡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺time = "2?:?0"
 * �����"23:50"
 * ���ͣ������� '2' ��ͷ������һСʱ�� 23 ���� '0' ��β������һ������ 50 ��
 * ʾ�� 2��
 * <p>
 * ���룺time = "0?:3?"
 * �����"09:39"
 * ʾ�� 3��
 * <p>
 * ���룺time = "1?:22"
 * �����"19:22"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * time �ĸ�ʽΪ hh:mm
 * ��Ŀ���ݱ�֤�������������ַ���������Ч��ʱ��
 * ͨ������6,455�ύ����16,057
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximumTime {

    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        char[] nChars = new char[5];
        nChars[0] = chars[0] != '?' ? chars[0] : (chars[1] > '3'&&chars[1] <= '9' ? '1' : '2');
        nChars[1] = chars[1] != '?' ? chars[1] : (nChars[0] == '2' ? '3' : '9');
        nChars[2] = ':';
        nChars[3] = chars[3] != '?' ? chars[3] : '5';
        nChars[4] = chars[4] != '?' ? chars[4] : '9';
        return new String(nChars);
    }

    public static void main(String[] args) {
        //"?0:15"
        MaximumTime maximumTime = new MaximumTime();
        System.out.println(maximumTime.maximumTime("?0:15"));
        System.out.println(maximumTime.maximumTime("??:3?"));
    }
}
