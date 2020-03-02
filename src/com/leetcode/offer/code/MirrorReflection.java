package com.leetcode.offer.code;

/**
 * @author duson
 * 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。
 * <p>
 * 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
 * <p>
 * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入： p = 2, q = 1
 * 输出： 2
 * 解释： 这条光线在第一次被反射回左边的墙时就遇到了接收器 2 。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= p <= 1000
 * 0 <= q <= p
 * 通过次数1,193提交次数2,291
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/mirror-reflection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MirrorReflection {

    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1;
            q >>= 1;
        }
        return 1 - p % 2 + q % 2;
    }
}
