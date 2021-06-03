package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���ɲ�ͬ����������ɵķǿ����� A�����������ͼ��
 * <p>
 * ��?A.length?���ڵ㣬����?A[0]?��?A[A.length - 1]?��ǣ�
 * ֻ�е� A[i] �� A[j] ����һ������ 1 �Ĺ�����ʱ��A[i]?�� A[j] ֮�����һ���ߡ�
 * ����ͼ�������ͨ����Ĵ�С��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[4,6,15,35]
 * �����4
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺[20,50,9,63]
 * �����2
 * <p>
 * ʾ�� 3��
 * <p>
 * ���룺[2,3,6,7,4,12,21,39]
 * �����8
 * <p>
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 100000
 * ͨ������2,646�ύ����7,712
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/largest-component-size-by-common-factor
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LargestComponentSize {

    public int largestComponentSize(int[] nums) {
        Map<Integer, Integer> parent = new HashMap<>();
        for (int num : nums) {
            for (int fact = 2; fact * fact <= num; fact++) {
                if (num % fact == 0) {
                    union(num, fact, parent);
                    union(num, num / fact, parent);
                }
            }
        }
        int max = 1;
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer v : nums) {
            int f = find(v, parent);
            if (freq.containsKey(f)) {
                freq.put(f, freq.get(f) + 1);
                max = Math.max(max, freq.get(f));
            } else {
                freq.put(f, 1);
            }
        }
        return max;
    }

    public void union(int n, int m, Map<Integer, Integer> p) {
        int findN = find(n, p);
        int findM = find(m, p);
        if (findN < findM) {
            p.put(findM, findN);
        } else {
            p.put(findN, findM);
        }
    }

    public int find(int i, Map<Integer, Integer> parent) {
        parent.putIfAbsent(i, i);
        while (i != parent.get(i)) {
            i = parent.get(i);
        }
        return i;
    }

    public static void main(String[] args) {
        LargestComponentSize largestComponentSize = new LargestComponentSize();
        System.out.println(largestComponentSize.largestComponentSize(new int[]{4, 6, 15, 35}));
    }
}
