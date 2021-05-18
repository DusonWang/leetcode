package code.code;

/**
 * ���һ��ʮ�������ֲ����κ�ǰ���㣬��ÿһλ�ϵ����ֲ��� 0 ���� 1 ����ô�����־���һ�� ʮ-�������� �����磬101 �� 1100 ���� ʮ-������������ 112 �� 3001 ���ǡ�
 * <p>
 * ����һ����ʾʮ�����������ַ��� n �����غ�Ϊ n �� ʮ-�������� ��������Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = "32"
 * �����3
 * ���ͣ�10 + 11 + 11 = 32
 * ʾ�� 2��
 * <p>
 * ���룺n = "82734"
 * �����8
 * ʾ�� 3��
 * <p>
 * ���룺n = "27346209830709182346"
 * �����9
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n.length <= 105
 * n �����������
 * n �����κ�ǰ���㲢���Ǳ�ʾ������
 * ͨ������11,906�ύ����13,744
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinPartitions {

    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) - '0' > max) {
                max = n.charAt(i) - '0';
            }
        }
        return max;
    }
}