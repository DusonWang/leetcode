package code.code;

import java.util.Arrays;

/**
 * ����n�����У����Ϊ��1 ��n��ͬʱ����һ����СΪn-1������edges������edges[i] = [ui, vi]��ʾ����ui��vi֮����һ��˫��ߡ���Ŀ��֤�������֮��ֻ��Ψһ��һ��·�������仰˵�����г����γ���һ������
 * <p>
 * һ�������ǳ��е�һ���Ӽ������Ӽ����������֮�����ͨ���Ӽ��е��������кͱߵ��������������Ϊ��һ����������������һ������������һ�������д��ڣ�������һ�������в����ڡ�
 * <p>
 * ����d��1 ��n-1�������ҵ����м�������ǡ��Ϊ d������������Ŀ��
 * <p>
 * ���㷵��һ����СΪn-1�����飬���е�d��Ԫ�أ��±�� 1 ��ʼ���ǳ��м� ������ ǡ�õ���d��������Ŀ��
 * <p>
 * ��ע�⣬�������м���붨��Ϊ����֮����Ҫ�����ıߵ���Ŀ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 4, edges = [[1,2],[2,3],[2,4]]
 * �����[3,4,0]
 * ���ͣ�
 * ���� {1,2}, {2,3} �� {2,4} �����붼�� 1 ��
 * ���� {1,2,3}, {1,2,4}, {2,3,4} �� {1,2,3,4} �����붼Ϊ 2 ��
 * �����ڳ��м�������Ϊ 3 ��������
 * ʾ�� 2��
 * <p>
 * ���룺n = 2, edges = [[1,2]]
 * �����[1]
 * ʾ�� 3��
 * <p>
 * ���룺n = 3, edges = [[1,2],[2,3]]
 * �����[2,1]
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 15
 * edges.length == n-1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ��Ŀ��֤(ui, vi)����ʾ�ı߻�����ͬ��
 * ͨ������1,593�ύ����2,604
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-subtrees-with-max-distance-between-cities
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountSubgraphsForEachDiameter {

    /**
     * public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
     *         int[][] dist=new int[n][n]; //�洢����֮��ľ���
     *         for(int i=0; i<n; i++){
     *             Arrays.fill(dist[i], Integer.MAX_VALUE);
     *             //֮��Ҫ����Сֵ ���Գ�ʼ�����������
     *             //��ʵ��ʼ�����κ�һ�����ڵ���n�����ֶ�����
     *             dist[i][i]=0;//����������ȻΪ0
     *         }
     *         int[] dp=new int[1<<(n)];
     *         //״̬ѹ���洢 dp[j]��ʾ����j��������
     *         //j��ʾ�ɶ����ƣ���������kλΪ1��ʾ��k���ڵ����Ӽ��з�����
     *         for(int[] edge:edges){
     *             // ֱ������������֮�������ȻΪ1
     *             dist[edge[0]-1][edge[1]-1]=1;
     *             dist[edge[1]-1][edge[0]-1]=1;
     *             // ֱ��������������Թ���һ������ ���ǵ�������Ϊ1
     *             dp[(1<<(edge[0]-1)) + (1<<(edge[1]-1))]=1;
     *         }
     *         // Floyed�㷨 ��ÿ����֮�����̾���
     *         for(int k=0; k<n; k++){
     *             for(int i=0; i<n; i++){
     *                 for(int j=0; j<n; j++){
     *                     if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
     *                         dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
     *                     }
     *                 }
     *             }
     *         }
     *         // �Ѷ�j��ѭ����������
     *         // ��Ϊ��Ȼ�������A������B��һ���� jA<jB
     *         // ����Ҫ������С��jȫ���������ȥ�����ִ��j
     *         for(int j=1; j<dp.length; j++){
     *             // �������Ǵ����� j ��չ������ j+(1<<i)
     *             // ���ѽڵ�i���뵽����j��
     *             // �������j���޷�����һ�����������j��ʾ�Ľڵ㲻���໥��ͨ��
     *             // ��ôҲ��û�б�Ҫ������ ����continue
     *             if(dp[j]==0) continue;
     *             for(int i=0; i<n; i++){
     *                 // ����ڵ�i�Ѿ�������j�� ���� j+(1<<i)�Ѿ���������� ��û��Ҫ����
     *                 // Ϊʲô�����ܻ��Ѿ���������أ�
     *                 // ��Ϊ 111=101+10=11+100 ��ӵ��˳��ͬ �����ܵó�ͬ����һ������
     *                 if(((1<<i)&j)!=0 || dp[j+(1<<i)]!=0) continue;
     *                 // ��� j �������Ƿ��к� i ֱ�������ĵ�
     *                 // ����ʵ�������������������ĳ���ڵ�ģ���bfs
     *                 for(int k=0; k<n; k++){
     *                     if(((1<<k)&j)!=0 && dist[i][k]==1){
     *                         dp[j+(1<<i)]=dp[j];
     *                         break;
     *                     }
     *                 }
     *                 // ���j ������û�к� i ֱ�������ĵ�
     *                 // ��ôҲ���޷��������ڵ�i��
     *                 if(dp[j+(1<<i)]==0) continue;
     *                 // �ѽڵ�i��ӽ��� ��Ҫ������������������ dp[j+(1<<i)]
     *                 // ���µİ취�� ����ԭ������ÿһ���ڵ���½ڵ���������
     *                 // ��Ϊֻ��������Щ�¾��� ����������ͺ�
     *                 for(int kk=0; kk<n; kk++){
     *                     if(((1<<kk)&j)!=0){
     *                         dp[j+(1<<i)]=Math.max(dp[j+(1<<i)], dist[i][kk]);
     *                     }
     *                 }
     *             }
     *         }
     *         // ͳ�ƽ�� �����±��1��ʼ
     *         // ans[0]��ʵ��¼����������Ϊ1�������ж��ٿ� ͳ��ʱҪ-1
     *         int[] ans=new int[n-1];
     *         for(int j=0; j<dp.length; j++){
     *             if(dp[j]!=0) ans[dp[j]-1]++;
     *         }
     *         return ans;
     *     }
     * */
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] dp = new int[(1 << n)];
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            dist[edge[0] - 1][edge[1] - 1] = 1;
            dist[edge[1] - 1][edge[0] - 1] = 1;
            dp[(1 << (edge[0] - 1)) + (1 << (edge[1] - 1))] = 1;
        }
        // floyed
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int j = 1; j < dp.length; j++) {
            if (dp[j] == 0) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (((1 << i) & j) != 0 || dp[j + (1 << i)] != 0) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (((1 << k) & j) != 0 && dist[i][k] == 1) {
                        dp[j + (1 << i)] = dp[j];
                        break;
                    }
                }
                if (dp[j + (1 << i)] == 0) {
                    continue;
                }
                for (int kk = 0; kk < n; kk++) {
                    if (((1 << kk) & j) != 0) {
                        dp[j + (1 << i)] = Math.max(dp[j + (1 << i)], dist[i][kk]);
                    }
                }
            }
        }
        int[] ans = new int[n - 1];
        for (int j : dp) {
            if (j != 0) {
                ans[j - 1]++;
            }
        }
        return ans;
    }
}
