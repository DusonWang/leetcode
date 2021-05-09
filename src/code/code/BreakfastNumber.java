package code.code;

import java.util.Arrays;

/**
 * С���������м�ѡ����һ�����̯λ��һά�������� staple �м�¼��ÿ����ʳ�ļ۸�һά�������� drinks �м�¼��ÿ�����ϵļ۸�С�۵ļƻ�ѡ��һ����ʳ��һ�����ϣ��һ��Ѳ����� x Ԫ���뷵��С�۹��ж����ֹ��򷽰���
 * <p>
 * ע�⣺����Ҫ�� 1e9 + 7 (1000000007) Ϊ��ȡģ���磺�����ʼ���Ϊ��1000000008���뷵�� 1
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺staple = [10,20,5], drinks = [5,5,2], x = 15
 * <p>
 * �����6
 * <p>
 * ���ͣ�С���� 6 �ֹ��򷽰�����ѡ��ʳ����ѡ�����������ж�Ӧ���±�ֱ��ǣ�
 * �� 1 �ַ�����staple[0] + drinks[0] = 10 + 5 = 15��
 * �� 2 �ַ�����staple[0] + drinks[1] = 10 + 5 = 15��
 * �� 3 �ַ�����staple[0] + drinks[2] = 10 + 2 = 12��
 * �� 4 �ַ�����staple[2] + drinks[0] = 5 + 5 = 10��
 * �� 5 �ַ�����staple[2] + drinks[1] = 5 + 5 = 10��
 * �� 6 �ַ�����staple[2] + drinks[2] = 5 + 2 = 7��
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺staple = [2,1,1], drinks = [8,9,5,1], x = 9
 * <p>
 * �����8
 * <p>
 * ���ͣ�С���� 8 �ֹ��򷽰�����ѡ��ʳ����ѡ�����������ж�Ӧ���±�ֱ��ǣ�
 * �� 1 �ַ�����staple[0] + drinks[2] = 2 + 5 = 7��
 * �� 2 �ַ�����staple[0] + drinks[3] = 2 + 1 = 3��
 * �� 3 �ַ�����staple[1] + drinks[0] = 1 + 8 = 9��
 * �� 4 �ַ�����staple[1] + drinks[2] = 1 + 5 = 6��
 * �� 5 �ַ�����staple[1] + drinks[3] = 1 + 1 = 2��
 * �� 6 �ַ�����staple[2] + drinks[0] = 1 + 8 = 9��
 * �� 7 �ַ�����staple[2] + drinks[2] = 1 + 5 = 6��
 * �� 8 �ַ�����staple[2] + drinks[3] = 1 + 1 = 2��
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= staple.length <= 10^5
 * 1 <= drinks.length <= 10^5
 * 1 <= staple[i],drinks[i] <= 10^5
 * 1 <= x <= 2*10^5
 * ͨ������14,630�ύ����52,851
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/2vYnGI
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BreakfastNumber {

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int cnt = 0;
        int m = staple.length;
        int n = drinks.length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                cnt = (cnt + j + 1) % 1000000007;
                i++;
            } else {
                j--;
            }
        }
        return cnt % 1000000007;
    }

    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        int result = 0;
        int[] arr = new int[x];
        for (int j : staple) {
            if (j < x) {
                arr[j]++;
            }
        }
        for (int i = 1; i < x; i++) {
            arr[i] += arr[i - 1];
        }
        for (int drink : drinks) {
            if (drink < x) {
                result += arr[x - drink];
                if (result >= 1000000007) {
                    result -= 1000000007;
                }
            }
        }
        return result;
    }
}
