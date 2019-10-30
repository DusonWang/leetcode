package com.leetcode.offer.day51;

import java.util.*;

/**
 * @author duson
 * 给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。
 * <p>
 * 对它进行优化使其尽量少调用系统方法 Math.random() 。
 * <p>
 * 提示:
 * <p>
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N) 不包含 N，详细参见 interval notation 。
 * 示例 1:
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * 输出: [null,0,0,0]
 * 示例 2:
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * 输出: [null,1,1,1]
 * 示例 3:
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 * 示例 4:
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * 输出: [null,1,3,1]
 * 输入语法说明：
 * <p>
 * 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，N 和黑名单 B。pick 没有参数，输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-blacklist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(N, blacklist);
     * int param_1 = obj.pick();
     */
    private int m;

    private Random r;

    private Map<Integer, Integer> map;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();
        m = n - blacklist.length;
        Set<Integer> set = new HashSet<>();
        //[1,7) black [4,6] m=5
        for (int i = m; i < n; i++) {
            set.add(i);
        }
        //set 5,6
        for (int b : blacklist) {
            set.remove(b);
        }
        //set 5
        Iterator<Integer> wi = set.iterator();
        for (int x : blacklist) {
            if (x < m) {
                map.put(x, wi.next());
            }
        }
    }

    public int pick() {
        int k = r.nextInt(m);
        return map.getOrDefault(k, k);
    }
}
