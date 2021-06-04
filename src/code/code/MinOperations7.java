package code.code;

import java.util.Arrays;

/**
 * �� n �����ӡ�����һ������Ϊ n �Ķ������ַ��� boxes ������ boxes[i] ��ֵΪ '0' ��ʾ�� i �������� �� �ģ��� boxes[i] ��ֵΪ '1' ��ʾ�������� һ�� С��
 * <p>
 * ��һ�������У�����Խ� һ�� С���ĳ�������ƶ���һ����֮���ڵĺ����С��� i �����Ӻ͵� j ���������������� abs(i - j) == 1 ��ע�⣬����ִ�к�ĳЩ�����п��ܻ���ڲ�ֹһ��С��
 * <p>
 * ����һ������Ϊ n ������ answer ������ answer[i] �ǽ�����С���ƶ����� i ����������� ��С ��������
 * <p>
 * ÿ�� answer[i] ����Ҫ���ݺ��ӵ� ��ʼ״̬ ���м��㡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺boxes = "110"
 * �����[1,1,3]
 * ���ͣ�ÿ�����Ӷ�Ӧ����С���������£�
 * 1) �� 1 �����ӣ���һ��С��ӵ� 2 �������ƶ����� 1 �����ӣ���Ҫ 1 ��������
 * 2) �� 2 �����ӣ���һ��С��ӵ� 1 �������ƶ����� 2 �����ӣ���Ҫ 1 ��������
 * 3) �� 3 �����ӣ���һ��С��ӵ� 1 �������ƶ����� 3 �����ӣ���Ҫ 2 ����������һ��С��ӵ� 2 �������ƶ����� 3 �����ӣ���Ҫ 1 ������������ 3 ��������
 * ʾ�� 2��
 * <p>
 * ���룺boxes = "001011"
 * �����[11,8,5,4,3,4]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] Ϊ '0' �� '1'
 * ͨ������8,762�ύ����10,225
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinOperations7 {

    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        int ops = 0;
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            res[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }
        ops = 0;
        cnt = 0;
        for (int i = len - 1; i >= 0; --i) {
            res[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        MinOperations7 minOperations7 = new MinOperations7();
        System.out.println(Arrays.toString(minOperations7.minOperations("10010")));
    }
}
