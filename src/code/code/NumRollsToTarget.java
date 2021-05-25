package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ������?d?��һ�������ӣ�ÿ�������϶���?f?���棬�ֱ���Ϊ?1, 2, ..., f��
 * <p>
 * ����Լ���������ӵĵõ��ܵ���Ϊ�������泯�ϵ����ֵ��ܺ͡�
 * <p>
 * �����Ҫ�������ܵ���Ϊ?target�����������ж����ֲ�ͬ�������������е��������ܹ��� f^d �֣���ģ?10^9 + 7?�󷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺d = 1, f = 6, target = 3
 * �����1
 * ʾ�� 2��
 * <p>
 * ���룺d = 2, f = 6, target = 7
 * �����6
 * ʾ�� 3��
 * <p>
 * ���룺d = 2, f = 5, target = 10
 * �����1
 * ʾ�� 4��
 * <p>
 * ���룺d = 1, f = 2, target = 3
 * �����0
 * ʾ�� 5��
 * <p>
 * ���룺d = 30, f = 30, target = 500
 * �����222616187
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 * ͨ������7,441�ύ����15,610
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumRollsToTarget {

    private int MOD = 1000000000 + 7;
    private Map<String, Integer> memo = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {
        if (d == 0 && target == 0) {
            return 1;
        }
        if (d == 0 || target == 0) {
            return 0;
        }
        String str = d + " " + target;
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (target >= i) {
                res = (res + numRollsToTarget(d - 1, f, target - i)) % MOD;
            } else {
                break;
            }
        }
        memo.put(str, res);
        return res;
    }
}
