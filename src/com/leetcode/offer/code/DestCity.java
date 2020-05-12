package com.leetcode.offer.code;

import java.util.HashSet;
import java.util.List;

/**
 * @author duson
 * ����һ��������·ͼ������·ͼ�е�������·������ paths ��ʾ������ paths[i] = [cityAi, cityBi] ��ʾ����·����� cityAi ֱ��ǰ�� cityBi �������ҳ�������е��յ�վ����û���κο���ͨ���������е���·�ĳ��С�
 * <p>
 * ��Ŀ���ݱ�֤��·ͼ���γ�һ��������ѭ������·�����ֻ����һ�������յ�վ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * �����"Sao Paulo"
 * ���ͣ��� "London" ���������ִ��յ�վ "Sao Paulo" ���������е�·���� "London" -> "New York" -> "Lima" -> "Sao Paulo" ��
 * ʾ�� 2��
 * <p>
 * ���룺paths = [["B","C"],["D","B"],["C","A"]]
 * �����"A"
 * ���ͣ����п��ܵ���·�ǣ�
 * "D" -> "B" -> "C" -> "A".?
 * "B" -> "C" -> "A".?
 * "C" -> "A".?
 * "A".?
 * ��Ȼ�������յ�վ�� "A" ��
 * ʾ�� 3��
 * <p>
 * ���룺paths = [["A","Z"]]
 * �����"Z"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <=?cityAi.length,?cityBi.length <= 10
 * cityAi?!=?cityBi
 * �����ַ������ɴ�СдӢ����ĸ�Ϳո��ַ���ɡ�
 * ͨ������4,375�ύ����5,388
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/destination-city
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class DestCity {

    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}
