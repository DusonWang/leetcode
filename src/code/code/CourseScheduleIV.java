package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ���ܹ���Ҫ�� n?�ſΣ��γ̱������Ϊ 0?�� n-1?��
 * <p>
 * �еĿλ���ֱ�ӵ����޿γ̣�����������Ͽγ�?0 ����������Ͽγ� 1 ����ô���� [1,0]?���Ե���ʽ�������޿γ����ԡ�
 * <p>
 * ����γ����� n?��һ��ֱ�����޿γ������б�?prerequisite ��һ����ѯ���б�?queries?��
 * <p>
 * ����ÿ����ѯ�� queries[i]?�����ж�?queries[i][0]?�Ƿ���?queries[i][1]?�����޿γ̡�
 * <p>
 * �뷵��һ������ֵ�б��б���ÿ��Ԫ�����ηֱ��Ӧ queries?ÿ����ѯ�Ե��жϽ����
 * <p>
 * ע�⣺����γ�?a?�ǿγ�?b?�����޿γ��ҿγ�?b?�ǿγ�?c?�����޿γ̣���ô�γ�?a?Ҳ�ǿγ�?c?�����޿γ̡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * �����[false,true]
 * ���ͣ��γ� 0 ���ǿγ� 1 �����޿γ̣����γ� 1 �ǿγ� 0 �����޿γ̡�
 * ʾ�� 2��
 * <p>
 * ���룺n = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * �����[false,false]
 * ���ͣ�û�����޿γ̶ԣ�����ÿ�ſγ�֮���Ƕ����ġ�
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * �����[true,true]
 * ʾ�� 4��
 * <p>
 * ���룺n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
 * �����[false,true]
 * ʾ�� 5��
 * <p>
 * ���룺n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
 * �����[true,false,true,false]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 100
 * 0 <= prerequisite.length <= (n * (n - 1) / 2)
 * 0 <= prerequisite[i][0], prerequisite[i][1] < n
 * prerequisite[i][0] != prerequisite[i][1]
 * ���޿γ�ͼ��û�л���
 * ���޿γ�ͼ��û���ظ��ıߡ�
 * 1 <= queries.length <= 10^4
 * queries[i][0] != queries[i][1]
 * ͨ������1,422�ύ����4,036
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/course-schedule-iv
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        for (int[] p : prerequisites) {
            connected[p[0]][p[1]] = true;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    connected[i][j] = connected[i][j] || connected[i][k] && connected[k][j];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(connected[q[0]][q[1]]);
        }
        return ans;
    }
}
