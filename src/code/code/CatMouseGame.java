package code.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ������ҷֱ����è��Cat��������Mouse��������ͼ�Ͻ�����Ϸ�����������ж���
 * <p>
 * ��ͼ���������������graph[a]�����н�� b ���б�ʹ�� ab ��ͼ��һ���ߡ�
 * <p>
 * ����ӽ�� 1 ��ʼ�����ȳ�����è�ӽ�� 2 ��ʼ�����������ڽ�� 0 ����һ������
 * <p>
 * ��ÿ����ҵĻغ��У����Ǳ�����������������λ�����Ǻϵ�ͼ��һ�����ƶ������磬�������λ�ڽ�� 1����ô��ֻ���ƶ���graph[1]�еģ��κΣ����ȥ��
 * <p>
 * ���⣬è�޷��ƶ���������� 0���
 * <p>
 * Ȼ����Ϸ�ڳ���������������֮һʱ������
 * <p>
 * ���è������ռ����ͬ�Ľ�㣬è��ʤ��
 * ���������붴������ʤ��
 * ���ĳһλ���ظ����֣���������ǵ�λ�ú��ƶ�˳������һ���غ���ͬ������Ϸƽ�֡�
 * ����graph��������������Ҷ������״̬������Ϸ����������ʤ���򷵻�1�����è��ʤ���򷵻� 2�����ƽ�֣��򷵻� 0��
 * <p>
 *
 * <p>
 * ʾ����
 * <p>
 * ���룺[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * �����0
 * ���ͣ�
 * 4---3---1
 * |   |
 * 2---5
 * \ /
 * 0
 *
 * <p>
 * ��ʾ��
 * <p>
 * 3 <= graph.length <= 200
 * ��֤ graph[1]�ǿա�
 * ��֤graph[2]��������Ԫ�ء�
 * ͨ������1,498�ύ����3,894
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/cat-and-mouse
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CatMouseGame {

    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        // status[i][j][k] ��ʾ������iλ�ã� è��jλ�ã�k��ʾ����˭�ƶ�(0��ʾ���ƶ��� 1��ʾè�ƶ�)
        // ���Ϊ0��1��2(1��ʾ��ʤ��2��ʾèʤ��0��ʾƽ��)
        int[][][] status = new int[n][n][2];
        Queue<int[]> queue = new LinkedList<>();
        // status[i][i][k] ��ʾ��èͬλ�ã�èʤ
        // status[0][i][k] ��ʾ���������ʤ
        for (int i = 0; i < n; i++) {
            status[i][i][0] = 2;
            status[i][i][1] = 2;
            status[0][i][0] = 1;
            status[0][i][1] = 1;
            queue.offer(new int[]{i, i, 0});
            queue.offer(new int[]{i, i, 1});
            queue.offer(new int[]{0, i, 0});
            queue.offer(new int[]{0, i, 1});
        }
        // BFS ����
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int m = node[0];
            int c = node[1];
            int k = node[2];
            if (k == 0) { // ���ж�
                if (status[m][c][0] == 2) {
                    // èʤ�� ��һ��
                    for (int pre : graph[c]) {
                        if (pre != 0 && status[m][pre][1] == 0) {
                            status[m][pre][1] = 2;
                            queue.add(new int[]{m, pre, 1});
                        }
                    }
                } else { // ��ʤ��
                    // è��һ��
                    for (int pre : graph[c]) {
                        // èʤ�� ����ƽ��
                        if (pre == 0 || status[m][pre][1] != 0) {
                            continue;
                        }
                        boolean mouseWin = true;
                        for (int next : graph[pre]) {
                            if (next != 0 && status[m][next][0] != 1) {
                                mouseWin = false;
                                break;
                            }
                        }
                        if (mouseWin) {
                            status[m][pre][1] = 1;
                            queue.add(new int[]{m, pre, 1});
                        }
                    }
                }

            } else { // è�ж�
                if (status[m][c][1] == 1) { // ��ʤ��
                    for (int pre : graph[m]) {
                        if (status[pre][c][0] == 0) {
                            status[pre][c][0] = 1;
                            queue.add(new int[]{pre, c, 0});
                        }
                    }
                } else { // èʤ������ô���ҽ����ϴε���������ж���Ϊèʤ�����������
                    for (int pre : graph[m]) {
                        if (status[pre][c][0] == 0) {
                            boolean catWin = true;
                            for (int next : graph[pre]) {
                                if (status[next][c][1] != 2) {
                                    catWin = false;
                                    break;
                                }
                            }
                            if (catWin) {
                                status[pre][c][0] = 2;
                                queue.add(new int[]{pre, c, 0});
                            }
                        }
                    }
                }
            }
        }
        return status[1][2][0];
    }
}
