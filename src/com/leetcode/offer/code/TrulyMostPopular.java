package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ÿ�꣬�������ṫ��һ��������Ӥ�����ֺ����ǳ��ֵ�Ƶ�ʣ�Ҳ����ͬ��Ӥ������������Щ�����ж���ƴ�������磬John �� Jon ����������ͬ�����֣������������������ֹ������������������б�һ�������ּ���Ӧ��Ƶ�ʣ���һ���Ǳ�����ͬ�����ֶԡ����һ���㷨��ӡ��ÿ����ʵ���ֵ�ʵ��Ƶ�ʡ�ע�⣬��� John �� Jon ����ͬ�ģ����� Jon �� Johnny ��ͬ���� John �� Johnny Ҳ��ͬ���������д��ݺͶԳ��ԡ�
 * <p>
 * �ڽ���б��У�ѡ���ֵ�����С��������Ϊ��ʵ���֡�
 * <p>
 * ʾ����
 * <p>
 * ���룺names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * �����["John(27)","Chris(36)"]
 * ��ʾ��
 * <p>
 * names.length <= 100000
 * ͨ������1,272�ύ����3,504
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/baby-names-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TrulyMostPopular {

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, String> nameMap = new HashMap<>();
        for (String synonym : synonyms) {
            String[] temp = synonym.replace("(", "").replace(")", "").split(",");
            String last1 = getLast(temp[1], nameMap);
            String last0 = getLast(temp[0], nameMap);
            if (last0.compareTo(last1) > 0) {
                nameMap.put(last0, last1);
            } else if (last0.compareTo(last1) < 0) {
                nameMap.put(last1, last0);
            }
        }
        Map<String, Integer> resCount = new HashMap<>();
        for (String nameInfo : names) {
            String name = nameInfo.split("\\(")[0];
            int count = Integer.parseInt(nameInfo.split("\\(")[1].replace(")", ""));
            String last = getLast(name, nameMap);
            resCount.putIfAbsent(last, 0);
            resCount.put(last, resCount.get(last) + count);
        }
        String[] res = new String[resCount.size()];
        int index = 0;
        for (String key : resCount.keySet()) {
            res[index++] = key + "(" + resCount.get(key) + ")";
        }
        return res;
    }

    private String getLast(String name, Map<String, String> nameMap) {
        String temp = name;
        while (nameMap.get(temp) != null) {
            temp = nameMap.get(temp);
        }
        return temp;
    }
}
