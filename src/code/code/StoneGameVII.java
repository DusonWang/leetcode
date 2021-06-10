package code.code;

import java.util.Arrays;

/**
 * ʯ����Ϸ�У�����˿�ͱ������������Լ��Ļغϣ�����˿�ȿ�ʼ ��
 * <p>
 * �� n ��ʯ���ų�һ�š�ÿ����ҵĻغ��У����Դ����� �Ƴ� ����ߵ�ʯͷ�����ұߵ�ʯͷ��������������ʣ��ʯͷֵ֮ �� ��ȵĵ÷֡���û��ʯͷ���Ƴ�ʱ���÷ֽϸ��߻�ʤ��
 * <p>
 * �������������������Ϸ�������ı������������䣩���������������� ��С�÷ֵĲ�ֵ ������˿��Ŀ��������޶ȵ� ����÷ֵĲ�ֵ ��
 * <p>
 * ����һ����������stones ������ stones[i] ��ʾ ����߿�ʼ �ĵ� i ��ʯͷ��ֵ���������˿�ͱ����� ���ӳ����ˮƽ ���뷵������ �÷ֵĲ�ֵ ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺stones = [5,3,1,4,2]
 * �����6
 * ���ͣ�
 * - ����˿�Ƴ� 2 ���÷� 5 + 3 + 1 + 4 = 13 ����Ϸ���������˿ = 13 ������ = 0 ��ʯ�� = [5,3,1,4] ��
 * - �����Ƴ� 5 ���÷� 3 + 1 + 4 = 8 ����Ϸ���������˿ = 13 ������ = 8 ��ʯ�� = [3,1,4] ��
 * - ����˿�Ƴ� 3 ���÷� 1 + 4 = 5 ����Ϸ���������˿ = 18 ������ = 8 ��ʯ�� = [1,4] ��
 * - �����Ƴ� 1 ���÷� 4 ����Ϸ���������˿ = 18 ������ = 12 ��ʯ�� = [4] ��
 * - ����˿�Ƴ� 4 ���÷� 0 ����Ϸ���������˿ = 18 ������ = 12 ��ʯ�� = [] ��
 * �÷ֵĲ�ֵ 18 - 12 = 6 ��
 * ʾ�� 2��
 * <p>
 * ���룺stones = [7,90,5,1,100,10,10,2]
 * �����122
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * n == stones.length
 * 2 <= n <= 1000
 * 1 <= stones[i] <= 1000
 * ͨ������3,756�ύ����7,551
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/stone-game-vii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class StoneGameVII {

    public int stoneGameVII(int[] stones) {
        int[] dp = new int[stones.length];
        int[] sums = stones.clone();
        for (int max = stones.length - 1; max > 0; max--) {
            for (int x = 0; x < max; x++) {
                int y = x + stones.length - max;
                sums[x] += stones[y];
                int gx = sums[x] - stones[x];
                int gy = sums[x] - stones[y];
                dp[x] = Math.max(gx - dp[x + 1], gy - dp[x]);
            }
        }
        return dp[0];
    }

    public int stoneGameVIIShit(int[] stones) {
        int sum = 0;
        for (int st : stones) {
            sum += st;
        }
        return diff(stones, 0, stones.length - 1, sum);
    }

    private int diff(int[] stones, int left, int right, int sum) {
        if (right == left) {
            return 0;
        }
        // �Ƴ����
        int gainLeft = sum - stones[left];
        int diffRemoveLeft = gainLeft - diff(stones, left + 1, right, gainLeft);
        // �Ƴ��ұ�
        int gainRight = sum - stones[right];
        int diffRemoveRight = gainRight - diff(stones, left, right - 1, gainRight);
        return Math.max(diffRemoveLeft, diffRemoveRight);
    }


//    public int stoneGameVII2(int[] stones) {
//        int[] dp = new int[stones.length];
//        int[] sums = stones.clone();
//        recur(stones, 0, 1, dp, sums);
//        return dp[0];
//    }
//
//    // ����
//    private void recur(int[] stones, int x, int y, int[] dp, int[] sums) {
//        sums[x] += stones[y];
//        int sum = sums[x];
//        int gx = sum - stones[x]; // �Ƴ����
//        int gy = sum - stones[y]; // �Ƴ��ұ�
//        dp[x] = Math.max(gx - dp[x + 1], gy - dp[x]); // ��̬�滮����ʽ
//        if (x == 0 && y == stones.length - 1) {
//            return; // ����ˣ�
//        }
//        // ��������
//        if (y == stones.length - 1) {
//            recur(stones, 0, y - x + 1, dp, sums); // ������һ��
//        } else {
//            recur(stones, x + 1, y + 1, dp, sums); // ����dp[x+1][y+1]
//        }
//    }

    public static void main(String[] args) {
        StoneGameVII stoneGameVII = new StoneGameVII();
        System.out.println(stoneGameVII.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(stoneGameVII.stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }
}
