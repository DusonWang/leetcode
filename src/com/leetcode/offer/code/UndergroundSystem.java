package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * ����ʵ��һ����?UndergroundSystem?����֧������ 3 �ַ�����
 * <p>
 * 1.?checkIn(int id, string stationName, int t)
 * <p>
 * ���Ϊ?id?�ĳ˿��� t?ʱ�̽������վ?stationName?��
 * һ���˿���ͬһʱ��ֻ����һ������վ��������뿪��
 * 2.?checkOut(int id, string stationName, int t)
 * <p>
 * ���Ϊ?id?�ĳ˿��� t?ʱ���뿪����վ stationName?��
 * 3.?getAverageTime(string startStation, string endStation)?
 * <p>
 * ���شӵ���վ?startStation?������վ?endStation?��ƽ������ʱ�䡣
 * ƽ��ʱ�������г̰�����ǰΪֹ���д�?startStation?ֱ�ӵ���?endStation?���г̡�
 * ����?getAverageTime?ʱ��ѯ�ʵ�·�����ٰ���һ���г̡�
 * ����Լ������ж�?checkIn?��?checkOut?�ĵ��ö��Ƿ����߼��ġ�Ҳ����˵�����һ���˿��� t1?ʱ�̵���ĳ������վ����ô���뿪��ʱ��?t2?һ������?t2 > t1?�����е��¼�����ʱ��˳�������
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
 * [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
 * <p>
 * �����
 * [null,null,null,null,null,null,null,14.0,11.0,null,11.0,null,12.0]
 * <p>
 * ���ͣ�
 * UndergroundSystem undergroundSystem = new UndergroundSystem();
 * undergroundSystem.checkIn(45, "Leyton", 3);
 * undergroundSystem.checkIn(32, "Paradise", 8);
 * undergroundSystem.checkIn(27, "Leyton", 10);
 * undergroundSystem.checkOut(45, "Waterloo", 15);
 * undergroundSystem.checkOut(27, "Waterloo", 20);
 * undergroundSystem.checkOut(32, "Cambridge", 22);
 * undergroundSystem.getAverageTime("Paradise", "Cambridge");       // ���� 14.0���� "Paradise"��ʱ�� 8���� "Cambridge"(ʱ�� 22)���г�ֻ��һ��
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // ���� 11.0���ܹ��� 2 �ɴ� "Leyton" �� "Waterloo" ���г̣����Ϊ id=45 �ĳ˿ͳ����� time=3 ������ time=15�����Ϊ id=27 �ĳ˿��� time=10 ������ time=20 �������ƽ��ʱ��Ϊ ( (15-3) + (20-10) ) / 2 = 11.0
 * undergroundSystem.checkIn(10, "Leyton", 24);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // ���� 11.0
 * undergroundSystem.checkOut(10, "Waterloo", 38);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // ���� 12.0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * �ܹ������?20000?�β�����
 * 1 <= id, t <= 10^6
 * ���е��ַ���������д��ĸ��Сд��ĸ�����֡�
 * 1 <=?stationName.length <= 10
 * ���׼�������?10^-5?���ڵĽ������Ϊ��ȷ�����
 * ͨ������3,260�ύ����7,288
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/design-underground-system
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
