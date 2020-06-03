package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * ����һ������ orders����ʾ�ͻ��ڲ�������ɵĶ�����ȷ�е�˵�� orders[i]=[customerNamei,tableNumberi,foodItemi] ������ customerNamei �ǿͻ���������tableNumberi �ǿͻ����ڲ��������ţ��� foodItemi �ǿͻ���Ĳ�Ʒ���ơ�
 * <p>
 * ���㷵�ظò����� ���չʾ�� �������ű��У����е�һ��Ϊ���⣬���һ��Ϊ�������� ��Table�� ������ÿһ�ж��ǰ���ĸ˳�����еĲ�Ʒ���ơ�������ÿһ���е������ʾÿ�Ų�����������Ӧ��Ʒ��������һ��Ӧ�����Ӧ�����ţ�����������д�µ��Ĳ�Ʒ������
 * <p>
 * ע�⣺�ͻ��������ǵ��չʾ���һ���֡����⣬���е�������Ӧ�ð����������������С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * �����[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * ���ͣ�
 * ���չʾ��������ʾ��
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * ���ڲ��� 3��David ���� "Ceviche" �� "Fried Chicken"���� Rous ���� "Ceviche"
 * ������ 5��Carla ���� "Water" �� "Ceviche"
 * ���� 10��Corina ���� "Beef Burrito"
 * ʾ�� 2��
 * <p>
 * ���룺orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
 * �����[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * ���ͣ�
 * ���ڲ��� 1��Adam �� Brianna ������ "Canadian Waffles"
 * ������ 12��James, Ratesh �� Amadeus ������ "Fried Chicken"
 * ʾ�� 3��
 * <p>
 * ���룺orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
 * �����[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <=?orders.length <= 5 * 10^4
 * orders[i].length == 3
 * 1 <= customerNamei.length, foodItemi.length <= 20
 * customerNamei �� foodItemi �ɴ�СдӢ����ĸ���ո��ַ� ' ' ��ɡ�
 * tableNumberi �� 1 �� 500 ��Χ�ڵ�������
 * ͨ������3,936�ύ����6,942
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class DisplayTable {

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<>();
        Set<String> food = new TreeSet<>();
        Map<String, Integer> map = new TreeMap<>();
        Set<Integer> number = new TreeSet<>();
        for (List<String> order : orders) {
            food.add(order.get(2));
            number.add(Integer.valueOf(order.get(1)));
            String tmp = order.get(1) + "+" + order.get(2);
            if (map.get(tmp) == null) {
                map.put(tmp, 1);
            } else {
                map.put(tmp, map.get(tmp) + 1);
            }
        }
        List<String> table = new ArrayList<>();
        table.add("Table");
        table.addAll(food);
        result.add(table);
        for (Integer k : number) {
            List<String> row = new ArrayList<>();
            row.add(k + "");
            for (String s : food) {
                String key = k + "+" + s;
                if (map.get(key) != null) {
                    row.add(String.valueOf(map.get(key)));
                } else {
                    row.add("0");
                }
            }
            result.add(row);
        }
        return result;
    }
}
