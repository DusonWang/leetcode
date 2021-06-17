package code.code;

import java.util.*;

/**
 * 给你一个二维数组 tasks ，用于表示 n 项从 0 到 n - 1 编号的任务。其中 tasks[i] = [enqueueTimei, processingTimei] 意味着第 i 项任务将会于 enqueueTimei 时进入任务队列，需要 processingTimei 的时长完成执行。
 * <p>
 * 现有一个单线程 CPU ，同一时间只能执行 最多一项 任务，该 CPU 将会按照下述方式运行：
 * <p>
 * 如果 CPU 空闲，且任务队列中没有需要执行的任务，则 CPU 保持空闲状态。
 * 如果 CPU 空闲，但任务队列中有需要执行的任务，则 CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
 * 一旦某项任务开始执行，CPU 在 执行完整个任务 前都不会停止。
 * CPU 可以在完成一项任务后，立即开始执行一项新任务。
 * 返回 CPU 处理任务的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = [[1,2],[2,4],[3,2],[4,1]]
 * 输出：[0,2,3,1]
 * 解释：事件按下述流程运行：
 * - time = 1 ，任务 0 进入任务队列，可执行任务项 = {0}
 * - 同样在 time = 1 ，空闲状态的 CPU 开始执行任务 0 ，可执行任务项 = {}
 * - time = 2 ，任务 1 进入任务队列，可执行任务项 = {1}
 * - time = 3 ，任务 2 进入任务队列，可执行任务项 = {1, 2}
 * - 同样在 time = 3 ，CPU 完成任务 0 并开始执行队列中用时最短的任务 2 ，可执行任务项 = {1}
 * - time = 4 ，任务 3 进入任务队列，可执行任务项 = {1, 3}
 * - time = 5 ，CPU 完成任务 2 并开始执行队列中用时最短的任务 3 ，可执行任务项 = {1}
 * - time = 6 ，CPU 完成任务 3 并开始执行任务 1 ，可执行任务项 = {}
 * - time = 10 ，CPU 完成任务 1 并进入空闲状态
 * 示例 2：
 * <p>
 * 输入：tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
 * 输出：[4,3,2,0,1]
 * 解释：事件按下述流程运行：
 * - time = 7 ，所有任务同时进入任务队列，可执行任务项  = {0,1,2,3,4}
 * - 同样在 time = 7 ，空闲状态的 CPU 开始执行任务 4 ，可执行任务项 = {0,1,2,3}
 * - time = 9 ，CPU 完成任务 4 并开始执行任务 3 ，可执行任务项 = {0,1,2}
 * - time = 13 ，CPU 完成任务 3 并开始执行任务 2 ，可执行任务项 = {0,1}
 * - time = 18 ，CPU 完成任务 2 并开始执行任务 0 ，可执行任务项 = {1}
 * - time = 28 ，CPU 完成任务 0 并开始执行任务 1 ，可执行任务项 = {}
 * - time = 40 ，CPU 完成任务 1 并进入空闲状态
 * <p>
 * <p>
 * 提示：
 * <p>
 * tasks.length == n
 * 1 <= n <= 105
 * 1 <= enqueueTimei, processingTimei <= 109
 * 通过次数5,155提交次数14,691
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-threaded-cpu
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
