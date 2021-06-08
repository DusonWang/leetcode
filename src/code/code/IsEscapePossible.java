package code.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * ��һ�� 106 x 106 �������У�ÿ�������Ϸ��������Ϊ(x, y) ��
 * <p>
 * ���ڴ�Դ����source = [sx, sy]��ʼ��������ͼ����Ŀ�귽��target = [tx, ty] ������ blocked �Ƿ����ķ����б�����ÿ�� blocked[i] = [xi, yi] ��ʾ����Ϊ (xi, yi) �ķ����ǽ�ֹͨ�еġ�
 * <p>
 * ÿ���ƶ����������ߵ����������ĸ����������ڵķ���ֻҪ�÷��� �� �ڸ����ķ����б�blocked�ϡ�ͬʱ���������߳�����
 * <p>
 * ֻ���ڿ���ͨ��һϵ�е��ƶ���Դ����source ����Ŀ�귽��target ʱ�ŷ���true�����򣬷��� false��
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * �����false
 * ���ͣ�
 * ��Դ�����޷�����Ŀ�귽����Ϊ�����޷����������ƶ���
 * �޷��򱱻������ƶ�����Ϊ�����ֹͨ�С�
 * �޷����ϻ��������ƶ�����Ϊ�����߳�����
 * ʾ�� 2��
 * <p>
 * ���룺blocked = [], source = [0,0], target = [999999,999999]
 * �����true
 * ���ͣ�
 * ��Ϊû�з��񱻷���������һ�����Ե���Ŀ�귽��
 *
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= xi, yi < 106
 * source.length == target.length == 2
 * 0 <= sx, sy, tx, ty < 106
 * source != target
 * ��Ŀ���ݱ�֤ source �� target ���ڷ����б���
 * ͨ������2,932�ύ����9,862
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/escape-a-large-maze
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsEscapePossible {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        return bfs(blocked, source, target)
                && bfs(blocked, target, source);
    }

    private boolean bfs(int[][] blocked, int[] source, int[] target) {
        Set<Integer> visited = new HashSet<>();
        for (int[] block : blocked) {
            visited.add(1000000 * block[0] + block[1]);
        }
        visited.add(1000000 * source[0] + source[1]);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size >= blocked.length) {
                return true;
            }
            while (--size >= 0) {
                int[] p = queue.poll();
                for (int[] d : DIRECTIONS) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];
                    if (x < 0 || x >= 1000000 || y < 0 || y >= 1000000) {
                        continue;
                    }
                    if (x == target[0] && y == target[1]) {
                        return true;
                    }
                    if (visited.add(1000000 * x + y)) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return false;
    }
}
