package code.code;

/**
 * �ڵ��ͨ·����������ͼ�����һ���㷨���ҳ������ڵ�֮���Ƿ����һ��·����
 * <p>
 * ʾ��1:
 * <p>
 * ���룺n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * �����true
 * ʾ��2:
 * <p>
 * ���룺n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * ��� true
 * ��ʾ��
 * <p>
 * �ڵ�����n��[0, 1e5]��Χ�ڡ�
 * �ڵ��Ŵ��ڵ��� 0 С�� n��
 * ͼ�п��ܴ����Ի���ƽ�бߡ�
 * ͨ������2,996�ύ����5,602
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/route-between-nodes-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindWhetherExistsPath {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] dp = new boolean[n];
        for(int[] i : graph){
            if(i[0] == start){
                dp[i[1]] = true;
            }
        }
        for(int[] i : graph){
            if(dp[i[0]]){
                dp[i[1]] = true;
            }
        }
        return dp[target];
    }
}
