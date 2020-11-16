package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 * <p>
 * 示例:
 * <p>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/moving-average-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingAverage {

    private List<Integer> list;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.list = new ArrayList<>();
        this.size = size;
    }

    public double next(int val) {
        if (list.size() == size) {
            list.remove(0);
        }
        list.add(val);
        int sum = 0;
        for (int tmp : list) {
            sum += tmp;
        }
        int size = list.size();
        if (size == 0) {
            return 0d;
        }
        return (double) sum / size;
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
