package code.code;

import java.util.Arrays;

/**
 * Alice ��Bob ������һ����Ϸ��Alice ���֡�
 * <p>
 * һ��ʯ�����ܹ���n��ʯ�ӣ��ֵ�ĳ�����ʱ�������� �Ƴ�һ��ʯ�Ӳ��õ����ʯ�ӵļ�ֵ��Alice �� Bob ��ʯ�Ӽ�ֵ�� ��һ���ĵ����б�׼��˫����֪���Է������б�׼��
 * <p>
 * ������������Ϊ n����������aliceValues ��bobValues��aliceValues[i] ��bobValues[i]�ֱ��ʾ Alice �� Bob ��Ϊ��i��ʯ�ӵļ�ֵ��
 * <p>
 * ����ʯ�Ӷ���ȡ��󣬵÷ֽϸߵ���Ϊʤ�ߡ����������ҵ÷���ͬ����ôΪƽ�֡���λ��Ҷ������ ���Ų��Խ�����Ϸ��
 * <p>
 * �����ƶ���Ϸ�Ľ���������µķ�ʽ��ʾ��
 * <p>
 * ��� Alice Ӯ������1��
 * ��� Bob Ӯ������-1��
 * �����Ϸƽ�֣�����0��
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺aliceValues = [1,3], bobValues = [2,1]
 * �����1
 * ���ͣ�
 * ��� Alice ��ʯ�� 1 ���±�� 0��ʼ������ô Alice ���Եõ� 3 �֡�
 * Bob ֻ��ѡ��ʯ�� 0 ���õ� 2 �֡�
 * Alice ��ʤ��
 * ʾ�� 2��
 * <p>
 * ���룺aliceValues = [1,2], bobValues = [3,1]
 * �����0
 * ���ͣ�
 * Alice ��ʯ�� 0 �� Bob ��ʯ�� 1 �����ǵ÷ֶ�Ϊ 1 �֡�
 * ��ƽ��
 * ʾ�� 3��
 * <p>
 * ���룺aliceValues = [2,4,3], bobValues = [1,6,7]
 * �����-1
 * ���ͣ�
 * ���� Alice ��ô������Bob �����Եõ��� Alice ���ߵĵ÷֡�
 * �ȷ�˵��Alice ��ʯ�� 1 ��Bob ��ʯ�� 2 �� Alice ��ʯ�� 0 ��Alice ��õ� 6 �ֶ� Bob �÷�Ϊ 7 �֡�
 * Bob ���ʤ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * n == aliceValues.length == bobValues.length
 * 1 <= n <= 105
 * 1 <= aliceValues[i], bobValues[i] <= 100
 * ͨ������2,222�ύ����4,787
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/stone-game-vi
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class StoneGameVI {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] sums = new int[n][3];
        for (int i = 0; i < n; i++) {
            sums[i] = new int[]{aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]};
        }
        Arrays.sort(sums, (a, b) -> b[0] - a[0]);
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a += sums[i][1];
            } else {
                b += sums[i][2];
            }
        }
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        StoneGameVI stoneGameVI = new StoneGameVI();
        System.out.println(stoneGameVI.stoneGameVI(new int[]{1, 3}, new int[]{2, 1}));
        System.out.println(stoneGameVI.stoneGameVI(new int[]{1, 2}, new int[]{3, 1}));
        System.out.println(stoneGameVI.stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7}));


    }

}
