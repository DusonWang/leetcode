package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * <p>
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * <p>
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 * 通过次数1,122提交次数3,466
 * 在真实的面试中遇到过这道题？
 */
public class ExamRoom {

    private List<Integer> list;
    private int N;

    public ExamRoom(int N) {
        list = new ArrayList<>();
        this.N = N;
    }

    public int seat() {
        if(list.size() == 0){
            list.add(0);
            return 0;
        }
        int result = 0, maxLen = list.get(0);
        for(int i = 0; i < list.size() - 1; i++){
            int a = list.get(i);
            int b = list.get(i + 1);
            if((b - a) / 2 > maxLen){
                result = (a + b) / 2;
                maxLen = (b - a) / 2;
            }
        }
        if(N - 1 - list.get(list.size() - 1) > maxLen){
            result = N - 1;
        }

        int index = lowerBound(list, result);
        list.add(index, result);
        return result;
    }

    private int lowerBound(List<Integer> list, int result){
        int min = 0, max = list.size();
        while(min < max) {
            int mid = (max + min) / 2;
            if(result <= list.get(mid)) {
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }

    public void leave(int p) {
        list.remove(new Integer(p));
    }

}
