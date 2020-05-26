package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author duson
 * ��һ���罻Ȧ�ӵ��У���?N?���ˡ�ÿ���˶���һ����?0 ��?N-1?Ψһ�� id?��š�
 * <p>
 * ������һ����־�б�?logs������ÿ����¼������һ���Ǹ�������ʱ������Լ����������˵Ĳ�ͬ?id��logs[i] = [timestamp, id_A, id_B]��
 * <p>
 * ÿ����־��ʶ�������˳�Ϊ���ѵ�ʱ�䣬�������໥�ģ���� A �� B �Ǻ��ѣ���ô B �� A Ҳ�Ǻ��ѡ�
 * <p>
 * ��� A �� B �ĺ��ѣ����� A �� B �ĺ��ѵĺ��ѣ���ô�Ϳ�����Ϊ A Ҳ�� B ��ʶ��
 * <p>
 * ����Ȧ����������֮�䶼��ʶ������ʱ�䡣����Ҳ�������ʱ�䣬�ͷ��� -1 ��
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
 * �����20190301
 * ���ͣ�
 * ��һ�νύ������ timestamp = 20190101��0 �� 1 ��Ϊ���ѣ��罻����Ȧ���� [0,1], [2], [3], [4], [5]��
 * �ڶ��νύ������ timestamp = 20190104��3 �� 4 ��Ϊ���ѣ��罻����Ȧ���� [0,1], [2], [3,4], [5].
 * �����νύ������ timestamp = 20190107��2 �� 3 ��Ϊ���ѣ��罻����Ȧ���� [0,1], [2,3,4], [5].
 * ���Ĵνύ������ timestamp = 20190211��1 �� 5 ��Ϊ���ѣ��罻����Ȧ���� [0,1,5], [2,3,4].
 * ����νύ������ timestamp = 20190224��2 �� 4 �Ѿ��Ǻ����ˡ�
 * �����νύ������ timestamp = 20190301��0 �� 3 ��Ϊ���ѣ���Ҷ�������ʶ�ˡ�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= N <= 100
 * 1 <= logs.length <= 10^4
 * 0 <= logs[i][0] <= 10^9
 * 0 <= logs[i][1], logs[i][2] <= N - 1
 * ��֤ logs[i][0] �е�����ʱ�������ͬ
 * Logs?��һ����ĳһ��׼����
 * logs[i][1] != logs[i][2]
 * ͨ������1,277�ύ����1,947
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/the-earliest-moment-when-everyone-become-friends
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class EarliestAcq {

    static class Friends {
        int n;
        int circles;
        int[] leader;

        Friends(int N) {
            n = N;
            circles = N;
            leader = new int[N];

            for (int i = 0; i < N; i++) {
                leader[i] = i;
            }
        }

        void union(int a, int b) {
            int aLeader = find(a);
            int bLeader = find(b);

            if (aLeader != bLeader) {
                leader[aLeader] = bLeader;
                circles--;
            }
        }

        private int find(int a) {
            while (leader[a] != a) {
                a = leader[a];
            }
            return a;
        }

        public int earliestAcq(int[][] logs, int n) {
            Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
            Friends f = new Friends(n);
            for (int[] record : logs) {
                f.union(record[1], record[2]);
                if (f.circles == 1) {
                    return record[0];
                }
            }
            return -1;
        }
    }
}
