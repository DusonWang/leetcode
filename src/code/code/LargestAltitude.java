package code.code;

/**
 * ��һ�����г��ִ������һ����·���У�����·���ܹ���?n + 1?����ͬ���εĵ���ɡ����г��ִӺ���Ϊ 0?�ĵ�?0?��ʼ���С�
 * <p>
 * ����һ������Ϊ n?����������?gain?������ gain[i]?�ǵ� i?�͵� i + 1?�� �����θ߶Ȳ0 <= i < n�������㷵�� ��ߵ�ĺ��� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺gain = [-5,1,5,0,-7]
 * �����1
 * ���ͣ����θ߶�����Ϊ [0,-5,-4,1,1,-6] ����ߺ���Ϊ 1 ��
 * ʾ�� 2��
 * <p>
 * ���룺gain = [-4,-3,-2,-1,4,3,2]
 * �����0
 * ���ͣ����θ߶�����Ϊ [0,-4,-7,-9,-10,-6,-3,-1] ����ߺ���Ϊ 0 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 * ͨ������8,064�ύ����10,067
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-highest-altitude
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LargestAltitude {

    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int j : gain) {
            sum += j;
            max = Math.max(max, sum);
        }
        return Math.max(max, 0);
    }
}
