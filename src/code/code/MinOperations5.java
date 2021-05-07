package code.code;

import java.util.Stack;

/**
 * ÿ���û�ִ�б���ļ��в���ʱ��LeetCode �ļ�ϵͳ���ᱣ��һ����־��¼��
 * <p>
 * ��������Ա��������˵����
 * <p>
 * "../" ���ƶ�����ǰ�ļ��еĸ��ļ��С�����Ѿ������ļ����£��� ����ͣ���ڵ�ǰ�ļ��� ��
 * "./" ������ͣ���ڵ�ǰ�ļ��С�
 * "x/" ���ƶ�����Ϊ x �����ļ����С���Ŀ���� ��֤���Ǵ����ļ��� x ��
 * ����һ���ַ����б� logs ������ logs[i] ���û��� ith ��ִ�еĲ�����
 * <p>
 * �ļ�ϵͳ����ʱλ�����ļ��У�Ȼ��ִ�� logs �еĲ�����
 * <p>
 * ִ�������б���ļ��в����������ҳ� �������ļ����������С���� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺logs = ["d1/","d2/","../","d21/","./"]
 * �����2
 * ���ͣ�ִ�� "../" ��������ļ��� 2 �Σ����ɻص����ļ���
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺logs = ["d1/","d2/","./","d3/","../","d31/"]
 * �����3
 * ʾ�� 3��
 * <p>
 * ���룺logs = ["d1/","../","../","../"]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= logs.length <= 103
 * 2 <= logs[i].length <= 10
 * logs[i] ����СдӢ����ĸ�����֣�'.' �� '/'
 * logs[i] ��������������ĸ�ʽ
 * �ļ���������СдӢ����ĸ���������
 * ͨ������9,248�ύ����13,793
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/crawler-log-folder
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinOperations5 {

    public int minOperations(String[] logs) {
        int i = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                if (i != 0) {
                    i--;
                }
            } else if (!"./".equals(log)) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        MinOperations5 minOperations5 = new MinOperations5();
        System.out.println(minOperations5.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(minOperations5.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(minOperations5.minOperations(new String[]{"d1/", "../", "../", "../"}));

    }
}
