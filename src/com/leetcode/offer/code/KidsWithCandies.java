package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������?candies?��һ������?extraCandies?������?candies[i]?����� i ������ӵ�е��ǹ���Ŀ��
 * <p>
 * ��ÿһ�����ӣ�����Ƿ����һ�ַ������������?extraCandies?���ǹ������������֮�󣬴˺����� ���?���ǹ���ע�⣬�����ж������ͬʱӵ�� ���?���ǹ���Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺candies = [2,3,5,1,3], extraCandies = 3
 * �����[true,true,true,false,true]
 * ���ͣ�
 * ���� 1 �� 2 ���ǹ���������õ����ж�����ǹ���3��������ô���ܹ��� 5 ���ǹ���������Ϊӵ������ǹ��ĺ��ӡ�
 * ���� 2 �� 3 ���ǹ���������õ����� 2 �������ǹ�����ô������Ϊӵ������ǹ��ĺ��ӡ�
 * ���� 3 �� 5 ���ǹ������Ѿ���ӵ������ǹ��ĺ��ӡ�
 * ���� 4 �� 1 ���ǹ�����ʹ���õ����ж�����ǹ�����Ҳֻ�� 4 ���ǹ����޷���Ϊӵ���ǹ����ĺ��ӡ�
 * ���� 5 �� 3 ���ǹ���������õ����� 2 �������ǹ�����ô������Ϊӵ������ǹ��ĺ��ӡ�
 * ʾ�� 2��
 * <p>
 * ���룺candies = [4,2,1,1,2], extraCandies = 1
 * �����[true,false,false,false,false]
 * ���ͣ�ֻ�� 1 �������ǹ������Բ��ܶ����ǹ���˭��ֻ�к��� 1 ���Գ�Ϊӵ���ǹ����ĺ��ӡ�
 * ʾ�� 3��
 * <p>
 * ���룺candies = [12,1,12], extraCandies = 10
 * �����[true,false,true]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= candies.length <= 100
 * 1 <= candies[i] <= 100
 * 1 <= extraCandies <= 50
 * ͨ������4,978�ύ����5,910
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies) {
            max = Math.max(max, i);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i : candies) {
            res.add(i + extraCandies >= max);
        }
        return res;
    }

}
