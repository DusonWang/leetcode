package code.code;

import java.util.*;

/**
 * ����һ����ά���� tasks �����ڱ�ʾ n ��� 0 �� n - 1 ��ŵ��������� tasks[i] = [enqueueTimei, processingTimei] ��ζ�ŵ� i �����񽫻��� enqueueTimei ʱ����������У���Ҫ processingTimei ��ʱ�����ִ�С�
 * <p>
 * ����һ�����߳� CPU ��ͬһʱ��ֻ��ִ�� ���һ�� ���񣬸� CPU ���ᰴ��������ʽ���У�
 * <p>
 * ��� CPU ���У������������û����Ҫִ�е������� CPU ���ֿ���״̬��
 * ��� CPU ���У����������������Ҫִ�е������� CPU ����ѡ�� ִ��ʱ����� ������ʼִ�С��������������ͬ�������ִ��ʱ�䣬��ѡ���±���С������ʼִ�С�
 * һ��ĳ������ʼִ�У�CPU �� ִ������������ ǰ������ֹͣ��
 * CPU ���������һ�������������ʼִ��һ��������
 * ���� CPU ���������˳��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺tasks = [[1,2],[2,4],[3,2],[4,1]]
 * �����[0,2,3,1]
 * ���ͣ��¼��������������У�
 * - time = 1 ������ 0 ����������У���ִ�������� = {0}
 * - ͬ���� time = 1 ������״̬�� CPU ��ʼִ������ 0 ����ִ�������� = {}
 * - time = 2 ������ 1 ����������У���ִ�������� = {1}
 * - time = 3 ������ 2 ����������У���ִ�������� = {1, 2}
 * - ͬ���� time = 3 ��CPU ������� 0 ����ʼִ�ж�������ʱ��̵����� 2 ����ִ�������� = {1}
 * - time = 4 ������ 3 ����������У���ִ�������� = {1, 3}
 * - time = 5 ��CPU ������� 2 ����ʼִ�ж�������ʱ��̵����� 3 ����ִ�������� = {1}
 * - time = 6 ��CPU ������� 3 ����ʼִ������ 1 ����ִ�������� = {}
 * - time = 10 ��CPU ������� 1 ���������״̬
 * ʾ�� 2��
 * <p>
 * ���룺tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
 * �����[4,3,2,0,1]
 * ���ͣ��¼��������������У�
 * - time = 7 ����������ͬʱ����������У���ִ��������  = {0,1,2,3,4}
 * - ͬ���� time = 7 ������״̬�� CPU ��ʼִ������ 4 ����ִ�������� = {0,1,2,3}
 * - time = 9 ��CPU ������� 4 ����ʼִ������ 3 ����ִ�������� = {0,1,2}
 * - time = 13 ��CPU ������� 3 ����ʼִ������ 2 ����ִ�������� = {0,1}
 * - time = 18 ��CPU ������� 2 ����ʼִ������ 0 ����ִ�������� = {1}
 * - time = 28 ��CPU ������� 0 ����ʼִ������ 1 ����ִ�������� = {}
 * - time = 40 ��CPU ������� 1 ���������״̬
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * tasks.length == n
 * 1 <= n <= 105
 * 1 <= enqueueTimei, processingTimei <= 109
 * ͨ������5,155�ύ����14,691
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/single-threaded-cpu
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetOrder {

    static class Task {
        int id;
        int eTime;
        int pTime;

        public Task(int id, int eTime, int pTime) {
            this.id = id;
            this.eTime = eTime;
            this.pTime = pTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        taskList.sort(Comparator.comparingInt(t -> t.eTime));
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> t1.pTime != t2.pTime ? t1.pTime - t2.pTime : t1.id - t2.id);
        long now = 0;
        int i = 0;
        int idx = 0;
        int[] ans = new int[n];
        while (i < n) {
            while (i < n && taskList.get(i).eTime <= now) {
                pq.add(taskList.get(i));
                i++;
            }
            if (pq.isEmpty()) {
                now = taskList.get(i).eTime;
                while (i < n && taskList.get(i).eTime <= now) {
                    pq.add(taskList.get(i));
                    i++;
                }
            }
            Task t = pq.poll();
            ans[idx++] = t.id;
            now += t.pTime;
        }
        while (!pq.isEmpty()) {
            ans[idx++] = pq.poll().id;
        }
        return ans;
    }

}
