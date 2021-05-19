package code.code;

/**
 * ����һ���ַ��� s ��һ���������� cost ������ cost[i] �Ǵ� s ��ɾ���ַ� i �Ĵ��ۡ�
 * <p>
 * ����ʹ�ַ�����������������ĸ����ͬ����Сɾ���ɱ���
 * <p>
 * ��ע�⣬ɾ��һ���ַ���ɾ�������ַ��ĳɱ�����ı䡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "abaac", cost = [1,2,3,4,5]
 * �����3
 * ���ͣ�ɾ����ĸ "a" �ĳɱ�Ϊ 3��Ȼ��õ� "abac"���ַ���������������ĸ����ͬ����
 * ʾ�� 2��
 * <p>
 * ���룺s = "abc", cost = [1,2,3]
 * �����0
 * ���ͣ�����ɾ���κ���ĸ����Ϊ�ַ����в���������������ĸ��ͬ�������
 * ʾ�� 3��
 * <p>
 * ���룺s = "aabaa", cost = [1,2,3,4,1]
 * �����2
 * ���ͣ�ɾ����һ�������һ����ĸ���õ��ַ��� ("aba") ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <=?10^4
 * s ��ֻ����СдӢ����ĸ
 * ͨ������9,802�ύ����17,006
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinCost4 {

    public int minCost(String s, int[] cost) {
        char[] arr = s.toCharArray();
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                if (cost[i] > cost[i - 1]) {
                    min += cost[i - 1];
                } else {
                    min += cost[i];
                    cost[i] = cost[i - 1];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinCost4 minCost4 = new MinCost4();
        System.out.println(minCost4.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(minCost4.minCost("abc", new int[]{1, 2, 3}));
        System.out.println(minCost4.minCost("aabaa", new int[]{1, 2, 3, 4, 1}));


    }
}
