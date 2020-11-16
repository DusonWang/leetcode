package code.code;

import java.util.List;

/**
 * @author duson
 * �ܹ��� n?���˺� 40 �ֲ�ͬ��ñ�ӣ�ñ�ӱ�Ŵ� 1 �� 40 ��
 * <p>
 * ����һ�������б���б�?hats?������?hats[i]?�ǵ� i?��������ϲ��ñ�ӵ��б�
 * <p>
 * �����ÿ���˰���һ����ϲ����ñ�ӣ�ȷ��ÿ���˴���ñ�Ӹ����˶���һ���������ط�������
 * <p>
 * ���ڴ𰸿��ܴܺ��뷵������?10^9 + 7?ȡ���Ľ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺hats = [[3,4],[4,5],[5]]
 * �����1
 * ���ͣ�����������ֻ��һ�ַ���ѡ��ñ�ӡ�
 * ��һ����ѡ��ñ�� 3���ڶ�����ѡ��ñ�� 4�����һ����ѡ��ñ�� 5��
 * ʾ�� 2��
 * <p>
 * ���룺hats = [[3,5,1],[3,5]]
 * �����4
 * ���ͣ��ܹ��� 4 �ְ���ñ�ӵķ�����
 * (3,5)��(5,3)��(1,3) �� (1,5)
 * ʾ�� 3��
 * <p>
 * ���룺hats = [[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
 * �����24
 * ���ͣ�ÿ���˶����Դӱ��Ϊ 1 �� 4 ��ñ����ѡ��
 * (1,2,3,4) 4 ��ñ�ӵ����з�����Ϊ 24 ��
 * ʾ�� 4��
 * <p>
 * ���룺hats = [[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]
 * �����111
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == hats.length
 * 1 <= n <= 10
 * 1 <= hats[i].length <= 40
 * 1 <= hats[i][j] <= 40
 * hats[i]?����һ�����ֻ�����ͬ�������б�
 * ͨ������1,068�ύ����2,744
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-ways-to-wear-different-hats-to-each-other
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumberWays {

    public int numberWays(List<List<Integer>> hats) {
        int[] peoples = new int[40];
        int p = 1;
        for (List<Integer> hat : hats) {
            for (int h : hat) {
                peoples[h - 1] |= p;
            }
            p <<= 1;
        }
        int[] dp = new int[p];
        dp[0] = 1;
        for (int people : peoples) {
            if (people == 0) {
                continue;
            }
            for (int status = p; status > 0; status--) {
                for (int mask = people & status, pp; mask > 0; mask ^= pp) {
                    pp = (-mask) & mask;
                    dp[status] = (dp[status ^ pp] + dp[status]) % 1000000007;
                }
            }
        }
        return dp[p - 1];
    }
}
