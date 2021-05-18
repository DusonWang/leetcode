package code.code;

import java.util.Arrays;

/**
 * �� 3n ����Ŀ��һ��Ӳ�ң������������Ǵ��㰴���·�ʽ��Ӳ�ң�
 * <p>
 * ÿһ���У��㽫��ѡ�� ���� 3 ��Ӳ�ң���һ����������
 * Alice ����ȡ��Ӳ������������һ�ѡ�
 * �㽫��ȡ��Ӳ�������ڶ������һ�ѡ�
 * Bob ����ȡ�����һ�ѡ�
 * �ظ�������̣�ֱ��û�и���Ӳ�ҡ�
 * ����һ���������� piles ������ piles[i] �ǵ� i ����Ӳ�ҵ���Ŀ��
 * <p>
 * ��������Ի�õ����Ӳ����Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺piles = [2,4,1,2,7,8]
 * �����9
 * ���ͣ�ѡ�� (2, 7, 8) ��Alice ȡ�� 8 öӲ�ҵ��Ƕѣ���ȡ�� 7 öӲ�ҵ��Ƕѣ�Bob ȡ�����һ�ѡ�
 * ѡ�� (1, 2, 4) , Alice ȡ�� 4 öӲ�ҵ��Ƕѣ���ȡ�� 2 öӲ�ҵ��Ƕѣ�Bob ȡ�����һ�ѡ�
 * ����Ի�õ����Ӳ����Ŀ��7 + 2 = 9.
 * ��������һ����������ѡ������ (1, 2, 8) �� (2, 4, 7) �����ֻ�ܵõ� 2 + 4 = 6 öӲ�ң��ⲻ�����Ž⡣
 * ʾ�� 2��
 * <p>
 * ���룺piles = [2,4,5]
 * �����4
 * ʾ�� 3��
 * <p>
 * ���룺piles = [9,8,7,6,5,1,2,3,4]
 * �����18
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 3 <= piles.length <= 10^5
 * piles.length % 3 == 0
 * 1 <= piles[i] <= 10^4
 * ͨ������10,138�ύ����13,046
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxCoins2 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int length = piles.length;
        int rounds = length / 3;
        int coins = 0;
        int index = length - 2;
        for (int i = 0; i < rounds; i++) {
            coins += piles[index];
            index -= 2;
        }
        return coins;
    }

    public static void main(String[] args) {
        MaxCoins2 maxCoins2 = new MaxCoins2();
        System.out.println(maxCoins2.maxCoins(new int[]{2, 4, 1, 3, 7, 8}));

    }
}
