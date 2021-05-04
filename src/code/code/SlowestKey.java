package code.code;

/**
 * LeetCode �����һ����ʽ���̣����ڲ���������ԡ�������Ա������һϵ�м����ܼ� n ������ÿ��һ����
 * <p>
 * ����һ������Ϊ n ���ַ��� keysPressed ������ keysPressed[i] ��ʾ���������е� i �������µļ���releaseTimes ��һ���������е��б����� releaseTimes[i] ��ʾ�ɿ��� i ������ʱ�䡣�ַ���������� �±궼�� 0 ��ʼ ���� 0 ������ʱ��Ϊ 0 ʱ�����£�������ÿ������ ǡ�� ��ǰһ�����ɿ�ʱ�����¡�
 * <p>
 * ������Ա��Ҫ�ҳ����� ����ʱ��� �ļ����� i �ΰ����ĳ���ʱ��Ϊ releaseTimes[i] - releaseTimes[i - 1] ���� 0 �ΰ����ĳ���ʱ��Ϊ releaseTimes[0] ��
 * <p>
 * ע�⣬�����ڼ䣬ͬһ���������ڲ�ͬʱ�̱���ΰ��£���ÿ�εĳ���ʱ�䶼���ܲ�ͬ��
 * <p>
 * �뷵�ذ��� ����ʱ��� �ļ�������ж�������ļ����򷵻� ����ĸ˳��������� ���Ǹ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * �����"c"
 * ���ͣ�����˳��ͳ���ʱ�����£�
 * ���� 'c' ������ʱ�� 9��ʱ�� 0 ���£�ʱ�� 9 �ɿ���
 * ���� 'b' ������ʱ�� 29 - 9 = 20���ɿ���һ������ʱ�� 9 ���£�ʱ�� 29 �ɿ���
 * ���� 'c' ������ʱ�� 49 - 29 = 20���ɿ���һ������ʱ�� 29 ���£�ʱ�� 49 �ɿ���
 * ���� 'd' ������ʱ�� 50 - 49 = 1���ɿ���һ������ʱ�� 49 ���£�ʱ�� 50 �ɿ���
 * ��������ʱ����ļ��� 'b' �� 'c'���ڶ��ΰ���ʱ��������ʱ�䶼�� 20
 * 'c' ����ĸ˳�����б� 'b' �����Դ��� 'c'
 * ʾ�� 2��
 * <p>
 * ���룺releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
 * �����"a"
 * ���ͣ�����˳��ͳ���ʱ�����£�
 * ���� 's' ������ʱ�� 12
 * ���� 'p' ������ʱ�� 23 - 12 = 11
 * ���� 'u' ������ʱ�� 36 - 23 = 13
 * ���� 'd' ������ʱ�� 46 - 36 = 10
 * ���� 'a' ������ʱ�� 62 - 46 = 16
 * ��������ʱ����ļ��� 'a' ������ʱ�� 16
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * releaseTimes.length == n
 * keysPressed.length == n
 * 2 <= n <= 1000
 * 1 <= releaseTimes[i] <= 109
 * releaseTimes[i] < releaseTimes[i+1]
 * keysPressed ����СдӢ����ĸ���
 * ͨ������6,853�ύ����13,071
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/slowest-key
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] a = keysPressed.toCharArray();
        int len = a.length;
        char result = a[0];
        int max = releaseTimes[0];
        for (int i = 1; i < len; i++) {
            int value = releaseTimes[i] - releaseTimes[i - 1];
            if (value > max) {
                max = value;
                result = a[i];
            } else if (value == max) {
                if (a[i] > result) {
                    result = a[i];
                }
            }
        }
        return result;
    }
}
