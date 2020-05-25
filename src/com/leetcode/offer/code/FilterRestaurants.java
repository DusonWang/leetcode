package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ���͹���Ϣ����?restaurants������??restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]�������ʹ������������������������Щ�͹���Ϣ��
 * <p>
 * ������ʳ���Ѻù�����?veganFriendly?��ֵ����Ϊ true ���� false�����Ϊ true?����ζ����Ӧ��ֻ����?veganFriendlyi?Ϊ true �Ĳ͹ݣ�Ϊ?false?����ζ�ſ��԰����κβ͹ݡ����⣬���ǻ������۸�?maxPrice?��������?maxDistance?���������������Ƿֱ��ǲ����ļ۸����غ;������ص����ֵ��
 * <p>
 * ���˺󷵻ز͹ݵ� id������ rating?�Ӹߵ���������� rating ��ͬ����ô�� id �Ӹߵ������򡣼������?veganFriendlyi �� veganFriendly?Ϊ?true?ʱȡֵΪ 1��Ϊ false ʱ��ȡֵΪ?0 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 1, maxPrice = 50, maxDistance = 10
 * �����[3,1,5]
 * ���ͣ�
 * ��Щ�͹�Ϊ��
 * �͹� 1 [id=1, rating=4, veganFriendly=1, price=40, distance=10]
 * �͹� 2 [id=2, rating=8, veganFriendly=0, price=50, distance=5]
 * �͹� 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4]
 * �͹� 4 [id=4, rating=10, veganFriendly=0, price=10, distance=3]
 * �͹� 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1]
 * �ڰ��� veganFriendly = 1, maxPrice = 50 �� maxDistance = 10 ���й��˺����ǵõ��˲͹� 3, �͹� 1 �� �͹� 5�������ִӸߵ������򣩡�
 * ʾ�� 2��
 * <p>
 * ���룺restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 0, maxPrice = 50, maxDistance = 10
 * �����[4,3,2,1,5]
 * ���ͣ��͹���ʾ�� 1 ��ͬ������ veganFriendly = 0 �Ĺ��������£�Ӧ�ÿ������в͹ݡ�
 * ʾ�� 3��
 * <p>
 * ���룺restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 0, maxPrice = 30, maxDistance = 3
 * �����[4,5]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <=?restaurants.length <= 10^4
 * restaurants[i].length == 5
 * 1 <=?idi, ratingi, pricei, distancei <= 10^5
 * 1 <=?maxPrice,?maxDistance <= 10^5
 * veganFriendlyi ��?veganFriendly?��ֵΪ 0 �� 1 ��
 * ���� idi ������ͬ��
 * ͨ������2,334�ύ����4,627
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FilterRestaurants {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList<>();
        Arrays.stream(restaurants)
                .filter(restaurant ->
                        ((veganFriendly == 1 && restaurant[2] == 1) || veganFriendly == 0)
                                && restaurant[3] <= maxPrice
                                && restaurant[4] <= maxDistance)
                .sorted((r1, r2) -> r1[1] == r2[1] ? -r1[0] + r2[0] : -r1[1] + r2[1])
                .forEach(restaurant -> result.add(restaurant[0]));
        return result;
    }
}
