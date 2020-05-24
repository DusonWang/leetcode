package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����һЩ�����б�?regions ��ÿ���б�ĵ�һ�����򶼰�������б���������������
 * <p>
 * ����Ȼ�أ��������?X ��������?Y ����ô����?X ?������?Y ��
 * <p>
 * ������������?region1?��?region2 ���ҵ�ͬʱ���������������?��С?����
 * <p>
 * ��������б���?r1?����?r2?��?r3 ����ô���ݱ�֤?r2 �������?r3?��
 * <p>
 * ����ͬ����֤��С��������һ�����ڡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺
 * regions = [["Earth","North America","South America"],
 * ["North America","United States","Canada"],
 * ["United States","New York","Boston"],
 * ["Canada","Ontario","Quebec"],
 * ["South America","Brazil"]],
 * region1 = "Quebec",
 * region2 = "New York"
 * �����"North America"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= regions.length <= 10^4
 * region1 != region2
 * �����ַ���ֻ����Ӣ����ĸ�Ϳո������ֻ��?20 ����ĸ��
 * ͨ������1,053�ύ����2,038
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/smallest-common-region
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindSmallestRegion {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        if (null == regions || regions.size() == 0) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        for (List<String> regionList : regions) {
            String parentRegion = regionList.get(0);
            for (int i = 1; i < regionList.size(); i++) {
                map.put(regionList.get(i), parentRegion);
            }
        }
        List<String> parent1List = find(region1, map);
        List<String> parent2List = find(region2, map);
        for (String p : parent1List) {
            if (parent2List.contains(p)) {
                return p;
            }
        }
        return "";
    }

    private List<String> find(String region, Map<String, String> map) {
        String parent1 = region;
        List<String> parent1List = new ArrayList<>();
        while (parent1 != null) {
            parent1List.add(parent1);
            parent1 = map.get(parent1);
        }
        return parent1List;
    }
}
