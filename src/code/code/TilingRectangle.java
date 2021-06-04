package code.code;

/**
 * ����һλʩ���ӵĹ������������ʦ��Ҫ��׼��Ϊһ����Ʒ����صķ��ӽ�������װ�ޡ�
 * <p>
 * ���ӵĿ�����СΪ?n?x m��Ϊ���ּ���ķ����Ҫʹ�þ������ٵ� ������ ��ש���̸ǵ��档
 * <p>
 * ���������δ�ש�Ĺ���ޣ��߳�����������
 * <p>
 * ��������ʦ����һ�£�������Ҫ�õ����ٿ鷽�δ�ש��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 2, m = 3
 * �����3
 * ���ͣ�3 ���ש�Ϳ����������ҡ�
 * 2 �� 1x1 ��ש
 * 1 �� 2x2 ��ש
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺n = 5, m = 8
 * �����5
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺n = 11, m = 13
 * �����6
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 13
 * 1 <= m?<=?13
 * ͨ������2,251�ύ����4,571
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/tiling-a-rectangle-with-the-fewest-squares
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TilingRectangle {

    private int ans = Integer.MAX_VALUE;

    public int tilingRectangle(int n, int m) {
        dfs(0, 0, new boolean[n][m], 0);
        return ans;
    }

    private void dfs(int r, int c, boolean[][] rect, int cnt) {
        int n = rect.length;
        int m = rect[0].length;
        if (cnt >= ans) {
            return;
        }

        if (r >= n) {
            ans = cnt;
            return;
        }

        if (c >= m) {
            dfs(r + 1, 0, rect, cnt);
            return;
        }

        if (rect[r][c]) {
            dfs(r, c + 1, rect, cnt);
            return;
        }

        for (int k = Math.min(n - r, m - c); k >= 1 && isAvailable(rect, r, c, k); k--) {
            cover(rect, r, c, k);
            dfs(r, c + 1, rect, cnt + 1);
            uncover(rect, r, c, k);
        }
    }

    private boolean isAvailable(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[r + i][c + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void cover(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[r + i][c + j] = true;
            }
        }
    }

    private void uncover(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[r + i][c + j] = false;
            }
        }
    }
}
