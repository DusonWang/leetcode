package code.code;

/**
 * ����һ���������� queries �������е�Ԫ��Ϊ 1 �� m ֮����������� ����������¹��������д����� queries[i]���� i=0 �� i=queries.length-1����
 * <p>
 * һ��ʼ������ P=[1,2,3,...,m]��
 * ���ڵ�ǰ�� i �������ҳ������� queries[i] ������ P �е�λ�ã��±�� 0 ��ʼ����Ȼ�����ԭλ���ƶ������� P ����ʼλ�ã����±�Ϊ 0 ������ע�⣬ queries[i] �� P �е�λ�þ��� queries[i] �Ĳ�ѯ�����
 * ������������ʽ���ش�������? queries �Ĳ�ѯ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺queries = [3,1,2,1], m = 5
 * �����[2,1,2,1]
 * ���ͣ��������� queries �������£�
 * ���� i=0: queries[i]=3, P=[1,2,3,4,5], 3 �� P �е�λ���� 2���������ǰ� 3 �ƶ��� P ����ʼλ�ã��õ� P=[3,1,2,4,5] ��
 * ���� i=1: queries[i]=1, P=[3,1,2,4,5], 1 �� P �е�λ���� 1���������ǰ� 1 �ƶ��� P ����ʼλ�ã��õ� P=[1,3,2,4,5] ��
 * ���� i=2: queries[i]=2, P=[1,3,2,4,5], 2 �� P �е�λ���� 2���������ǰ� 2 �ƶ��� P ����ʼλ�ã��õ� P=[2,1,3,4,5] ��
 * ���� i=3: queries[i]=1, P=[2,1,3,4,5], 1 �� P �е�λ���� 1���������ǰ� 1 �ƶ��� P ����ʼλ�ã��õ� P=[1,2,3,4,5] ��
 * ��ˣ����صĽ������Ϊ [2,1,2,1] ��
 * ʾ�� 2��
 * <p>
 * ���룺queries = [4,1,2,2], m = 4
 * �����[3,1,2,0]
 * ʾ�� 3��
 * <p>
 * ���룺queries = [7,5,5,8,3], m = 8
 * �����[6,5,0,7,5]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= m <= 10^3
 * 1 <= queries.length <= m
 * 1 <= queries[i] <= m
 * ͨ������4,246�ύ����5,333
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/queries-on-a-permutation-with-key
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ProcessQueries {

    public int[] processQueries(int[] queries, int m) {
        int[] pos = new int[m];
        int[] ans = new int[queries.length];
        for (int i = 0; i < m; i++) {
            pos[i] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i];
            ans[i] = pos[temp - 1];
            for (int j = 0; j < pos.length; j++) {
                if (pos[j] < pos[temp - 1]) {
                    pos[j] = pos[j] + 1;
                }
            }
            pos[temp - 1] = 0;
        }
        return ans;
    }
}
