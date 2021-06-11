package code.code;

/**
 * ��ָ���뷨���Ƽ����� XY ƽ���ϵĲ�������ͼ��ʾ������ÿ����дӢ����ĸ��λ��ĳ�����괦��������ĸAλ������(0,0)����ĸBλ������(0,1)����ĸPλ������(2,3)����ĸ Zλ������(4,1)��
 * <p>
 * ����һ���������ַ���word��������㲢�����ڽ�ʹ��������ָ������£�������ַ�����Ҫ����С�ƶ��ܾ��롣����(x1,y1) �� (x2,y2) ֮��ľ�����|x1 - x2| + |y1 - y2|��
 * <p>
 * ע�⣬������ָ����ʼλ��������۵ģ��������ƶ��ܾ��롣���������ָ����ʼλ��Ҳ���ش�����ĸ����ǰ������ĸ��ʼ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺word = "CAKE"
 * �����3
 * ���ͣ�
 * ʹ��������ָ���� "CAKE" ����ѷ���֮һ�ǣ�
 * ��ָ 1 ����ĸ 'C' �� -> �ƶ����� = 0
 * ��ָ 1 ����ĸ 'A' �� -> �ƶ����� = ����ĸ 'C' ����ĸ 'A' �ľ��� = 2
 * ��ָ 2 ����ĸ 'K' �� -> �ƶ����� = 0
 * ��ָ 2 ����ĸ 'E' �� -> �ƶ����� = ����ĸ 'K' ����ĸ 'E' �ľ���  = 1
 * �ܾ��� = 3
 * ʾ�� 2��
 * <p>
 * ���룺word = "HAPPY"
 * �����6
 * ���ͣ�
 * ʹ��������ָ���� "HAPPY" ����ѷ���֮һ�ǣ�
 * ��ָ 1 ����ĸ 'H' �� -> �ƶ����� = 0
 * ��ָ 1 ����ĸ 'A' �� -> �ƶ����� = ����ĸ 'H' ����ĸ 'A' �ľ��� = 2
 * ��ָ 2 ����ĸ 'P' �� -> �ƶ����� = 0
 * ��ָ 2 ����ĸ 'P' �� -> �ƶ����� = ����ĸ 'P' ����ĸ 'P' �ľ��� = 0
 * ��ָ 1 ����ĸ 'Y' �� -> �ƶ����� = ����ĸ 'A' ����ĸ 'Y' �ľ��� = 4
 * �ܾ��� = 6
 * ʾ�� 3��
 * <p>
 * ���룺word = "NEW"
 * �����3
 * ʾ�� 4��
 * <p>
 * ���룺word = "YEAR"
 * �����7
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= word.length <= 300
 * ÿ�� word[i]����һ����дӢ����ĸ��
 * ͨ������2,308�ύ����3,952
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-distance-to-type-a-word-using-two-fingers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinimumDistance {

    public int minimumDistance(String word) {
        int[] dp = new int[26];
        int res = 0;
        int save = 0;
        int n = word.length();
        for (int i = 0; i < n - 1; ++i) {
            int b = word.charAt(i) - 'A';
            int c = word.charAt(i + 1) - 'A';
            for (int a = 0; a < 26; ++a) {
                dp[b] = Math.max(dp[b], dp[a] + dis(b, c) - dis(a, c));
            }
            save = Math.max(save, dp[b]);
            res += dis(b, c);
        }
        return res - save;

    }

    private int dis(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }

    int[][][] dp = new int[27][27][301];

    public int minimumDistance2(String word) {
        return dfs(word, 0, 0, 0);
    }

    private int dfs(String word, int start, int l, int r) {
        if (start >= word.length()) {
            return 0;
        }
        if (dp[l][r][start] != 0) {
            return dp[l][r][start];
        }
        int idx = word.charAt(start) - 'A' + 1;
        dp[l][r][start] = Math.min(dist(l, idx) + dfs(word, start + 1, idx, r), dist(r, idx) + dfs(word, start + 1, l, idx));
        return dp[l][r][start];
    }

    private int dist(int from, int to) {
        if (from == 0) {
            return 0;
        }
        return Math.abs((from - 1) / 6 - (to - 1) / 6) + Math.abs((from - 1) % 6 - (to - 1) % 6);
    }


    public static void main(String[] args) {
        MinimumDistance minimumDistance = new MinimumDistance();
        System.out.println(minimumDistance.minimumDistance("CAKE"));
    }
}
