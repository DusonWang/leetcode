package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author duson
 * Range 模块是跟踪数字范围的模块。你的任务是以一种有效的方式设计和实现以下接口。
 * <p>
 * addRange(int left, int right) 添加半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
 * queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true。
 * removeRange(int left, int right) 停止跟踪区间 [left, right) 中当前正在跟踪的每个实数。
 *  
 * <p>
 * 示例：
 * <p>
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true （区间 [10, 14) 中的每个数都正在被跟踪）
 * queryRange(13, 15): false （未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * queryRange(16, 17): true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 *  
 * <p>
 * 提示：
 * <p>
 * 半开区间 [left, right) 表示所有满足 left <= x < right 的实数。
 * 对 addRange, queryRange, removeRange 的所有调用中 0 < left < right < 10^9。
 * 在单个测试用例中，对 addRange 的调用总数不超过 1000 次。
 * 在单个测试用例中，对  queryRange 的调用总数不超过 5000 次。
 * 在单个测试用例中，对 removeRange 的调用总数不超过 1000 次。
 *  
 * <p>
 * 通过次数645提交次数2,002
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-module
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeModule {

    private TreeSet<Interval> ranges;

    public RangeModule() {
        ranges = new TreeSet();
    }

    public void addRange(int left, int right) {
        //找到只有大于left的后续区间，开始进行合并， 为了避免left接起来了，正好相等，就把left-1
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            //比所有tailset出来的区间小，直接完成，直接加入就好了
            //或者新加出来的区间比下一个间小了，不用再合并区间了，也可以完成了
            if (right < iv.left) {
                break;
            }

            //上个条件没有达成，那就一定有相交，那就进行合并
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            itr.remove();
        }
        ranges.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Interval iv = ranges.higher(new Interval(0, left));
        return (iv != null && iv.left <= left && right <= iv.right);
    }

    public void removeRange(int left, int right) {
        //找到只有大于left的后续区间，开始进行删除
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> todo = new ArrayList<>();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            //只有当下一个区间的left 比要删除的right都大了，这时就已经完成了
            if (right < iv.left) {
                break;
            }

            //如果遍历的区间left比要删除的小，那就要把 遍历的这个left -> 要删除left之间保留下来
            if (iv.left < left) {
                todo.add(new Interval(iv.left, left));
            }

            //如果遍历的区间right比要删除的大，那就要把 删除rithg -> 要遍历right之间保留下来
            if (right < iv.right) {
                todo.add(new Interval(right, iv.right));
            }

            //如果上面都没有走，那说明这个遍历的区间完全被删除区间包含了，可以直接把这个区间给删除了
            itr.remove();
        }
        for (Interval iv : todo) {
            ranges.add(iv);
        }
    }


    public static class Interval implements Comparable<Interval> {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Interval that) {
            if (this.right == that.right) {
                return this.left - that.left;
            }
            return this.right - that.right;
        }
    }
}
