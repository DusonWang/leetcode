package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 请你实现一个类?UndergroundSystem?，它支持以下 3 种方法：
 * <p>
 * 1.?checkIn(int id, string stationName, int t)
 * <p>
 * 编号为?id?的乘客在 t?时刻进入地铁站?stationName?。
 * 一个乘客在同一时间只能在一个地铁站进入或者离开。
 * 2.?checkOut(int id, string stationName, int t)
 * <p>
 * 编号为?id?的乘客在 t?时刻离开地铁站 stationName?。
 * 3.?getAverageTime(string startStation, string endStation)?
 * <p>
 * 返回从地铁站?startStation?到地铁站?endStation?的平均花费时间。
 * 平均时间计算的行程包括当前为止所有从?startStation?直接到达?endStation?的行程。
 * 调用?getAverageTime?时，询问的路线至少包含一趟行程。
 * 你可以假设所有对?checkIn?和?checkOut?的调用都是符合逻辑的。也就是说，如果一个顾客在 t1?时刻到达某个地铁站，那么他离开的时间?t2?一定满足?t2 > t1?。所有的事件都按时间顺序给出。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
 * [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
 * <p>
 * 输出：
 * [null,null,null,null,null,null,null,14.0,11.0,null,11.0,null,12.0]
 * <p>
 * 解释：
 * UndergroundSystem undergroundSystem = new UndergroundSystem();
 * undergroundSystem.checkIn(45, "Leyton", 3);
 * undergroundSystem.checkIn(32, "Paradise", 8);
 * undergroundSystem.checkIn(27, "Leyton", 10);
 * undergroundSystem.checkOut(45, "Waterloo", 15);
 * undergroundSystem.checkOut(27, "Waterloo", 20);
 * undergroundSystem.checkOut(32, "Cambridge", 22);
 * undergroundSystem.getAverageTime("Paradise", "Cambridge");       // 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
 * undergroundSystem.checkIn(10, "Leyton", 24);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
 * undergroundSystem.checkOut(10, "Waterloo", 38);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 12.0
 * ?
 * <p>
 * 提示：
 * <p>
 * 总共最多有?20000?次操作。
 * 1 <= id, t <= 10^6
 * 所有的字符串包含大写字母，小写字母和数字。
 * 1 <=?stationName.length <= 10
 * 与标准答案误差在?10^-5?以内的结果都视为正确结果。
 * 通过次数3,260提交次数7,288
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-underground-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UndergroundSystem {

    private final Map<String, Integer> time;
    private final Map<String, Integer> count;
    private final Map<Integer, Integer> idToTime;
    private final Map<Integer, String> idToStation;

    public UndergroundSystem() {
        time = new HashMap<>();
        count = new HashMap<>();
        idToTime = new HashMap<>();
        idToStation = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idToTime.put(id, t);
        idToStation.put(id, stationName);
    }

    public void checkOut(int id, String stationName, int t) {
        int startTime = idToTime.get(id);
        String startStation = idToStation.get(id);
        String stationInfo = startStation + stationName;
        time.put(stationInfo, time.getOrDefault(stationInfo, 0) + t - startTime);
        count.put(stationInfo, count.getOrDefault(stationInfo, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String stationInfo = startStation + endStation;
        return time.get(stationInfo) * 1.0 / count.get(stationInfo);
    }
}
