package com.leetcode.offer.day32;

/**
 * @author duson
 * 设计一个敲击计数器，使它可以统计在过去5分钟内被敲击次数。
 * <p>
 * 每个函数会接收一个时间戳参数（以秒为单位），你可以假设最早的时间戳从1开始，且都是按照时间顺序对系统进行调用（即时间戳是单调递增）。
 * <p>
 * 在同一时刻有可能会有多次敲击。
 * <p>
 * 示例:
 * <p>
 * HitCounter counter = new HitCounter();
 * <p>
 * // 在时刻 1 敲击一次。
 * counter.hit(1);
 * <p>
 * // 在时刻 2 敲击一次。
 * counter.hit(2);
 * <p>
 * // 在时刻 3 敲击一次。
 * counter.hit(3);
 * <p>
 * // 在时刻 4 统计过去 5 分钟内的敲击次数, 函数返回 3 。
 * counter.getHits(4);
 * <p>
 * // 在时刻 300 敲击一次。
 * counter.hit(300);
 * <p>
 * // 在时刻 300 统计过去 5 分钟内的敲击次数，函数返回 4 。
 * counter.getHits(300);
 * <p>
 * // 在时刻 301 统计过去 5 分钟内的敲击次数，函数返回 3 。
 * counter.getHits(301);
 * 进阶:
 * <p>
 * 如果每秒的敲击次数是一个很大的数字，你的计数器可以应对吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hit-counter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HitCounter {

    private final int[] ts;

    private final int[] cs;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        ts = new int[300];
        cs = new int[300];
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int i = timestamp % 300;
        if (ts[i] != timestamp) {
            ts[i] = timestamp;
            cs[i] = 1;
        } else {
            cs[i]++;
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int sum = 0;
        int ix = timestamp - 299;
        for (int m = 0; m < 300; m++) {
            if (ts[m] >= ix) {
                sum += cs[m];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        System.out.println(hitCounter.getHits(4));
        hitCounter.hit(300);
        System.out.println(hitCounter.getHits(300));
        System.out.println(hitCounter.getHits(301));

    }
}
