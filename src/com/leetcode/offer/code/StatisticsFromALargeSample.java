package com.leetcode.offer.code;

/**
 * @author duson
 * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。
 * <p>
 * 我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。
 * <p>
 * 我们先来回顾一下中位数的知识：
 * <p>
 * 如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素；
 * 如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
 * 示例 2：
 * <p>
 * 输入：count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,4.00000,2.18182,2.00000,1.00000]
 *  
 * <p>
 * 提示：
 * <p>
 * count.length == 256
 * 1 <= sum(count) <= 10^9
 * 计数表示的众数是唯一的
 * 答案与真实值误差在 10^-5 以内就会被视为正确答案
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/statistics-from-a-large-sample
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StatisticsFromALargeSample {

    public double[] sampleStats(int[] count) {
        int l = 0, r = 255, nl = 0, nr = 0, mn = 255, mx = -1, mid1 = 0, mid2 = 0, mode = 0;
        double avg = 0, mid;
        while (l <= r) {
            while (count[l] == 0) {
                l++;
            }
            while (count[r] == 0) {
                r--;
            }
            if (nl < nr) {
                avg += count[l] * l;
                nl += count[l];
                if (count[l] > count[mode]) {
                    mode = l;
                }
                mn = Math.min(mn, l);
                mid1 = l;
                l++;
            } else {
                avg += count[r] * r;
                nr += count[r];
                if (count[r] > count[mode]) {
                    mode = r;
                }
                mx = Math.max(mx, r);
                mid2 = r;
                r--;
            }
        }
        avg /= (nl + nr);
        if (nl < nr) {
            mid = mid2;
        } else if (nl > nr) {
            mid = mid1;
        } else {
            mid = (double) (mid1 + mid2) / 2;
        }
        return new double[]{mn, mx, avg, mid, mode};
    }

    public double[] sampleStats2(int[] count) {
        double[] result = new double[5];
        long sum = 0, csum = 0;
        int min = -1, max = -1;
        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            int cnt = count[i];
            if (cnt == 0) {
                continue;
            }
            if (min == -1) {
                min = i;
            }
            max = i;
            sum += cnt * i;
            csum += cnt;

            if (maxCount < cnt) {
                maxCount = cnt;
                result[4] = i;
            }
        }

        result[2] = sum * 1.0 / csum;

        int curCount = 0;
        int a = -1, b = -1;
        for (int i = 0; i < count.length; i++) {
            int cnt = count[i];
            curCount += cnt;
            if (a == -1 && curCount >= csum / 2) {
                a = i;
            }
            if (b == -1 && curCount >= csum / 2 + 1) {
                b = i;
            }
        }
        if ((csum & 1) == 1) {
            result[3] = b;
        } else {
            result[3] = (a + b) / 2.0;
        }

        result[0] = min;
        result[1] = max;

        return result;
    }
}
