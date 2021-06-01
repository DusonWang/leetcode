package code.code;

/**
 * ����һ���±�� 0 ��ʼ������������?candiesCount?������?candiesCount[i]?��ʾ��ӵ�еĵ�?i?���ǹ�����Ŀ��ͬʱ����һ����ά����?queries?������?queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]?��
 * <p>
 * �㰴�����¹������һ����Ϸ��
 * <p>
 * ��ӵ�?0?�쿪ʼ���ǹ���
 * ���ڳ��� ����?�� i - 1?���ǹ�֮ǰ������?���κ�һ�ŵ� i?���ǹ���
 * �ڳ��������ǹ�֮ǰ�������ÿ�� ����?�� һ��?�ǹ���
 * ���㹹��һ������������?answer?������?answer.length == queries.length ��answer[i]?Ϊ?true?�������ǣ���ÿ��� ������ dailyCapi?���ǹ���ǰ���£�������ڵ�?favoriteDayi?��Ե���?favoriteTypei?���ǹ������� answer[i]?Ϊ false?��ע�⣬ֻҪ�������� 3 �������еĵڶ���������Ϳ�����ͬһ��Բ�ͬ���͵��ǹ���
 * <p>
 * ���㷵�صõ�������?answer?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * �����[true,false,true]
 * ��ʾ��
 * 1- �ڵ� 0 ��� 2 ���ǹ�(���� 0������ 1 ��� 2 ���ǹ������� 0������ 2 ������ԳԵ����� 0 ���ǹ���
 * 2- ÿ�������� 4 ���ǹ�����ʹ�� 0 ��� 4 ���ǹ������� 0������ 1 ��� 4 ���ǹ������� 0 ������ 1������Ҳû�취�ڵ� 2 ��Ե����� 4 ���ǹ�������֮����û����ÿ��� 4 ���ǹ����������ڵ� 2 ��Ե��� 4 ���ǹ���
 * 3- �����ÿ��� 1 ���ǹ���������ڵ� 13 ��Ե����� 2 ���ǹ���
 * ʾ�� 2��
 * <p>
 * ���룺candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * �����[false,true,true,false,false]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 * ͨ������11,756�ύ����33,853
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CanEat {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + candiesCount[i];
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            long day = queries[i][1];
            long cap = queries[i][2];
            long min = day + 1;
            long max = min * cap;
            if (max > preSum[type] && min <= preSum[type + 1]) {
                ans[i] = true;
            }
        }
        return ans;
    }
}
