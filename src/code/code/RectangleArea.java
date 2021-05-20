package code.code;

import java.util.*;

/**
 * ���Ǹ�����һ���������ģ������б�?rectangles?�� ����?rectangle[i] = [x1, y1, x2, y2]�����У�x1��y1���Ǿ���?i?���½ǵ����꣬��x2��y2���Ǹþ������Ͻǵ����ꡣ
 * <p>
 * �ҳ�ƽ�������о��ε��Ӹ��Ǻ��������� ���ڴ𰸿���̫���뷵������ 10 ^ 9 + 7 ȡģ�Ľ����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 * �����6
 * ���ͣ���ͼ��ʾ��
 * ʾ�� 2��
 * <p>
 * ���룺[[0,0,1000000000,1000000000]]
 * �����49
 * ���ͣ����� 10^18 �� (10^9 + 7) ȡģ�Ľ���� �� (10^9)^2 �� (-7)^2 = 49 ��
 * ��ʾ��
 * <p>
 * 1 <= rectangles.length <= 200
 * rectanges[i].length = 4
 * 0 <= rectangles[i][j] <= 10^9
 * ���ε��Ӹ��Ǻ����������ᳬԽ?2^63 - 1?������ζ�ſ�����һ��?64 λ�з���������������������
 * ͨ������2,014�ύ����4,621
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/rectangle-area-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class RectangleArea {

    public int rectangleArea(int[][] rectangles) {
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();
        for (int[] rec : rectangles) {
            xs.add(rec[0]);
            xs.add(rec[2]);
            ys.add(rec[1]);
            ys.add(rec[3]);
        }
        Integer[] imapx = xs.toArray(new Integer[0]);
        Arrays.sort(imapx);
        Integer[] imply = ys.toArray(new Integer[0]);
        Arrays.sort(imply);
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i < imapx.length; ++i) {
            mapX.put(imapx[i], i);
        }
        for (int i = 0; i < imply.length; ++i) {
            mapY.put(imply[i], i);
        }
        boolean[][] grid = new boolean[imapx.length][imply.length];
        for (int[] rec : rectangles) {
            for (int x = mapX.get(rec[0]); x < mapX.get(rec[2]); ++x) {
                for (int y = mapY.get(rec[1]); y < mapY.get(rec[3]); ++y) {
                    grid[x][y] = true;
                }
            }
        }
        long ans = 0;
        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid[0].length; ++y) {
                if (grid[x][y]) {
                    ans += (long) (imapx[x + 1] - imapx[x]) * (imply[y + 1] - imply[y]);
                }
            }
        }
        return (int) (ans % 1_000_000_007);
    }
}
