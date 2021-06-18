package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ��� ��ָ ǡ�ð���������ͬ��Ʒ ��һ�ͣ�����ζ�̶�֮�͵��� 2 ���ݡ�
 * <p>
 * ����Դ��� ���� ������Ʒ��һ�ٴ�͡�
 * <p>
 * ����һ���������� deliciousness ������ deliciousness[i] �ǵ� i ����Ʒ����ζ�̶ȣ�����������������еĲ�Ʒ�����Ĳ�ͬ ��� �������������Ҫ�� 109 + 7 ȡ�ࡣ
 * <p>
 * ע�⣬ֻҪ��Ʒ�±겻ͬ���Ϳ�����Ϊ�ǲ�ͬ�Ĳ�Ʒ���������ǵ���ζ�̶���ͬ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺deliciousness = [1,3,5,7,9]
 * �����4
 * ���ͣ���͵���ζ�̶����Ϊ (1,3) ��(1,7) ��(3,5) �� (7,9) ��
 * ���Ǹ��Ե���ζ�̶�֮�ͷֱ�Ϊ 4 ��8 ��8 �� 16 ������ 2 ���ݡ�
 * ʾ�� 2��
 * <p>
 * ���룺deliciousness = [1,1,1,3,3,3,7]
 * �����15
 * ���ͣ���͵���ζ�̶����Ϊ 3 �� (1,1) ��9 �� (1,3) ���� 3 �� (1,7) ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 * ͨ������5,537�ύ����21,845
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-good-meals
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountPairs22 {

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int answer = 0;
        for (int num : deliciousness) {
            int powerOfTwo = 1;
            for (int i = 0; i <= 21; i++) {
                if (powerOfTwo >= num) {
                    Integer value = map.get(powerOfTwo - num);
                    if (value != null) {
                        answer += value;
                        answer %= mod;
                    }
                }
                powerOfTwo *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        CountPairs22 countPairs22 = new CountPairs22();
        System.out.println(countPairs22.countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println(countPairs22.countPairs(new int[]{1048576, 1048576}));
    }
}
