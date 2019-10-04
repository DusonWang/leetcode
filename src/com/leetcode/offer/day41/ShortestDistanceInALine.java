package com.leetcode.offer.day41;

/**
 * @author duson
 * 表 point 保存了一些点在 x 轴上的坐标，这些坐标都是整数。
 * <p>
 *  
 * <p>
 * 写一个查询语句，找到这些点中最近两个点之间的距离。
 * <p>
 *  
 * <p>
 * | x   |
 * |-----|
 * | -1  |
 * | 0   |
 * | 2   |
 *  
 * <p>
 * 最近距离显然是 '1' ，是点 '-1' 和 '0' 之间的距离。所以输出应该如下：
 * <p>
 *  
 * <p>
 * | shortest|
 * |---------|
 * | 1       |
 *  
 * <p>
 * 注意：每个点都与其他点坐标不同，表 table 不会有重复坐标出现。
 * <p>
 *  
 * <p>
 * 进阶：如果这些点在 x 轴上从左到右都有一个编号，输出结果时需要输出最近点对的编号呢？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-in-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestDistanceInALine {

    //# Write your MySQL query statement below
    //select min(abs(a.x-b.x)) as shortest
    //from point as a
    //join point as b
    //on a.x!=b.x;

}
