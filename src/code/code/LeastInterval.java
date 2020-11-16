package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 1：
 * <p>
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 * <p>
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (len < 1 || n < 0) {
            return 0;
        }
        int[] nums = new int[26];
        int i = 0;
        while (i < len) {
            nums[tasks[i++] - 65]++;
        }
        Arrays.sort(nums);

        int res = (nums[25] - 1) * (n + 1);
        i = 25;
        while (i >= 0 && nums[i] == nums[25]) {
            res++;
            i--;
        }
        return Math.max(res, len);
    }

    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        System.out.println(leastInterval.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B'}, 2));
    }
}
