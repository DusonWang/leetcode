package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���ַ��� s ���뷵�� s ����� �������ַ��� �ĳ��ȡ�
 * <p>
 * ���������ַ�����������������������������
 * <p>
 * ���ַ����� s ��һ���ǿ����ַ���
 * ��������������ַ������󣬸��ַ������Ա��һ�������ַ���
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "3242415"
 * �����5
 * ���ͣ�"24241" ����ĳ������ַ������������е��ַ��󣬿��Եõ����� "24142"
 * ʾ�� 2��
 * <p>
 * ���룺s = "12345678"
 * �����1
 * ʾ�� 3��
 * <p>
 * ���룺s = "213123"
 * �����6
 * ���ͣ�"213123" ����ĳ������ַ������������е��ַ��󣬿��Եõ����� "231132"
 * ʾ�� 4��
 * <p>
 * ���룺s = "00"
 * �����2
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 10^5
 * s �����������
 * ͨ������2,132�ύ����5,801
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-longest-awesome-substring
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestAwesome {

    public int longestAwesome(String s) {
        Map<Integer, Integer> bitXor = new HashMap<>();
        bitXor.put(0, -1);
        int currXor = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            currXor ^= (1 << (s.charAt(i) - '0'));
            Integer value = bitXor.get(currXor);
            if (value != null) {
                maxLength = Math.max(maxLength, i - value);
            }
            for (int j = 0; j <= 9; j++) {
                int oddLength = currXor ^ (1 << j);
                Integer tmp = bitXor.get(oddLength);
                if (tmp != null) {
                    maxLength = Math.max(maxLength, i - tmp);
                }
            }
            bitXor.putIfAbsent(currXor, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestAwesome longestAwesome = new LongestAwesome();
        System.out.println(longestAwesome.longestAwesome("3242415"));
        System.out.println(longestAwesome.longestAwesome("12345678"));
        System.out.println(longestAwesome.longestAwesome("213123"));
        System.out.println(longestAwesome.longestAwesome("00"));
    }
}
