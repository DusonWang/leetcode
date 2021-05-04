package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ n ��һ���������� rounds ����һ��Բ�������� n ��������ɣ�������Ŵ� 1 �� n ���ֽ������������Ͼٰ�һ�������ɱ�������������ȫ���� m ���׶���ɡ����У��� i ���׶ν�������� rounds[i - 1] ��ʼ�������� rounds[i] ������������˵���� 1 �׶δ�?rounds[0]?��ʼ����?rounds[1]?������
 * <p>
 * ������������ʽ���ؾ������������Ǽ������������������ ���� ���С�
 * <p>
 * ע�⣬�������������������ʱ���γ�һ��Բ����μ���һ��ʾ������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 4, rounds = [1,3,1,2]
 * �����[1,2]
 * ���ͣ����������ɱ��������� 1 ��ʼ���������������Ĵ���������ʾ��
 * 1 --> 2 --> 3���׶� 1 ������--> 4 --> 1���׶� 2 ������--> 2���׶� 3 �����������������ɽ�����
 * ���У����� 1 �� 2 �����������Σ������Ǿ������������������������� 3 �� 4 ��ֻ������һ�Ρ�
 * ʾ�� 2��
 * <p>
 * ���룺n = 2, rounds = [2,1,2,1,2,1,2,1,2]
 * �����[2]
 * ʾ�� 3��
 * <p>
 * ���룺n = 7, rounds = [1,3,5,7]
 * �����[1,2,3,4,5,6,7]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 100
 * 1 <= m <= 100
 * rounds.length == m + 1
 * 1 <= rounds[i] <= n
 * rounds[i] != rounds[i + 1] ������ 0 <= i < m
 * ͨ������7,758�ύ����13,576
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/most-visited-sector-in-a-circular-track
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MostVisited {

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ret = new ArrayList<>();
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                ret.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                ret.add(i);
            }
            for (int i = start; i <= n; i++) {
                ret.add(i);
            }
        }
        return ret;
    }
}
